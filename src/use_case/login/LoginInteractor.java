package use_case.login;

import entity.User;

public class LoginInteractor implements LoginInputBoundary {
    final LoginUserDataAccessInterface userDataAccessObject;
    final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView(username + ": Account does not exist.");
        } else {
            String savedPassword = userDataAccessObject.get(username).getPassword();
            if (!password.equals(savedPassword)) {
                loginPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {
                User user = userDataAccessObject.get(loginInputData.getUsername());

                LoginOutputData loginOutputData;

                if (user.getPlaylist() != null && user.getProfile() != null) {
                    loginOutputData = new LoginOutputData(user.getUsername(), user.getProfile().getBio(),
                            user.getProfile().getTopThreeArtists(), user.getProfile().getSpotifyHandle(), false);
                } else {
                    loginOutputData = new LoginOutputData(user.getUsername(), "", null, "", false);
                }

                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }
}