package data_access;

// added the json jar library in order to import this
import org.json.JSONObject;
import org.json.JSONArray;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

public class SpotifyAPIDataAccessObject {
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

    // Set access token using the authorization code
    public String getAccessToken(String authorizationCode) {
        String tokenRequestBody = "grant_type=authorization_code&code=" + authorizationCode + "&redirect_uri=" + REDIRECT_URI;
        String authHeader = Base64.getEncoder().encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes());
        HttpClient httpClient = HttpClient.newHttpClient();

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
                return jsonResponse.getString("access_token");
            } else {
                System.out.println("Error obtaining access token. Status code: " + tokenResponse.statusCode() + ", Response: " + tokenResponse.body());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Return all the playlists the user has - probably need this when asking the user to choose one of their playlists (edit profile use case)
    // hashMap <playlistId, playlistName>
    public HashMap<String, String> getPlaylists(String access_token) {
        String playlistUrl = "https://api.spotify.com/v1/me/playlists";
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(playlistUrl))
                .header("Authorization", "Bearer " + access_token)
                .GET()
                .build();

        try {
            HashMap<String, String> playlists = new HashMap<>();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                JSONObject jsonResponse = new JSONObject(responseBody);

                // Access the 'items' array - each item is a playlist
                JSONArray itemsArray = jsonResponse.getJSONArray("items");

                for (int i = 0; i < itemsArray.length(); i++) {
                    JSONObject playlistObject = itemsArray.getJSONObject(i);
                    String playlistId = playlistObject.getString("id");
                    String playlistName = playlistObject.getString("name");
                    playlists.put(playlistId, playlistName);
                }
            } else {
                System.out.println("Error getting user playlists. Status code: " + response.statusCode() +
                        ", Response: " + response.body());
            }
            // fileUserDateAccessObject.storePlaylists(userName, playlists);
            return playlists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // obtain all information about the chosen playlist from the API and store it in the playlist csv file and the users csv file (playlist id only)
    public void storePlaylistInfo(String username, String playlistId, String access_token) {
        ArrayList<String> trackIds = getTrackIds(playlistId);
        ArrayList<String> artists = getArtists(trackIds);
        ArrayList<String> titles = getTitles(trackIds);
        double acousticness = getAcousticness(trackIds);
        double energy = getEnergy(trackIds);
        double instrumentalness = getInstrumentalness(trackIds);
        double valence = getValence(trackIds);
        // not sure if genre works like this
        String genre = getGenre(trackIds);
    }

    // get an arrayList of all tracks' ids in a playlist
    private ArrayList<String> getTrackIds(String playlistId) {
        return null;
    }
    private ArrayList<String> getArtists(ArrayList<String> trackIds) { return null; }
    private ArrayList<String> getTitles(ArrayList<String> trackIds) { return null; }
    private double getAcousticness(ArrayList<String> trackIds) { return 1.0; }
    private double getEnergy (ArrayList<String> trackIds) { return 1.0; }
    private double getInstrumentalness (ArrayList<String> trackIds) { return 1.0; }
    private double getValence (ArrayList<String> trackIds) { return 1.0; }
    private String getGenre (ArrayList<String> trackIds) { return null; }

    // Generates a random and unique state parameter for the OAuth 2.0 authorization request
    private static String generateRandomState() {
        byte[] bytes = new byte[16];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}
