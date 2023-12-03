package use_case.choose_playlist;

import data_access.FilePlaylistsDataAccessObject;
import data_access.FileUserDataAccessObject;
import data_access.SpotifyAPIDataAccessObject;
import entity.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.choose_playlist.ChoosePlaylistPresenter;
import interface_adapter.choose_playlist.ChoosePlaylistViewModel;
import interface_adapter.display_friends.DisplayFriendsPresenter;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.display_playlists.DisplayPlaylistsSpotifyAPIDataAccessInterface;
import use_case.display_profile.DisplayProfileUserDataAccessInterface;
import use_case.display_requests.DisplayRequestsInteractor;
import use_case.display_requests.DisplayRequestsUserDataAccessInterface;
import use_case.edit_profile.EditProfileInteractor;

import java.io.IOException;

import static org.junit.Assert.*;

public class ChoosePlaylistInteractorTest {
    private ChoosePlaylistInteractor choosePlaylistInteractor;
    private ViewManagerModel viewManagerModel;
    @BeforeEach
    public void setUp() throws IOException {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        UserFactory uf = new CommonUserFactory();
        ProfileFactory pf = new CommonProfileFactory();
        PlaylistFactory pyf = new CommonPlaylistFactory();
        ChoosePlaylistUserDataAccessInterface user = new FileUserDataAccessObject("./users", uf, pf);
        ChoosePlaylistPlaylistDataAccessInterface playlistData = new FilePlaylistsDataAccessObject("./users", pyf);
        ChoosePlaylistSpotifyAPIDataAccessInterface playlistSpotify = new SpotifyAPIDataAccessObject();
        choosePlaylistInteractor = new ChoosePlaylistInteractor(user, playlistData, playlistSpotify, new
                ChoosePlaylistPresenter(viewManagerModel, new ChoosePlaylistViewModel()), pyf);
    }
    @Test
    public void testExecute() {
        choosePlaylistInteractor.execute("user", new ChoosePlaylistInputData("id", "playlist", "token"));
        assertEquals("ChoosePlaylist", viewManagerModel.getActiveView());
    }

}