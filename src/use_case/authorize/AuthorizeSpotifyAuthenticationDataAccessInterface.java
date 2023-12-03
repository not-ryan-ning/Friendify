package use_case.authorize;

import java.io.IOException;

public interface AuthorizeSpotifyAuthenticationDataAccessInterface {
    String getAccessToken(String authorizationLink) throws IOException;
}
