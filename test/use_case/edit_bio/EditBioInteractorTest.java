package use_case.edit_bio;

import data_access.FileUserDataAccessObject;
import entity.CommonProfileFactory;
import entity.CommonUserFactory;
import entity.ProfileFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.edit_bio.EditBioPresenter;
import interface_adapter.edit_bio.EditBioViewModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.display_playlists.DisplayPlaylistsInputData;
import use_case.display_playlists.DisplayPlaylistsInteractor;
import use_case.edit_spotify_handle.EditSpotifyHandleUserDataAccessInterface;

import java.io.IOException;

import static org.junit.Assert.*;

public class EditBioInteractorTest {
    private EditBioInteractor editBioInteractor;
    private ViewManagerModel viewManagerModel;
    @BeforeEach
    public void setUp() throws IOException {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        UserFactory uf = new CommonUserFactory();
        ProfileFactory pf = new CommonProfileFactory();
        EditBioUserDataAccessInterface user = new FileUserDataAccessObject("./users", uf, pf);
        editBioInteractor = new EditBioInteractor(user, new EditBioPresenter(viewManagerModel, new EditBioViewModel()));
    }
    @Test
    public void testExecute() {
        editBioInteractor.execute("user", new EditBioInputData("new bio"));
        assertEquals("edit bio", viewManagerModel.getActiveView());
    }
}