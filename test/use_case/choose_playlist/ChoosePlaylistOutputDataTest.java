package use_case.choose_playlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChoosePlaylistOutputDataTest {

    private ChoosePlaylistOutputData outputData;

    @Before
    public void init() {
        this.outputData = new ChoosePlaylistOutputData("name1");
    }

    @Test
    public void testGetPlaylistName() {
        assertEquals("name1", outputData.getPlaylistName());
    }
}
