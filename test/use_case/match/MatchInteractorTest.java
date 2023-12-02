package use_case.match;

import app.Main;
import interface_adapter.ViewManagerModel;
import interface_adapter.logout.LogoutPresenter;

import javax.swing.*;

import static org.junit.Assert.*;

public class MatchInteractorTest {
    private MatchInteractor matchInteractor;
    private ViewManagerModel viewManagerModel;

    public void testExecute() {
        // how do we initialize viewManagerModel and LoginViewModel and logoutViewModel?
        matchInteractor.execute("user1");
        assertEquals("Display Matches View", viewManagerModel.getActiveView());
    }

}