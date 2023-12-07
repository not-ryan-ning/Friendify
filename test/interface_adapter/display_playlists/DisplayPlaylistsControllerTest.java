package interface_adapter.display_playlists;

import org.junit.Before;
import org.junit.Test;
import use_case.display_playlists.DisplayPlaylistsInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DisplayPlaylistsControllerTest {
    private DisplayPlaylistsInputBoundary mockDisplayPlaylistsInteractor;

    @Before
    public void init() {
        this.mockDisplayPlaylistsInteractor = new MockDisplayPlaylistsInteractor();
    }

    @Test
    public void testInitialization() {
        DisplayPlaylistsController controller = new DisplayPlaylistsController(mockDisplayPlaylistsInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        DisplayPlaylistsController controller = new DisplayPlaylistsController(mockDisplayPlaylistsInteractor);
        controller.execute("");

        assertEquals("Success", ((MockDisplayPlaylistsInteractor) mockDisplayPlaylistsInteractor).getState());
    }
}