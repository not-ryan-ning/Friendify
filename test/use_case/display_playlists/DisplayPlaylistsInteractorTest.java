package use_case.display_playlists;

import interface_adapter.ViewManagerModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.display_friends.DisplayFriendsInteractor;
import use_case.display_requests.DisplayRequestsInteractor;

import static org.junit.Assert.*;

public class DisplayPlaylistsInteractorTest {
    private DisplayPlaylistsInteractor displayPlaylistsInteractor;
    private ViewManagerModel viewManagerModel;

    @BeforeEach
    public void setUp() {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        displayPlaylistsInteractor = ...
    }
    @Test
    public void testExecute() {
        displayPlaylistsInteractor.execute(new DisplayPlaylistsInputData("token"));
        assertEquals("DisplayPlaylists", viewManagerModel.getActiveView());
    }

}