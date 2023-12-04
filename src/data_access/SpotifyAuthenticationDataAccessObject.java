package data_access;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.json.JSONObject;
import use_case.authorize.AuthorizeSpotifyAuthenticationDataAccessInterface;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class SpotifyAuthenticationDataAccessObject implements AuthorizeSpotifyAuthenticationDataAccessInterface {
    private static final String CLIENT_ID = "7af39c08f4c242b89347deca0538bbb1";
    private static final String CLIENT_SECRET = "c85c0140606943c698f2cddaf49b082e";
    private static final String REDIRECT_URI = "http://localhost:8080/callback";
    private static final String TOKEN_URL = "https://accounts.spotify.com/api/token";

    public String getAccessToken(String authorizationLink) throws IOException {
        openWebLink(authorizationLink);

        // Start a local server to receive the callback
        return startLocalServer();
    }

    private String startLocalServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        CallbackHandler callbackHandler = new CallbackHandler();
        server.createContext("/callback", callbackHandler);
        server.setExecutor(null);
        server.start();

        // Wait for the callback and retrieve the access token
        String accessToken = callbackHandler.waitForAccessToken();

        // Stop the local server after receiving the callback
        server.stop(0);

        return accessToken;
    }

    static class CallbackHandler implements HttpHandler {
        private String accessToken;

        /**
         * Handles an HTTP exchange by extracting the authorization code from the callback URL,
         * performing token exchange using the authorization code, and sending an HTTP response.
         *
         * @param exchange the exchange containing the request from the
         *                 client and used to send the response
         * @throws IOException
         */
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            URI requestUri = exchange.getRequestURI();
            String query = requestUri.getQuery();

            // Extract the authorization code from the callback URL
            String authorizationCode = extractAuthorizationCode(query);

            // Perform the token exchange using the authorization code
            accessToken = exchangeAccessToken(authorizationCode);

            String response = "Authorization code received successfully. You can close this window.";
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }

        /**
         * This method will be called by startLocalServer to wait for the access token
         * @return A string representing access token.
         */
        public String waitForAccessToken() {
            while (accessToken == null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            return accessToken;
        }

        private String extractAuthorizationCode(String query) {
            String[] queryParams = query.split("&");
            Map<String, String> paramMap = new HashMap<>();

            for (String param : queryParams) {
                String[] keyValue = param.split("=");
                paramMap.put(keyValue[0], keyValue[1]);
            }

            return paramMap.get("code");
        }

        private String exchangeAccessToken(String authorizationCode) throws IOException {
            return new AccessTokenExchanger().exchange(authorizationCode);
        }
    }

    private static class AccessTokenExchanger {
        /**
         * Gets access token from Spotify API using authorization code
         * @param authorizationCode Code needed to get access token
         * @return String representing access token
         * @throws IOException
         */
        public String exchange(String authorizationCode) throws IOException {
            String tokenRequestBody = "grant_type=authorization_code&code=" + authorizationCode + "&redirect_uri=" + REDIRECT_URI;
            String authHeader = Base64.getEncoder().encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes());

            HttpRequest tokenRequest = HttpRequest.newBuilder()
                    .uri(URI.create(TOKEN_URL))
                    .header("Authorization", "Basic " + authHeader)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(tokenRequestBody))
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();

            try {
                HttpResponse<String> response = httpClient.send(tokenRequest, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    String responseBody = response.body();
                    JSONObject jsonResponse = new JSONObject(responseBody);
                    return jsonResponse.getString("access_token");
                } else {
                    System.out.println("Error obtaining access token. Status code: " + response.statusCode() +
                            ", Response: " + response.body());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private static void openWebLink(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }
}
