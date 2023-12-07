package use_case.choose_playlist;

import data_access.choose_playlist.MockChoosePlaylistPlaylistDataAccessObject;
import data_access.choose_playlist.MockChoosePlaylistSpotifyAPIDataAccessObject;
import data_access.choose_playlist.MockChoosePlaylistUserDataAccessObject;
import entity.CommonPlaylistFactory;
import entity.PlaylistFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ChoosePlaylistInteractorTest {
    private PlaylistFactory playlistFactory;
    private ChoosePlaylistUserDataAccessInterface mockChoosePlaylistUserDAO;
    private ChoosePlaylistPlaylistDataAccessInterface mockChoosePlaylistPlaylistDAO;
    private ChoosePlaylistSpotifyAPIDataAccessInterface mockChoosePlaylistSpotifyAPIDAO;
    private ChoosePlaylistOutputBoundary mockChoosePlaylistPresenter;

    @Before
    public void init() {
        this.mockChoosePlaylistUserDAO = new MockChoosePlaylistUserDataAccessObject();
        this.mockChoosePlaylistPlaylistDAO = new MockChoosePlaylistPlaylistDataAccessObject();
        this.mockChoosePlaylistSpotifyAPIDAO = new MockChoosePlaylistSpotifyAPIDataAccessObject();
        this.playlistFactory = new CommonPlaylistFactory();
        this.mockChoosePlaylistPresenter = new MockChoosePlaylistPresenter();
    }

    /**
     * Testing interactor initialization
     */
    @Test
    public void testInitialization() {
        ChoosePlaylistInteractor interactor = new ChoosePlaylistInteractor(mockChoosePlaylistUserDAO,
                mockChoosePlaylistPlaylistDAO,
                mockChoosePlaylistSpotifyAPIDAO,
                mockChoosePlaylistPresenter,
                playlistFactory);

        assertNotNull(interactor);
    }

    @Test
    public void testExecuteSuccess() {
        ChoosePlaylistInputData inputData = new MockChoosePlaylistInputData("1", "name1",
                "123");
        ChoosePlaylistInteractor interactor = new ChoosePlaylistInteractor(mockChoosePlaylistUserDAO,
                mockChoosePlaylistPlaylistDAO,
                mockChoosePlaylistSpotifyAPIDAO,
                mockChoosePlaylistPresenter,
                playlistFactory);

        interactor.execute("", inputData);

        assertEquals("Success", ((MockChoosePlaylistPresenter) mockChoosePlaylistPresenter).getState());

        assertEquals("1", ((MockChoosePlaylistPresenter) mockChoosePlaylistPresenter).getPlaylistName());
    }

    @Test
    public void testExecuteSuccessExists() {
        ChoosePlaylistInputData inputData = new MockChoosePlaylistInputData("check", "name1",
                "123");
        ChoosePlaylistInteractor interactor = new ChoosePlaylistInteractor(mockChoosePlaylistUserDAO,
                mockChoosePlaylistPlaylistDAO,
                mockChoosePlaylistSpotifyAPIDAO,
                mockChoosePlaylistPresenter,
                playlistFactory);

        interactor.execute("", inputData);

        assertEquals("Success", ((MockChoosePlaylistPresenter) mockChoosePlaylistPresenter).getState());

        assertEquals("1", ((MockChoosePlaylistPresenter) mockChoosePlaylistPresenter).getPlaylistName());
    }

}
