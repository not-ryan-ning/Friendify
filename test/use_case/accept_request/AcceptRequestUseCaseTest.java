package use_case.accept_request;

import data_access.MockFileUserDataAccessObject;
import entity.*;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;

public class AcceptRequestUseCaseTest {
    private UserFactory userFactory;
    private ProfileFactory profileFactory;
    private PlaylistFactory playlistFactory;
    private Profile emptyProfile;
    private Playlist emptyPlaylist;
    private AcceptRequestFileUserDataAccessInterface mockAcceptRequestFileUserDA0;
    private AcceptRequestOutputBoundary mockAcceptRequestPresenter;

    @Before
    public void init() {
        // Initialize empty users with predetermined friends lists
        this.userFactory = new CommonUserFactory();
        this.profileFactory = new CommonProfileFactory();
        this.playlistFactory = new CommonPlaylistFactory();
        this.mockAcceptRequestFileUserDA0 = new MockFileUserDataAccessObject();
        this.mockAcceptRequestPresenter = new MockAcceptRequestPresenter();
        this.emptyProfile = profileFactory.create("", new ArrayList<>(), "");
        this.emptyPlaylist = playlistFactory.create("", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                0.0, 0.0, 0.0, 0.0, new ArrayList<>());
    }
}
