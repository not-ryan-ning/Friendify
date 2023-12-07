package use_case.display_profile;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DisplayOutputDataTest {
    private String bio;
    private ArrayList<String> topThreeArtists;
    private String spotifyHandle;
    private DisplayProfileOutputData outputData;

    @Before
    public void init() {
        ArrayList<String> topThree = new ArrayList<>();
        topThree.add("artist1");
        this.outputData = new DisplayProfileOutputData("bio", topThree, "@spotifyHandle");
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
