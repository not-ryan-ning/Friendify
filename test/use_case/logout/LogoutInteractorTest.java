package use_case.logout;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.logout.LogoutViewModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class LogoutInteractorTest {
    private LogoutInteractor logoutInteractor;
    private ViewManagerModel viewManagerModel;

    @BeforeEach
    public void setUp() {
        viewManagerModel = new ViewManagerModel();
        logoutInteractor = new LogoutInteractor(new LogoutPresenter(viewManagerModel, new LoginViewModel(), new LogoutViewModel()));
    }
    @Test
    public void testExecute() {
        logoutInteractor.execute();
        assertEquals("log out", viewManagerModel.getActiveView());
    }

}