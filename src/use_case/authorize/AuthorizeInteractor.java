package use_case.authorize;

import java.io.IOException;

public class AuthorizeInteractor implements AuthorizeInputBoundary{
    final AuthorizeSpotifyAuthenticationDataAccessInterface spotifyAuthenticationDataAccessObject;
    final AuthorizeOutputBoundary authorizePresenter;

    public AuthorizeInteractor(AuthorizeSpotifyAuthenticationDataAccessInterface spotifyAuthenticationDataAccessInterface,
                               AuthorizeOutputBoundary authorizeOutputBoundary) {
        this.spotifyAuthenticationDataAccessObject = spotifyAuthenticationDataAccessInterface;
        this.authorizePresenter = authorizeOutputBoundary;
    }

    public void execute(String authorizationLink) {
        try {
            // accessToken can return null if the authentication process fails
            String accessToken = spotifyAuthenticationDataAccessObject.getAccessToken(authorizationLink);
            AuthorizeOutputData authorizeOutputData = new AuthorizeOutputData(accessToken);

            if (accessToken != null) {
                authorizePresenter.prepareSuccessView(authorizeOutputData);
            } else {
                authorizePresenter.prepareFailView("Unable to complete authentication process successfully.");
            }
        } catch (IOException e) {
            // Handle or propagate the IOException
            e.printStackTrace(); // Consider logging the exception or handling it according to your application's requirements
            authorizePresenter.prepareFailView("Error during authentication process: " + e.getMessage());
        }
    }

}
