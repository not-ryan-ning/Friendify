package view.view;

import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_out.LoggedOutViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutState;
import interface_adapter.logout.LogoutViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedOutView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "logged in";
    private final LoggedOutViewModel loggedOutViewModel;
    private final LogoutViewModel logoutViewModel;
    private final LogoutController logoutController;

    JLabel username;

//    final JButton logout;

    /**
     * A window with a title and a JButton.
     */
    public LoggedOutView(LoggedOutViewModel loggedOutViewModel, LogoutViewModel logoutViewModel, LogoutController logoutController) {
        this.loggedOutViewModel = loggedOutViewModel;
        this.loggedOutViewModel.addPropertyChangeListener(this);
        this.logoutViewModel = logoutViewModel;
        this.logoutController = logoutController;

        logoutViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Logged Out Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Currently logged out: ");
        username = new JLabel();

        JPanel buttons = new JPanel();
//        logout = new JButton(loggedInViewModel.LOGOUT_BUTTON_LABEL);
//        buttons.add(logout);
//
//        logout.addActionListener(this);
//        logout.addActionListener(
//                // This creates an anonymous subclass of ActionListener and instantiates it.
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(logout)) {
//                            logoutController.execute();
//                        }
//                    }
//                }
//        );
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//        this.add(title);
//        this.add(usernameInfo);
//        this.add(username);
//        this.add(buttons);
//    }
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText(state.getUsername());
        } else {
            LogoutState state = (LogoutState) evt.getNewValue();
            // String message = state.getLoggedoutUser();
            JOptionPane.showMessageDialog(this, "You have logged out.");
        }
    }
}
