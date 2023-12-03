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

    /**
     * Checks if given username exists in user data object and if the
     * password matches the saved password for the given username. If these are valid,
     * it gets the user's information, constructs a LoginOutputData object, and notifies the login
     * presenter to prepare the view for a successful login. Otherwise, it notifies the presenter with a fail message.
     * @param loginInputData The input data containing the username and password for login.
     */
    @Override
    public void execute(LoginInputData loginInputData) {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existByName(username)) {
            loginPresenter.prepareFailView(username + ": Account does not exist.");
        } else {
            String savedPassword = userDataAccessObject.get(username).getPassword();
            if (!password.equals(savedPassword)) {
                loginPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {
                User user = userDataAccessObject.get(loginInputData.getUsername());

                LoginOutputData loginOutputData = new LoginOutputData(user.getUsername(), user.getProfile().getBio(),
                        user.getProfile().getTopThreeArtists(), user.getProfile().getSpotifyHandle(), false);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }
}