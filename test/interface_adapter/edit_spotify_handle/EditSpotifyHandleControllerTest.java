package interface_adapter.edit_spotify_handle;

import org.junit.Before;
import org.junit.Test;
import use_case.edit_spotify_handle.EditSpotifyHandleInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EditSpotifyHandleControllerTest {
    private EditSpotifyHandleInputBoundary mockEditSpotifyHandleInteractor;

    @Before
    public void init() {
        this.mockEditSpotifyHandleInteractor = new MockEditSpotifyHandleInteractor();
    }

    @Test
    public void testInitialization() {
        EditSpotifyHandleController controller = new EditSpotifyHandleController(mockEditSpotifyHandleInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        EditSpotifyHandleController controller = new EditSpotifyHandleController(mockEditSpotifyHandleInteractor);

        controller.execute("", "");

        assertEquals("Success", ((MockEditSpotifyHandleInteractor) mockEditSpotifyHandleInteractor).getState());
    }
}