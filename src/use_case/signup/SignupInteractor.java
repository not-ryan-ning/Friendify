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