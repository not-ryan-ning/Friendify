package use_case.authorize;

public class AuthorizeInteractor implements AuthorizeInputBoundary{
    final AuthorizeSpotifyAuthenticationDataAccessInterface spotifyAuthenticationDataAccessObject;
    final AuthorizeOutputBoundary authorizePresenter;

    public AuthorizeInteractor(AuthorizeSpotifyAuthenticationDataAccessInterface spotifyAuthenticationDataAccessInterface,
                               AuthorizeOutputBoundary authorizeOutputBoundary) {
        this.spotifyAuthenticationDataAccessObject = spotifyAuthenticationDataAccessInterface;
        this.authorizePresenter = authorizeOutputBoundary;
    }

    public void execute() {
        // accessToken can return null if the authentication process fails
        String accessToken = spotifyAuthenticationDataAccessObject.getAccessToken();
        AuthorizeOutputData authorizeOutputData = new AuthorizeOutputData(accessToken);

        if (accessToken != null) {
            authorizePresenter.prepareSuccessView(authorizeOutputData);
        } else {
            authorizePresenter.prepareFailView("Unable to complete authentication process successfully.");
        }
    }
}
