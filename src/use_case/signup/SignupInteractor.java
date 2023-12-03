package use_case.signup;

import entity.*;

import java.util.ArrayList;
import java.util.HashMap;

public class SignupInteractor implements SignupInputBoundary {
    final SignupUserDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final UserFactory userFactory;
    final ProfileFactory profileFactory;
    final PlaylistFactory playlistFactory;

    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary,
                            UserFactory userFactory,
                            ProfileFactory profileFactory,
                            PlaylistFactory playlistFactory) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
        this.userFactory = userFactory;
        this.profileFactory = profileFactory;
        this.playlistFactory = playlistFactory;
    }

    /**
     * Executes process of signing a user up based on the provided signup input data.
     * If the given username already exists, a failure view is prepared with an error message.
     * If the passwords do not match, a failure view is prepared with an appropriate error message.
     * Otherwise, a new user is created with an empty profile and playlist, and the user is saved. Then,
     * a success view is then prepared with the user's information.
     *
     * @param signupInputData The input data containing the username, password, and repeat password for the signup.
     */
    @Override
    public void execute(SignupInputData signupInputData) {
        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("Error: This user already exists, please try logging in. ");
            userPresenter.prepareLoginView();

        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Error: Passwords don't match, please try again.");

        } else {
            Profile profile = profileFactory.create("", new ArrayList<>(), "");
            Playlist playlist = playlistFactory.create("", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                    0.0, 0.0, 0.0, 0.0, new ArrayList<>());
            User user = userFactory.create(signupInputData.getUsername(),
                    signupInputData.getPassword(), profile, playlist, new ArrayList<>(), new ArrayList<>());

            userDataAccessObject.save(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }
}