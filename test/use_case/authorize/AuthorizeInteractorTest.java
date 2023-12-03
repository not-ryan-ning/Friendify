package use_case.authorize;

import data_access.SpotifyAuthenticationDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.authorize.AuthorizePresenter;
import interface_adapter.authorize.AuthorizeViewModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class AuthorizeInteractorTest {
    private AuthorizeInteractor authorizeInteractor;
    private ViewManagerModel viewManagerModel;
    @BeforeEach
    public void setUp() {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        AuthorizeSpotifyAuthenticationDataAccessInterface authentication = new SpotifyAuthenticationDataAccessObject();
        authorizeInteractor = new AuthorizeInteractor(authentication, new AuthorizePresenter(viewManagerModel, new AuthorizeViewModel()));
    }

    @Test
    public void testExecute() {
        authorizeInteractor.execute();
        assertEquals("authorizeState", viewManagerModel.getActiveView());

    }

}