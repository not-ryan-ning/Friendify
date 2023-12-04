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
}
