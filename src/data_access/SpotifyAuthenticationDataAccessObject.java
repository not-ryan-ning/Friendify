package data_access;

// added the json jar library in order to import this
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.util.Base64;

public class SpotifyAuthenticationDataAccessObject {
    private static final String CLIENT_ID = "7af39c08f4c242b89347deca0538bbb1";
    private static final String CLIENT_SECRET = "c85c0140606943c698f2cddaf49b082e";
    private static final String REDIRECT_URI = "https://github.com/not-ryan-ning/Friendify";
    private static final String scope = "playlist-read-private playlist-read-collaborative";
    private static final String authUrl = "https://accounts.spotify.com/authorize";
    private static final String tokenUrl = "https://accounts.spotify.com/api/token";

    // Get the authorization URL
    public String getRequestUserAuthorizationUrl() {
        String state = generateRandomState();
        return authUrl + "?client_id=" + CLIENT_ID + "&response_type=code&redirect_uri=" + REDIRECT_URI +
                "&scope=" + scope + "&state=" + state;
    }

    // Redirect the user to the authorization URL and extract the authorization code after the user grants permission
    public String getAuthorizationCode(String authorizationUrl) {
        String authCode = ""; // Implement this
        return authCode;
    }

    // Get access token using the authorization code
    public String getAccessToken(String authorizationCode) {
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

    // Generates a random and unique state parameter for the OAuth 2.0 authorization request
    private static String generateRandomState() {
        byte[] bytes = new byte[16];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}
