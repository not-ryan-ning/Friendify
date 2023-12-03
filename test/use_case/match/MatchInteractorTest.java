package use_case.match;

import app.Main;
import interface_adapter.ViewManagerModel;
import interface_adapter.logout.LogoutPresenter;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class MatchInteractorTest {
    private MatchInteractor matchInteractor;
    private ViewManagerModel viewManagerModel;

    @Test
    public void testExecute() {
        matchInteractor.execute("user1");
        assertEquals("display matches", viewManagerModel.getActiveView());
    }

}