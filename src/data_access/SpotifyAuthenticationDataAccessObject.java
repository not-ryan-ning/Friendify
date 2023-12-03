package data_access;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

// added the json jar library in order to import this
import org.json.JSONObject;
import use_case.authorize.AuthorizeSpotifyAuthenticationDataAccessInterface;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
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
    private static final String tokenUrl = "https://accounts.spotify.com/api/token";

    public String getAccessToken() {
        try {
            return startLocalServer();
        } catch (Exception e) {
            return null;
        }
    }

    // Start a local HTTP server to receive the callback from the Spotify authorization process
    private String startLocalServer() throws IOException {
        // Redirect URI: http://localhost:8080/callback
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
            String accessToken = exchangeAccessToken(authorizationCode);

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
                // Sleep for a short duration before checking again
                try {
                    Thread.sleep(1000); // Sleep for 1 second (adjust as needed)
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

        private String exchangeAccessToken(String authorizationCode) throws IOException{
            return new AccessTokenExchanger().exchange(authorizationCode);
        }
    }

    // Put the concrete method in a separate class to align with Single Responsibility Principle
    private static class AccessTokenExchanger {
        public String exchange(String authorizationCode) throws IOException {
            String tokenRequestBody = "grant_type=authorization_code&code=" + authorizationCode + "&redirect_uri=" + REDIRECT_URI;
            String authHeader = Base64.getEncoder().encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes());

            HttpRequest tokenRequest = HttpRequest.newBuilder()
                    .uri(URI.create(tokenUrl))
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
}
