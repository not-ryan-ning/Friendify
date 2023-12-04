package use_case.accept_request;

import data_access.MockFileUserDataAccessObject;
import entity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AcceptRequestInteractorTest {
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

    @Test
    // Test interactor can be initialized
    public void testInteractorCreatedProperly() {
        AcceptRequestInteractor interactor = new AcceptRequestInteractor(mockAcceptRequestFileUserDA0,
                mockAcceptRequestPresenter);

    }

    public void testInteractorLogic() {
        // user2 has requested user1's friendship
        // user1 accepts user2 as a friend
        // Initialize 2 arrays with a single user in it, user1 or user2
        ArrayList<String> user1List = new ArrayList<>();
        user1List.add("John");
        ArrayList<String> user2List = new ArrayList<>();
        user2List.add("Alabaster");

        User user1 = userFactory.create("John", "password", emptyProfile, emptyPlaylist,
                new ArrayList<>(), new ArrayList<>(List.of("Alabaster")));
        User user2 = userFactory.create("Alabaster", "password", emptyProfile, emptyPlaylist,
                new ArrayList<>(), new ArrayList<>());
        ((MockFileUserDataAccessObject) mockAcceptRequestFileUserDA0).putUser(user1);
        ((MockFileUserDataAccessObject) mockAcceptRequestFileUserDA0).putUser(user2);

        AcceptRequestInteractor interactor = new AcceptRequestInteractor(mockAcceptRequestFileUserDA0,
                mockAcceptRequestPresenter);
        AcceptRequestInputData acceptRequestInputData = new AcceptRequestInputData(user1.getUsername(), user2.getUsername());

        interactor.execute(acceptRequestInputData);

        // Test that user1 has added user2 to their friend list
        assertEquals(user2List,
                ((MockFileUserDataAccessObject) mockAcceptRequestFileUserDA0).getAccounts().get("John").getFriends());

        // Test that user2 has been removed from user1's request list
        assertTrue(((MockFileUserDataAccessObject)
                mockAcceptRequestFileUserDA0).getAccounts().get("John").getRequests().isEmpty());

        // Test that user1 has been added to user2's friend list
        assertEquals(user1List,
                ((MockFileUserDataAccessObject)
                        mockAcceptRequestFileUserDA0).getAccounts().get("Alabaster").getFriends());

    }
}
