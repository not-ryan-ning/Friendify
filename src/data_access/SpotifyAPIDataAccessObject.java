package data_access;

import use_case.matching.SpotifyAPIDataAccessInterface;

import java.util.ArrayList;

public class SpotifyAPIDataAccessObject implements SpotifyAPIDataAccessInterface {
    private static final String CLIENT_ID = "7af39c08f4c242b89347deca0538bbb1";
    private static final String CLIENT_SECRETE = "c85c0140606943c698f2cddaf49b082e";
    // Need to modify
    private static final String redirectURL = "https://github.com/not-ryan-ning/Friendify";

    public String[] requestUserAuthorization(String clientId, String responseType, String redirectUrl, String state, String scope, boolean showDialog) {
        // need a separate class for this implementation
        // should receive something like https://my-domain.com/callback?code=NApCCg..BkWtQ&state=34fFs29kd09
        String returnedValue = "";
        String code = "";
        return new String[] {code, state};
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
}
