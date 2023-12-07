package use_case.choose_playlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChoosePlaylistInputDataTest {

    private ChoosePlaylistInputData inputData;
    @Before
    public void init() {
        this.inputData = new ChoosePlaylistInputData("1", "name1",
                "123");
    }

    @Test
    public void testInputDataGetPlaylistID() {
        assertEquals("1", inputData.getPlaylistId());
    }

    @Test
    public void testInputDataGetPlaylistName() {
        assertEquals("name1", inputData.getPlaylistName());
    }

    @Test
    public void testInputDataGetAccessToken() {
        assertEquals("123", inputData.getAccessToken());
    }

}
