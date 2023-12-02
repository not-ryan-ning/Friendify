package entity;

import entity.CommonPlaylistFactory;
import entity.Playlist;
import entity.PlaylistFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class AttributeStrategyTest {
    private PlaylistFactory factory;
    private MatchingStrategy matchingStrategy;


    @Before
    public void init() {
        // Initialize Playlists with empty ID int and titles, artists, and genres ArrayLists
        // Predetermine Attributes to see if Playlists return the correct similarity score
        this.factory = new CommonPlaylistFactory();
        this.matchingStrategy = new AttributeStrategy();
    }

    @Test
    public void testStrategyCreatedProperly() {
        MatchingStrategy matchingStrategy = new AttributeStrategy();

    }

    @Test
    // Test the basic case where both playlists are matching and should return 1.0 similarity score
    public void testBasicCase() {
        Playlist playlist1 = factory.create("1", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                1.0, 1.0, 1.0, 1.0,
                new ArrayList<>());
        Playlist playlist2 = factory.create("1", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                1.0, 1.0, 1.0, 1.0,
                new ArrayList<>());

        assertEquals(0.0, matchingStrategy.getSimilarityScore(playlist1, playlist2), 0.0001);
    }

    @Test
    // Test 50% similarity between two playlists, should return 1.0 (half Euclidean distance from each other)
    public void testHalfSimilarity() {
        Playlist playlist1 = factory.create("1", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                0.5, 0.5, 0.5, 0.5,
                new ArrayList<>());
        Playlist playlist2 = factory.create("1", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                1.0, 1.0, 1.0, 1.0,
                new ArrayList<>());

        assertEquals(1.0, matchingStrategy.getSimilarityScore(playlist1, playlist2), 0.0001);
    }

    @Test
    // Test 0% similarity between two playlists, should return 2.0 (max possible] distance from each other)
    public void testNoSimilarity() {
        Playlist playlist1 = factory.create("1", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());
        Playlist playlist2 = factory.create("1", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                1.0, 1.0, 1.0, 1.0,
                new ArrayList<>());

        assertEquals(2.0, matchingStrategy.getSimilarityScore(playlist1, playlist2), 0.0001);
    }
}
