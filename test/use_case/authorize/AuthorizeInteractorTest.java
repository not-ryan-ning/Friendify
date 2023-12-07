package use_case.authorize;

import data_access.authorize.MockSpotifyAuthenticationDataAccessObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AuthorizeInteractorTest {
    private AuthorizeSpotifyAuthenticationDataAccessInterface mockSpotifyAuthenticationDAO;
    private AuthorizeOutputBoundary mockAuthorizePresenter;

    @Before
    public void init() {
        this.mockAuthorizePresenter = new MockAuthorizePresenter();
    }

    @Test
    public void testInitialization() {
        AuthorizeInteractor interactor = new AuthorizeInteractor(mockSpotifyAuthenticationDAO,
                mockAuthorizePresenter);

        assertNotNull(interactor);
    }

    @Test
    public void testExecuteSuccess() {
        this.mockSpotifyAuthenticationDAO = new MockSpotifyAuthenticationDataAccessObject(true);
        AuthorizeInteractor interactor = new AuthorizeInteractor(mockSpotifyAuthenticationDAO,
                mockAuthorizePresenter);

        interactor.execute("");

        assertEquals("Success", ((MockAuthorizePresenter) mockAuthorizePresenter).getState());
    }

    @Test
    public void testExecuteFail() {
        this.mockSpotifyAuthenticationDAO = new MockSpotifyAuthenticationDataAccessObject(false);

        AuthorizeInteractor interactor = new AuthorizeInteractor(mockSpotifyAuthenticationDAO,
                mockAuthorizePresenter);

        interactor.execute("");

        assertEquals("Failure", ((MockAuthorizePresenter) mockAuthorizePresenter).getState());
    }

    @Test
    public void testAccessData() {
        this.mockSpotifyAuthenticationDAO = new MockSpotifyAuthenticationDataAccessObject(false);

        AuthorizeInteractor interactor = new AuthorizeInteractor(mockSpotifyAuthenticationDAO,
                mockAuthorizePresenter);

        interactor.execute("");

        assertEquals("Failure", ((MockAuthorizePresenter) mockAuthorizePresenter).getState());
    }


}
