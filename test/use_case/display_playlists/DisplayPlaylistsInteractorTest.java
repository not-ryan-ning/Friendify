package use_case.display_playlists;

import data_access.SpotifyAPIDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.display_playlists.DisplayPlaylistsPresenter;
import interface_adapter.display_playlists.DisplayPlaylistsViewModel;
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
        DisplayPlaylistsSpotifyAPIDataAccessInterface playlist = new SpotifyAPIDataAccessObject();
        displayPlaylistsInteractor = new DisplayPlaylistsInteractor(playlist, new DisplayPlaylistsPresenter(viewManagerModel, new DisplayPlaylistsViewModel()));
    }
    @Test
    public void testExecute() {
        displayPlaylistsInteractor.execute(new DisplayPlaylistsInputData("token"));
        assertEquals("DisplayPlaylists", viewManagerModel.getActiveView());
    }

}