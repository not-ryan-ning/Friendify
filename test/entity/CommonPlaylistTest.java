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

    /**
     * Testing getter methods
     */
    @Test
    public void testGetArtists() {
        HashMap<String, Integer> customArtists = new HashMap<>();
        customArtists.put("artist1", 4);
        Playlist playlist = playlistFactory.create("", new ArrayList<>(), customArtists, new HashMap<>(),
                0.0, 0.0 ,0.0, 0.0, new ArrayList<>());

        assertEquals(customArtists, playlist.getArtists());
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetGenres() {
        HashMap<String, Integer> customGenres = new HashMap<>();
        customGenres.put("genre1", 4);
        Playlist playlist = playlistFactory.create("", new ArrayList<>(), new HashMap<>(), customGenres,
                0.0, 0.0, 0.0, 0.0, new ArrayList<>());

        assertEquals(customGenres, playlist.getGenres());
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetAcoustciness() {
        Playlist playlist = playlistFactory.create("", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                1.0, 0.0, 0.0, 0.0, new ArrayList<>());

        assertEquals(1.0, playlist.getAcousticness(), 0.0001);
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetEnergy() {
        Playlist playlist = playlistFactory.create("", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                0.0, 1.0, 0.0, 0.0, new ArrayList<>());

        assertEquals(1.0, playlist.getEnergy(), 0.0001);
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetInstrumentalness() {
        Playlist playlist = playlistFactory.create("", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                0.0, 0.0, 1.0, 0.0, new ArrayList<>());

        assertEquals(1.0, playlist.getInstrumentalness(), 0.0001);
    }
}