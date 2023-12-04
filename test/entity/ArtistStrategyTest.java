package entity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;
/**
 * Testing file for ArtistStrategy Class
 */
public class ArtistStrategyTest {
    private PlaylistFactory factory;
    private MatchingStrategy matchingStrategy;

    /**
     * Initialize Playlists with empty ID int and titles, artists, and genres ArrayLists
     * Predetermine Attributes to see if Playlists return the correct similarity score
     */
    @Before
    public void init() {
        this.factory = new CommonPlaylistFactory();
        this.matchingStrategy = new AttributeStrategy();
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
        HashMap<String, Integer> artist1 = new HashMap<>();
        artist1.put("Valley", 3);
        artist1.put("Owl City", 4);
        artist1.put("NIKI", 3);

        HashMap<String, Integer> artist2 = new HashMap<>();
        artist2.put("Valley", 3);
        artist2.put("Owl City", 4);
        artist2.put("NIKI", 3);
        Playlist playlist1 = factory.create("1", new ArrayList<>(), artist1, new HashMap<>(),
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());
        Playlist playlist2 = factory.create("1", new ArrayList<>(), artist2, new HashMap<>(),
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());

        assertEquals(1.0, matchingStrategy.getSimilarityScore(playlist1, playlist2), 0.0001);
    }

}
