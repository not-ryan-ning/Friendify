package interface_adapter.choose_playlist;

import org.junit.Before;
import org.junit.Test;
import use_case.choose_playlist.ChoosePlaylistInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ChoosePlaylistControllerTest {

    private ChoosePlaylistInputBoundary mockChoosePlaylistInteractor;

    @Before
    public void init() {
        this.mockChoosePlaylistInteractor = new MockChoosePlaylistInteractor();
    }

    @Test
    public void testInitialization() {
        ChoosePlaylistController controller = new ChoosePlaylistController(mockChoosePlaylistInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        ChoosePlaylistController controller = new ChoosePlaylistController(mockChoosePlaylistInteractor);

        controller.execute("", "", "", "");
        assertEquals("Success", ((MockChoosePlaylistInteractor) mockChoosePlaylistInteractor).getState());
    }
}
