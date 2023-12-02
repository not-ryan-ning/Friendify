package view;

import app.Main;
import data_access.FileUserDataAccessObject;
import entity.*;

import java.io.IOException;
import java.time.LocalDateTime;
import data_access.FileUserDataAccessObject;
import entity.CommonUserFactory;
import entity.UserFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class LogoutTest {
    public JButton getButton() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }
        assertNotNull(app);

        // verify that these are correct so that the logout button is the one selected
        Component root = app.getComponent(0); //or 2?
        Component cp = ((JRootPane) root).getContentPane();
        JPanel jp = (JPanel) cp;
        JPanel jp2 = (JPanel) jp.getComponent(0);
        LoggedInView sv = (LoggedInView) jp2.getComponent(0);
        JPanel buttons = (JPanel) sv.getComponent(0);
        return (JButton) buttons.getComponent(0); //should be the logout button
    }

    /**
     *
     * Test that pressing the logout button takes the user back to the login view. In this view, we check that
     * the previous login information is not saved in the corresponding text fields.
     */
    public void testLogoutSwitchesToLogin() {
        Main.main(null);
        JButton button = getButton();
        button.doClick();

        // need some way to get a view panel before simulating the button click
        assertEquals("Log In", yourViewsPanel.getComponent(0).getName());
    }
}
