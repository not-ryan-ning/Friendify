package use_case.match;

import app.Main;
import interface_adapter.ViewManagerModel;
import interface_adapter.logout.LogoutPresenter;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.swing.*;

import static org.junit.Assert.*;

public class MatchInteractorTest {
    private MatchInteractor matchInteractor;
    private ViewManagerModel viewManagerModel;

    @BeforeEach
    public void setUp() {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        matchInteractor = ...
    }
    @Test
    public void testExecute() {
        matchInteractor.execute("user1");
        assertEquals("display matches", viewManagerModel.getActiveView());
    }

}