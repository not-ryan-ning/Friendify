package view;

import interface_adapter.display_requests.DisplayRequestsController;
import interface_adapter.display_requests.DisplayRequestsState;
import interface_adapter.display_requests.DisplayRequestsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import entity.User;

public class DisplayRequestsView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewname = "Display Requests";
    private final DisplayRequestsViewModel displayRequestsViewModel;
    private final DisplayRequestsController displayRequestsController;
    private final DisplayProfileController displayProfileController;
    private final LoggedInViewModel loggedInViewModel;

    public DisplayRequestsView(DisplayRequestsViewModel displayRequestsViewModel, DisplayRequestsController displayRequestsController,
                               DisplayProfileController displayProfileController, LoggedInViewModel loggedInViewModel) {
        this.displayRequestsViewModel = displayRequestsViewModel;
        this.displayRequestsController = displayRequestsController;
        this.displayProfileController = displayProfileController;
        this.loggedInViewModel = loggedInViewModel;

        JLabel title = new JLabel(DisplayRequestsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        LoggedInState currentState = loggedInViewModel.getState();
        User user = currentState.getUser();

        // Assuming that there is a user object being passed around
        ArrayList<String> requests = user.getRequests();
        for (String request : requests) {
            JButton view = new JButton("view " + request + "'s profile");
            buttons.add(view);

            view.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(view)) {

                                displayProfileController.execute();
                            }
                        }
                    }
            );
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            this.add(title);
            this.add(buttons);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
