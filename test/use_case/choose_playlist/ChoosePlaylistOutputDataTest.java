package use_case.choose_playlist;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChoosePlaylistOutputDataTest {

    private ChoosePlaylistOutputData outputData;

    @Before
    public void init() {
        this.outputData = new ChoosePlaylistOutputData("name1", new ArrayList<>(List.of("artists")));
    }

    @Test
    public void testGetTopThreeArtists() {
        assertEquals(new ArrayList<>(List.of("artists")), outputData.getTopThreeArtists());
    }
    @Test
    public void testGetPlaylistName() {
        assertEquals("name1", outputData.getPlaylistName());
    }
}
