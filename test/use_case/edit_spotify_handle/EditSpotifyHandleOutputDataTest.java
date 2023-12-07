package use_case.edit_spotify_handle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditSpotifyHandleOutputDataTest {

    private EditSpotifyHandleOutputData outputData;

    @Before
    public void init() {
        this.outputData = new EditSpotifyHandleOutputData("spotifyHandle");
    }

    @Test
    public void testGetNewSpotifyHandle() {
        assertEquals("spotifyHandle", outputData.getNewSpotifyHandle());
    }

}
