package entity;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Testing file for CommonProfile Class
 */
public class CommonProfileTest {
    private ProfileFactory profileFactory;

    /**
     * Create CommonProfile factory
     */
    @Before
    public void init() {
        this.profileFactory = new CommonProfileFactory();
    }

    /**
     * Test that Profile can be created
     */
    @Test
    public void testPlaylistCreatedProperly() {
        Profile profile = profileFactory.create("", new ArrayList<>(), "");

        assertNotNull(profile);
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetBio() {
        Profile profile = profileFactory.create("hello!", new ArrayList<>(), "");

        assertEquals("hello!", profile.getBio());
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetTopThreeArtists() {
        ArrayList<String> topThree = new ArrayList<>(Arrays.asList("artist1", "artist2", "artist3"));
        Profile profile = profileFactory.create("", topThree, "");

        assertEquals(topThree, profile.getTopThreeArtists());
    }

    /**
     * Testing getter methods
     */
    @Test
    public void testGetSpotifyHandle() {
        Profile profile = profileFactory.create("", new ArrayList<>(), "@User123");

        assertEquals("@User123", profile.getSpotifyHandle());
    }
}
