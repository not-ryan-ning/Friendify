package entity;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Testing file for CommonUser Class
 */
public class CommonPlaylistTest {
    private PlaylistFactory playlistFactory;

    /**
     * Create empty profile and playlists objects as we are only testing User behaviour
     */
    @Before
    public void init() {
        this.playlistFactory = new CommonPlaylistFactory();
    }

    /**
     * Test that Playlist can be created
     */
    @Test
    public void testPlaylistCreatedProperly() {
        Playlist playlist = playlistFactory.create("", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                0.0, 0.0 ,0.0, 0.0, new ArrayList<>());

        assertNotNull(playlist);
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetPlaylistId() {
        Playlist playlist = playlistFactory.create("1A2B3C", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                0.0, 0.0 ,0.0, 0.0, new ArrayList<>());

        assertEquals("1A2B3C", playlist.getPlaylistId());
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetTitles() {
        ArrayList<String> customTitles = new ArrayList<>(Arrays.asList("title1", "title2"));
        Playlist playlist = playlistFactory.create("", customTitles, new HashMap<>(), new HashMap<>(),
                0.0, 0.0 ,0.0, 0.0, new ArrayList<>());

        assertEquals(customTitles, playlist.getTitles());
    }
}