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
            userPresenter.prepareFailView("Error: This user already exists, please try logging in! ");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Error: Passwords don't match, please try again.");
        } else {
            // Create empty profile and playlist objects when new user create
            // (!) Empty ArrayLists are initialized
            Profile profile = profileFactory.create("", new ArrayList<String>(), "");
            Playlist playlist = playlistFactory.create("", new ArrayList<String>(), new HashMap<>(), new HashMap<>(), 0.0, 0.0, 0.0, 0.0, new ArrayList<>());

            User user = userFactory.create(signupInputData.getUsername(),
                    signupInputData.getPassword(),
                    profile,
                    playlist,
                    new ArrayList<String>(),
                    new ArrayList<String>());

            userDataAccessObject.save(user);
            user.setProfile(profile);
            user.getProfile().setBio("");
            user.getProfile().setTopThreeArtists(new ArrayList<String>());
            user.getProfile().setSpotifyHandle("");
            user.setPlaylist(playlist);
            user.getPlaylist().setPlaylistId("");
            user.getPlaylist().setTitles(new ArrayList<String>());
            user.getPlaylist().setArtists(new HashMap<>());
            user.getPlaylist().setGenres(new HashMap<>());
            user.getPlaylist().setAcousticness(0.0);
            user.getPlaylist().setEnergy(0.0);
            user.getPlaylist().setInstrumentalness(0.0);
            user.getPlaylist().setValence(0.0);
            user.getPlaylist().setTopThreeArtists(new ArrayList<>());
            user.setFriends(new ArrayList<String>());
            user.setRequests(new ArrayList<String>());

            SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }
}