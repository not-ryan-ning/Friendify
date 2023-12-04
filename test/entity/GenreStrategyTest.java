package entity;

import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Testing file for GenreStrategy Class
 */
public class GenreStrategyTest {
    private PlaylistFactory factory;
    private MatchingStrategy matchingStrategy;

    /**
     * Initialize Playlists with empty ID int and titles, artists, and genres ArrayLists
     * Predetermine certain parameters to see if Playlists return the correct similarity score
     */
    @Before
    public void init() {
        this.factory = new CommonPlaylistFactory();
        this.matchingStrategy = new GenreStrategy();
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
        HashMap<String, Integer> genre1 = new HashMap<>();
        genre1.put("Jazz", 3);
        genre1.put("Pop", 4);

        HashMap<String, Integer> genre2 = new HashMap<>();
        genre2.put("Jazz", 3);
        genre2.put("Pop", 4);

        Playlist playlist1 = factory.create("1", new ArrayList<>(), new HashMap<>(), genre1,
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());
        Playlist playlist2 = factory.create("1", new ArrayList<>(), new HashMap<>(), genre2,
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());

        assertEquals(1.0, matchingStrategy.getSimilarityScore(playlist1, playlist2), 0.0001);
    }

    /**
     * Test 50% similarity between artist in both playlists, should output 0.5
     */
    @Test
    public void testHalfSimilarity() {
        HashMap<String, Integer> genre1 = new HashMap<>();
        genre1.put("Jazz", 2);

        HashMap<String, Integer> genre2 = new HashMap<>();
        genre2.put("Jazz", 1);
        genre2.put("Pop", 1);
        genre2.put("Hyperpop", 1);
        genre2.put("Country", 1);

        Playlist playlist1 = factory.create("", new ArrayList<>(), new HashMap<>(), genre1,
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());
        Playlist playlist2 = factory.create("", new ArrayList<>(), new HashMap<>(), genre2,
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());

        DecimalFormat df = new DecimalFormat("#.#");

        assertEquals(0.5, Double.parseDouble(
                df.format(matchingStrategy.getSimilarityScore(playlist1, playlist2))), 0.0001);
    }

    /**
     * Test 0% similarity between artist in both playlists, should output 0.0 - most dissimilar
     */
    @Test
    public void testNoSimilarity() {
        HashMap<String, Integer> genre1 = new HashMap<>();
        genre1.put("Jazz", 2);

        HashMap<String, Integer> genre2 = new HashMap<>();
        genre2.put("Hyperpop", 1);

        Playlist playlist1 = factory.create("", new ArrayList<>(), new HashMap<>(), genre1,
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());
        Playlist playlist2 = factory.create("", new ArrayList<>(), new HashMap<>(), genre2,
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());

        DecimalFormat df = new DecimalFormat("#.#");

        assertEquals(0.0, matchingStrategy.getSimilarityScore(playlist1, playlist2), 0.0001);
    }
}