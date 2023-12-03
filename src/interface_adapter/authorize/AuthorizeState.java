package interface_adapter.authorize;

import java.security.SecureRandom;
import java.util.Base64;

public class AuthorizeState {
    private String accessToken = "";
    private static final String CLIENT_ID = "7af39c08f4c242b89347deca0538bbb1";
    private static final String CLIENT_SECRET = "c85c0140606943c698f2cddaf49b082e";
    private static final String REDIRECT_URI = "http://localhost:8080/callback";
    private static final String scope = "playlist-read-private";
    private static final String tokenUrl = "https://accounts.spotify.com/api/token";


    public AuthorizeState(AuthorizeState copy) {
        accessToken = copy.accessToken;
    }

    public AuthorizeState() {}

    public String getAccessToken() { return accessToken; }

    public String getAuthorizationLink() {
        String authUrl = "https://accounts.spotify.com/authorize";
        String state = generateRandomState();

        String authRedirectUrl = authUrl + "?client_id=" + CLIENT_ID + "&response_type=code&redirect_uri=" + REDIRECT_URI
                + "&scope=" + scope + "&state=" + state;
        return authRedirectUrl;
    }

    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }

    // Generates a random and unique state parameter for the OAuth 2.0 authorization request
    private static String generateRandomState() {
        byte[] bytes = new byte[16];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}
