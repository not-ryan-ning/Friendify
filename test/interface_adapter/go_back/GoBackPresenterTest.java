package interface_adapter.go_back;

import app.Main;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import view.DisplayCommonProfileView;
import view.LoggedInView;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class GoBackPresenterTest {
    final private ViewManagerModel viewManagerModel = new ViewManagerModel();
    final private GoBackViewModel goBackViewModel = new GoBackViewModel();
    final private LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
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

        // Choosing to test the go back button found on the Display Common Profile View
        DisplayCommonProfileView sv = (DisplayCommonProfileView) jp2.getComponent(0);
        JPanel buttons = (JPanel) sv.getComponent(0);
        return (JButton) buttons.getComponent(0); //The go back button is the only button in this view
    }
    /**
     * Test GoBack's prepareSuccessView to ensure it switches the views back to the loggedInView on click
     */
    @Test
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