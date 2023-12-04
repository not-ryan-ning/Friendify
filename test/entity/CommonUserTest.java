package entity;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Testing file for CommonUser Class
 */
public class CommonUserTest {
    private UserFactory userFactory;
    private ProfileFactory profileFactory;
    private PlaylistFactory playlistFactory;
    private Profile emptyProfile;
    private Playlist emptyPlaylist;

    /**
     * Create empty profile and playlists objects as we are only testing User behaviour
     */
    @Before
    public void init() {
        this.userFactory = new CommonUserFactory();
        this.profileFactory = new CommonProfileFactory();
        this.playlistFactory = new CommonPlaylistFactory();

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
}
