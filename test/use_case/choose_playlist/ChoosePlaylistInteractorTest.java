package use_case.choose_playlist;

import interface_adapter.ViewManagerModel;
import interface_adapter.display_friends.DisplayFriendsPresenter;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.display_requests.DisplayRequestsInteractor;
import use_case.display_requests.DisplayRequestsUserDataAccessInterface;
import use_case.edit_profile.EditProfileInteractor;

import static org.junit.Assert.*;

public class ChoosePlaylistInteractorTest {
    private ChoosePlaylistInteractor choosePlaylistInteractor;
    private ViewManagerModel viewManagerModel;
    @BeforeEach
    public void setUp() {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        choosePlaylistInteractor = new ...
    }
    @Test
    public void testExecute() {
        choosePlaylistInteractor.execute("user", new ChoosePlaylistInputData("id", "playlist", "token"));
        assertEquals("ChoosePlaylist", viewManagerModel.getActiveView());
    }

}