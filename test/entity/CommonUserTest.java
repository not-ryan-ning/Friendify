package entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Testing file for CommonUser Class
 */
public class CommonUserTest {
    private UserFactory userFactory;
    private ProfileFactory profileFactory;
    private Profile emptyProfile;
    private Playlist emptyPlaylist;

    /**
     * Create empty profile and playlists objects as we are only testing User behaviour
     */
    @Before
    public void init() {
        this.userFactory = new CommonUserFactory();
        this.profileFactory = new CommonProfileFactory();
        PlaylistFactory playlistFactory = new CommonPlaylistFactory();

        this.emptyProfile = profileFactory.create("", new ArrayList<>(), "");
        this.emptyPlaylist = playlistFactory.create("", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                0.0, 0.0 ,0.0, 0.0, new ArrayList<>());

    }

    /**
     * Test that user can be created
     */
    @Test
    public void testUserCreatedProperly() {
        User user = userFactory.create("", "", emptyProfile, emptyPlaylist,
                new ArrayList<>(), new ArrayList<>());

        assertNotNull(user);
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetUsername() {
        User user = userFactory.create("Aleister Crowley", "", emptyProfile, emptyPlaylist,
                new ArrayList<>(), new ArrayList<>());

        assertEquals("Aleister Crowley", user.getUsername());
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetPassword() {
        User user = userFactory.create("", "totallysecretpassword", emptyProfile, emptyPlaylist,
                new ArrayList<>(), new ArrayList<>());

        assertEquals("totallysecretpassword", user.getPassword());
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetProfile() {
        Profile customProfile = new CommonProfile("hello!", new ArrayList<>(), "@spotifyUser123");
        User user = userFactory.create("", "", customProfile, emptyPlaylist,
                new ArrayList<>(), new ArrayList<>());

        assertEquals(customProfile, user.getProfile());
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetPlaylist() {
        Playlist customPlaylist = new CommonPlaylist("1", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                1.0, 1.0, 2.0, 3.0, new ArrayList<>());
        User user = userFactory.create("", "", emptyProfile, customPlaylist,
                new ArrayList<>(), new ArrayList<>());

        assertEquals(customPlaylist, user.getPlaylist());
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetFriends() {
        ArrayList<String> customFriends = new ArrayList<>(List.of("Lemony Snicket"));
        User user = userFactory.create("", "", emptyProfile, emptyPlaylist,
                customFriends, new ArrayList<>());

        assertEquals(customFriends, user.getFriends());
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetRequests() {
        ArrayList<String> customRequests= new ArrayList<>(List.of("Lemony Snicket"));
        User user = userFactory.create("", "", emptyProfile, emptyPlaylist,
                new ArrayList<>(), customRequests);

        assertEquals(customRequests, user.getRequests());
    }

    /**
     * Testing setter methods
     */
    @Test
    public void testSetProfile() {
        Profile profile = profileFactory.create("hello!", new ArrayList<>(), "");
        User user = userFactory.create("", "", emptyProfile, emptyPlaylist,
                new ArrayList<>(), new ArrayList<>());
        user.setProfile(profile);

        assertEquals(profile, user.getProfile());
    }

    /**
     * Testing setter methods
     */
    @Test
    public void testSetPlaylist() {
        Playlist customPlaylist = new CommonPlaylist("1", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                1.0, 1.0, 2.0, 3.0, new ArrayList<>());
        User user = userFactory.create("", "", emptyProfile, emptyPlaylist,
                new ArrayList<>(), new ArrayList<>());
        user.setPlaylist(customPlaylist);

        assertEquals(customPlaylist, user.getPlaylist());
    }

    /**
     * Testing setter methods
     */
    @Test
    public void testSetFriends() {
        ArrayList<String> friends = new ArrayList<>(List.of("friend1"));
        User user = userFactory.create("", "", emptyProfile, emptyPlaylist,
                new ArrayList<>(), new ArrayList<>());
        user.setFriends(friends);

        assertEquals(friends, user.getFriends());
    }

    /**
     * Testing setter methods
     */
    @Test
    public void testSetRequests() {
        ArrayList<String> requests = new ArrayList<>(List.of("request1"));
        User user = userFactory.create("", "", emptyProfile, emptyPlaylist,
                new ArrayList<>(), new ArrayList<>());
        user.setRequests(requests);

        assertEquals(requests, user.getRequests());
    }


}
