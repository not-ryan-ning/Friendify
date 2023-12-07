package use_case.display_profile;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DisplayProfileOutputDataTest {
    private DisplayProfileOutputData outputData;

    @Before
    public void init() {
        ArrayList<String> topThree = new ArrayList<>();
        topThree.add("artist1");
        this.outputData = new DisplayProfileOutputData("username","bio", topThree, "@spotifyHandle");
    }

    @Test
    public void testGetUsername() {
        assertEquals("username", outputData.getUsername());
    }

    @Test
    public void testGetBio() {
        assertEquals("bio", outputData.getBio());
    }

    @Test
    public void testGetTopThreeArtists() {
        ArrayList<String> topThree = new ArrayList<>();
        topThree.add("artist1");
        assertEquals(topThree, outputData.getTopThreeArtists());
    }
    @Test
    public void testGetSpotifyHandle() {
        assertEquals("@spotifyHandle", outputData.getSpotifyHandle());
    }
}
