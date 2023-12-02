package use_case.edit_spotify_handle;

import interface_adapter.ViewManagerModel;
import org.junit.Test;
import use_case.edit_profile.EditProfileInteractor;

import static org.junit.Assert.*;

public class EditSpotifyHandleInteractorTest {
    private EditSpotifyHandleInteractor editSpotifyHandleInteractor;
    private ViewManagerModel viewManagerModel;
    @Test
    public void testExecute() {
        editSpotifyHandleInteractor.execute("user", new EditSpotifyHandleInputData("handle"));
        assertEquals("edit spotify handle", viewManagerModel.getActiveView());
    }

}