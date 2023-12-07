package data_access.authorize;

import use_case.authorize.AuthorizeSpotifyAuthenticationDataAccessInterface;

import java.io.IOException;

public class MockSpotifyAuthenticationDataAccessObject implements AuthorizeSpotifyAuthenticationDataAccessInterface {

    private String accessToken;

    public MockSpotifyAuthenticationDataAccessObject(String check) {
        if (check.equals("true")) {
            this.accessToken = "Success";
        }
        if (check.equals("false")) {
            this.accessToken = null;
        }

        if (!check.equals("false") && !check.equals("true")) {
            this.accessToken = "io";
        }


    }

    @Override
    public String getAccessToken(String string ) throws IOException {
        if (accessToken != null && accessToken.equals("io")) {
            throw new IOException();
        }

        return this.accessToken;
    }
}
