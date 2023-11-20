package data_access;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

// added the json jar library in order to import this
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class SpotifyAuthenticationDataAccessObject {
    private static final String CLIENT_ID = "7af39c08f4c242b89347deca0538bbb1";
    private static final String CLIENT_SECRET = "c85c0140606943c698f2cddaf49b082e";
    private static final String REDIRECT_URI = "http://localhost:8080/callback";
    private static final String scope = "playlist-read-private playlist-read-collaborative";
    private static final String tokenUrl = "https://accounts.spotify.com/api/token";

    public void getAccessToken() throws IOException {
        // Redirect the user to the authorization URL
        String authUrl = "https://accounts.spotify.com/authorize";
        String state = generateRandomState();
        String authRedirectUrl = authUrl + "?client_id=" + CLIENT_ID + "&response_type=code&redirect_uri=" + REDIRECT_URI
                + "&scope=" + scope + "&state=" + state;
        System.out.println("Please go to this URL to authorize: " + authRedirectUrl);

        // Start a local server to receive the callback
        startLocalServer();
    }

    private static void startLocalServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/callback", new SpotifyAuthenticationDataAccessObject.CallbackHandler());
        server.setExecutor(null);
        server.start();
    }

    static class CallbackHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            URI requestUri = exchange.getRequestURI();
            String query = requestUri.getQuery();

            // Extract the authorization code from the callback URL
            String authorizationCode = extractAuthorizationCode(query);

            // Perform the token exchange using the authorization code
            String accessToken = exchangeAccessToken(authorizationCode);
            System.out.println(accessToken);

            String response = "Authorization code received successfully. You can close this window.";
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }

            // Stop the local server after receiving the callback
            exchange.getHttpContext().getServer().stop(0);
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

        public String exchangeAccessToken(String authorizationCode) {
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

    // Generates a random and unique state parameter for the OAuth 2.0 authorization request
    private static String generateRandomState() {
        byte[] bytes = new byte[16];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}
