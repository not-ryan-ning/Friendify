package use_case.edit_bio;

import interface_adapter.ViewManagerModel;
import org.junit.Test;
import use_case.display_playlists.DisplayPlaylistsInputData;
import use_case.display_playlists.DisplayPlaylistsInteractor;

import static org.junit.Assert.*;

public class EditBioInteractorTest {
    private EditBioInteractor editBioInteractor;
    private ViewManagerModel viewManagerModel;
    @Test
    public void testExecute() {
        editBioInteractor.execute("user", new EditBioInputData("new bio"));
        assertEquals("edit bio", viewManagerModel.getActiveView());
    }


}