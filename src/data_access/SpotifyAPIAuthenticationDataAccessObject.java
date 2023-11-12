package data_access;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.util.Base64;

public class SpotifyAPIAuthenticationDataAccessObject {
    private static final String CLIENT_ID = "7af39c08f4c242b89347deca0538bbb1";
    private static final String CLIENT_SECRET = "c85c0140606943c698f2cddaf49b082e";
    private static final String REDIRECT_URI = "https://github.com/not-ryan-ning/Friendify";
    private static final String scope = "playlist-read-private playlist-read-collaborative";
    private static final String authUrl = "https://accounts.spotify.com/authorize";
    private static final String tokenUrl = "https://accounts.spotify.com/api/token";

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

    public String getAccessToken(String authorizationCode) {
        String tokenRequestBody = "grant_type=authorization_code&code=" + authorizationCode + "&redirect_uri=" + REDIRECT_URI;
        String authHeader = Base64.getEncoder().encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes());
        HttpClient httpClient = HttpClient.newHttpClient();

        // Header Parameters:
        // Authorization = 'Authorization': 'Basic' + <base64 encoded client_id:client_secret>
        // Content-Type = 'content-type': 'application/x-www-form-urlencoded'
        HttpRequest tokenRequest = HttpRequest.newBuilder()
                .uri(URI.create(tokenUrl))
                .header("Authorization", "Basic " + authHeader)
                .header("Content-Type", "application/x-www-form-urlencoded")
                // Specifies that the request method is POST (for exchanging an authorization code for an access token)
                .POST(HttpRequest.BodyPublishers.ofString(tokenRequestBody))
                .build();

        try {
            HttpResponse<String> tokenResponse = httpClient.send(tokenRequest, HttpResponse.BodyHandlers.ofString());

            if (tokenResponse.statusCode() == 200) {
                // responseBody will have a JSON-formatted response
                String responseBody = tokenResponse.body();
                JSONObject jsonResponse = new JSONObject(responseBody);
                String access_token = jsonResponse.getString("access_token");

                // need to figure out how refresh token works
                String refreshToken = null;
                if (responseBody.contains("refresh_token")) {
                    refreshToken = jsonResponse.getString("refresh_token");
                }
                return access_token;
            } else {
                System.out.println("Error obtaining access token. Status code: " + tokenResponse.statusCode() + ", Response: " + tokenResponse.body());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String regenerateAccessTokenFromRefreshToken(String refreshToken) {
        return "";
    }

    private static String generateRandomState() {
        byte[] bytes = new byte[16];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

}
