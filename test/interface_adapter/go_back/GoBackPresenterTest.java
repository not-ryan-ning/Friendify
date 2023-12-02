package interface_adapter.go_back;

import app.Main;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import org.junit.jupiter.api.BeforeEach;
import view.LoggedInView;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class GoBackPresenterTest {
    private ViewManagerModel viewManagerModel;
    private GoBackViewModel goBackViewModel;
    private LoggedInViewModel loggedInViewModel;
    @BeforeEach
    public JButton getButton() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }
        assertNotNull(app);

        // MODIFY FOR GO BACK:
        Component root = app.getComponent(0); //but there are multiple go back buttons that are in different frames
        Component cp = ((JRootPane) root).getContentPane();
        JPanel jp = (JPanel) cp;
        JPanel jp2 = (JPanel) jp.getComponent(0);
        LoggedInView sv = (LoggedInView) jp2.getComponent(0);
        JPanel buttons = (JPanel) sv.getComponent(0);
        return (JButton) buttons.getComponent(0); //should be the go back button
    }
    /**
     *
     * Test GoBack's prepareSuccessView to ensure it switches the views back to the loggedInView on click
     */
    @org.junit.Test
    public void goBackSucessTest() {
        Main.main(null);
        JButton button = getButton();
        button.doClick();

        // how do we initialize viewManagerModel and LoginViewModel and logoutViewModel?
        GoBackPresenter goBackPresenter = new GoBackPresenter(viewManagerModel, goBackViewModel, loggedInViewModel);
        goBackPresenter.prepareSuccessView();

        assertEquals("logged in", viewManagerModel.getActiveView());
    }

}