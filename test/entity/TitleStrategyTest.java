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
}