package use_case.match;

import app.Main;
import data_access.FileUserDataAccessObject;
import entity.CommonProfileFactory;
import entity.CommonUserFactory;
import entity.ProfileFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.match.MatchPresenter;
import interface_adapter.match.MatchViewModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.send_request.SendRequestUserDataAccessInterface;

import javax.swing.*;

import java.io.IOException;

import static org.junit.Assert.*;

public class MatchInteractorTest {
    private MatchInteractor matchInteractor;
    private ViewManagerModel viewManagerModel;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        UserFactory uf = new CommonUserFactory();
        ProfileFactory pf = new CommonProfileFactory();
        MatchUserDataAccessInterface user = new FileUserDataAccessObject("./users", uf, pf);
        matchInteractor = new MatchInteractor(user, new MatchPresenter(viewManagerModel, new MatchViewModel()));
    }
    @Test
    public void testExecute() {
        matchInteractor.execute("user1");
        assertEquals("display matches", viewManagerModel.getActiveView());
    }

}