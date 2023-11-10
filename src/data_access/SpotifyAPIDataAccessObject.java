package data_access;

import use_case.matching.SpotifyAPIDataAccessInterface;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;

public class SpotifyAPIDataAccessObject implements SpotifyAPIDataAccessInterface {
    private static final String CLIENT_ID = "7af39c08f4c242b89347deca0538bbb1";
    private static final String CLIENT_SECRET = "c85c0140606943c698f2cddaf49b082e";
    private static final String REDIRECT_URI = "https://github.com/not-ryan-ning/Friendify";
    private String ACCESS_TOKEN;
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

    // Set access token using the authorization code
    public void setAccessToken(String authorizationCode) {
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
                .POST(HttpRequest.BodyPublishers.ofString(tokenRequestBody))
                .build();

        try {
            HttpResponse<String> tokenResponse = httpClient.send(tokenRequest, HttpResponse.BodyHandlers.ofString());

            if (tokenResponse.statusCode() == 200) {
                // responseBody will have a JSON-formatted response
                /*
                {
                    "access_token": "your_access_token",
                    "token_type": "Bearer",
                    "expires_in": 3600,
                    "refresh_token": "your_refresh_token",
                    "scope": "playlist-read-private"
                }
                 */
                String responseBody = tokenResponse.body();
                String accessToken = responseBody.split("\"access_token\":\"")[1].split("\"")[0];
                ACCESS_TOKEN = accessToken;

                String refreshToken = null;
                if (responseBody.contains("refresh_token")) {
                    refreshToken = responseBody.split("\"refresh_token\":\"")[1].split("\"")[0];
                }
            } else {
                System.out.println("Error obtaining access token. Status code: " + tokenResponse.statusCode() + ", Response: " + tokenResponse.body());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> getArtists() {
        ArrayList<String> artists = new ArrayList<String>();
        return artists;
    }

    @Override
    public ArrayList<String> getTitles() {
        ArrayList<String> titles = new ArrayList<String>();
        return titles;
    }

    @Override
    public double getAcousticness(String playlistId) {
        return -1.0;
    }

    @Override
    public double getEnergy(String playlistId) {
        return -1.0;
    }

    @Override
    public double getInstrumentalness(String playlistId) {
        return -1.0;
    }

    @Override
    public double getValence(String playlistId) {
        return -1.0;
    }

    @Override
    public String getGenre(String playlistId) {
        return "iu";
    }

    // Generates a random and unique state parameter for the OAuth 2.0 authorization request
    private static String generateRandomState() {
        byte[] bytes = new byte[16];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}
