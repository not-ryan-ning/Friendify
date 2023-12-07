package use_case.login;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LoginOutputDataTest {
    private LoginOutputData outputData;

    @Before
    public void init() {
        ArrayList<String> topThree = new ArrayList<>();
        topThree.add("artist1");
        this.outputData = new LoginOutputData("username", "bio", topThree,
                "spotifyHandle", true);
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
    public void getSpotifyHandle() {
        assertEquals("spotifyHandle", outputData.getSpotifyHandle());
    }

}
