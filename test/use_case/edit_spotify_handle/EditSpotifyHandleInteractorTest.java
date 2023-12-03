package use_case.edit_spotify_handle;

import data_access.FileUserDataAccessObject;
import entity.CommonProfileFactory;
import entity.CommonUserFactory;
import entity.ProfileFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.edit_spotify_handle.EditSpotifyHandlePresenter;
import interface_adapter.edit_spotify_handle.EditSpotifyHandleViewModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.edit_profile.EditProfileInteractor;
import use_case.match.MatchUserDataAccessInterface;

import java.io.IOException;

import static org.junit.Assert.*;

public class EditSpotifyHandleInteractorTest {
    private EditSpotifyHandleInteractor editSpotifyHandleInteractor;
    private ViewManagerModel viewManagerModel;
    @BeforeEach
    public void setUp() throws IOException {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        UserFactory uf = new CommonUserFactory();
        ProfileFactory pf = new CommonProfileFactory();
        EditSpotifyHandleUserDataAccessInterface user = new FileUserDataAccessObject("./users", uf, pf);
        editSpotifyHandleInteractor = new EditSpotifyHandleInteractor(user, new EditSpotifyHandlePresenter(viewManagerModel, new EditSpotifyHandleViewModel()));
    }
    @Test
    public void testExecute() {
        editSpotifyHandleInteractor.execute("user", new EditSpotifyHandleInputData("handle"));
        assertEquals("edit spotify handle", viewManagerModel.getActiveView());
    }

}