package use_case.login;

import data_access.FileUserDataAccessObject;
import entity.CommonProfileFactory;
import entity.CommonUserFactory;
import entity.ProfileFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static org.junit.Assert.*;

public class LoginInteractorTest {
    private LoginInteractor loginInteractor;
    private ViewManagerModel viewManagerModel;
    @BeforeEach
    public void setUp() throws IOException {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        UserFactory uf = new CommonUserFactory();
        ProfileFactory pf = new CommonProfileFactory();
        LoginUserDataAccessInterface user = new FileUserDataAccessObject("./users", uf, pf);
        loginInteractor = new LoginInteractor(user, new LoginPresenter(viewManagerModel, new LoggedInViewModel(), new LoginViewModel()));
    }
    @Test
    public void testExecute() {
        loginInteractor.execute(new LoginInputData("u", "p"));
        assertEquals("log in", viewManagerModel.getActiveView());
    }

}