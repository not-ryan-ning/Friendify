package use_case.choose_playlist;

import interface_adapter.ViewManagerModel;
import org.junit.Test;
import use_case.edit_profile.EditProfileInteractor;

import static org.junit.Assert.*;

public class ChoosePlaylistInteractorTest {
    private ChoosePlaylistInteractor choosePlaylistInteractor;
    private ViewManagerModel viewManagerModel;
    @Test
    public void testExecute() {
        choosePlaylistInteractor.execute("user", new ChoosePlaylistInputData("id", "playlist", "token"));
        assertEquals("ChoosePlaylist", viewManagerModel.getActiveView());
    }

}