package entity;

import org.junit.Before;
import org.junit.Test;

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

}
