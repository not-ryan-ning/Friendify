package use_case.signup;

import data_access.FileUserDataAccessObject;

import static org.junit.Assert.*;

import entity.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.match.MatchInteractor;
import use_case.send_request.SendRequestUserDataAccessInterface;
import view.LoginView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SignupInteractorTest {
    private SignupInteractor signupInteractor;
    private ViewManagerModel viewManagerModel;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        UserFactory uf = new CommonUserFactory();
        ProfileFactory pf = new CommonProfileFactory();
        PlaylistFactory pyf = new CommonPlaylistFactory();
        SignupUserDataAccessInterface user = new FileUserDataAccessObject("./users", uf, pf);
        signUpInteractor = new SignupInteractor(user, new SignupPresenter(viewManagerModel, new SignupViewModel(), new LoginViewModel()), uf, pf, pyf);
    }
    @Test
    public void testExecute() {
        signupInteractor.execute(new SignupInputData("user", "p", "p"));
       // assertEquals("display matches", viewManagerModel.getActiveView());
    }
}