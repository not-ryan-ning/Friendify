package entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Testing file for TitleStrategy Class
 */
public class TitleStrategyTest {
    private PlaylistFactory factory;
    private MatchingStrategy matchingStrategy;

    /**
     * Initialize Playlists with empty ID int and titles, artists, and genres ArrayLists
     * Predetermine certain parameters to see if Playlists return the correct similarity score
     */
    @Before
    public void init() {
        this.factory = new CommonPlaylistFactory();
        this.matchingStrategy = new TitleStrategy();
    }

    /**
     * Basic test to see if strategy can be initialized
     */
    @Test
    public void testStrategyCreatedProperly() {
        assertNotNull(this.matchingStrategy);
    }

    /**
     * Test 100% similarity between artist in both playlists, should output 1.0 - most similar
     */
    @Test
    public void testFullSimilarity() {
        ArrayList<String> title1 = new ArrayList<>(List.of("Pretender"));
        ArrayList<String> title2 = new ArrayList<>(List.of("Pretender"));

        Playlist playlist1 = factory.create("", title1, new HashMap<>(), new HashMap<>(),
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());
        Playlist playlist2 = factory.create("", title2, new HashMap<>(), new HashMap<>(),
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());

        assertEquals(1.0, matchingStrategy.getSimilarityScore(playlist1, playlist2), 0.0001);
    }

    /**
     * Test 50% similarity between artist in both playlists, should output 0.5
     */
    @Test
    public void testHalfSimilarity() {
        ArrayList<String> title1 = new ArrayList<>(Arrays.asList("Pretender", "Left Right"));
        ArrayList<String> title2 = new ArrayList<>(List.of("Pretender"));

        Playlist playlist1 = factory.create("", title1, new HashMap<>(), new HashMap<>(),
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());
        Playlist playlist2 = factory.create("", title2, new HashMap<>(), new HashMap<>(),
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());

        assertEquals(0.5, matchingStrategy.getSimilarityScore(playlist1, playlist2), 0.0001);
    }

    /**
     * Test 0% similarity between artist in both playlists, should output 0.0 - most dissimilar
     */
    @Test
    public void testNoSimilarity() {
        ArrayList<String> title1 = new ArrayList<>(List.of("Left Right"));
        ArrayList<String> title2 = new ArrayList<>(List.of("Pretender"));

        Playlist playlist1 = factory.create("", title1, new HashMap<>(), new HashMap<>(),
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());
        Playlist playlist2 = factory.create("", title2, new HashMap<>(), new HashMap<>(),
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());

        assertEquals(0.0, matchingStrategy.getSimilarityScore(playlist1, playlist2), 0.0001);
    }
}