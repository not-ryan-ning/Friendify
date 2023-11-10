package data_access;

import use_case.matching.SpotifyAPIDataAccessInterface;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;

public class SpotifyAPIDataAccessObject implements SpotifyAPIDataAccessInterface {
    private static final String CLIENT_ID = "7af39c08f4c242b89347deca0538bbb1";
    private static final String CLIENT_SECRET = "c85c0140606943c698f2cddaf49b082e";
    private static final String REDIRECT_URL = "https://github.com/not-ryan-ning/Friendify";
    private static final String scope = "playlist-read-private playlist-read-collaborative";
    private static final String authUrl = "https://accounts.spotify.com/authorize";
    private static final String tokenUrl = "https://accounts.spotify.com/api/token";

    // Step 1: Redirect the user to the authorization URL
    public String getRequestUserAuthorizationUrl() {
        String state = generateRandomState();
        return authUrl + "?client_id=" + CLIENT_ID + "&response_type=code&redirect_uri=" + REDIRECT_URL +
                "&scope=" + scope + "&state=" + state;
    }

    public Object[] requestAccessToken(String grantType, String code, String redirectUrl) {
        // Header Parameters:
        // Authorization = 'Authorization': 'Basic' + <base64 encoded client_id:client_secret>
        // Content-Type = 'content-type': 'application/x-www-form-urlencoded'
        String accessToken = "";
        String tokenType = "";
        String scope = "";
        int expiresIn = 0;
        String refreshToken = "";
        return new Object[] {accessToken, tokenType, scope, expiresIn, refreshToken};
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

    private static String generateRandomState() {
        byte[] bytes = new byte[16];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}
