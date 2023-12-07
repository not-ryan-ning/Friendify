package use_case.edit_spotify_handle;

import data_access.edit_spotify_handle.MockEditSpotifyHandleUserDataAccessObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EditSpotifyHandleInteractorTest {

    private EditSpotifyHandleOutputBoundary mockEditSpotifyHandlePresenter;
    private EditSpotifyHandleUserDataAccessInterface mockEditSpotifyUserDA0;

    @Before
    public void init() {
        this.mockEditSpotifyHandlePresenter = new MockEditSpotifyHandlePresenter();
        this.mockEditSpotifyUserDA0 = new MockEditSpotifyHandleUserDataAccessObject();
    }

    @Test
    public void testInitialization() {
        EditSpotifyHandleInteractor interactor = new EditSpotifyHandleInteractor(mockEditSpotifyUserDA0,
                mockEditSpotifyHandlePresenter);

        assertNotNull(interactor);
    }

    @Test
    public void testExecuteSuccess() {
        EditSpotifyHandleInteractor interactor = new EditSpotifyHandleInteractor(mockEditSpotifyUserDA0,
                mockEditSpotifyHandlePresenter);

        EditSpotifyHandleInputData inputData = new MockEditSpotifyHandleInputData("");

        interactor.execute("", inputData);

        assertEquals("Success", ((MockEditSpotifyHandlePresenter) mockEditSpotifyHandlePresenter).getState());
    }

}
