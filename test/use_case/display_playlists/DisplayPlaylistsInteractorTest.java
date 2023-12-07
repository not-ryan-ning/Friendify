package use_case.display_playlists;

import data_access.display_playlists.MockDisplayPlaylistsSpotifyAPIDataAccessObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DisplayPlaylistsInteractorTest {
    private DisplayPlaylistsSpotifyAPIDataAccessInterface mockDisplayPlaylistsSpotifyAPIDAO;
    private DisplayPlaylistsOutputBoundary mockDisplayPlaylistsPresenter;

    @Before
    public void init() {
        this.mockDisplayPlaylistsSpotifyAPIDAO = new MockDisplayPlaylistsSpotifyAPIDataAccessObject();
        this.mockDisplayPlaylistsPresenter = new MockDisplayPlaylistsPresenter();
    }

    @Test
    public void testInitialization() {
        DisplayPlaylistsInteractor interactor = new DisplayPlaylistsInteractor(mockDisplayPlaylistsSpotifyAPIDAO,
                mockDisplayPlaylistsPresenter);

        assertNotNull(interactor);
    }

    @Test
    public void testExecuteSuccess() {
        DisplayPlaylistsInteractor interactor = new DisplayPlaylistsInteractor(mockDisplayPlaylistsSpotifyAPIDAO,
                mockDisplayPlaylistsPresenter);

        DisplayPlaylistsInputData inputData = new MockDisplayPlaylistsInputData("123");

        interactor.execute(inputData);

        assertEquals("Success", ((MockDisplayPlaylistsPresenter) mockDisplayPlaylistsPresenter).getState());

    }

}
