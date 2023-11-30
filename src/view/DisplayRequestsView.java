package view;

import interface_adapter.display_friends.DisplayFriendsState;
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
import interface_adapter.edit_bio.EditBioState;
import interface_adapter.logged_in.LoggedInViewModel;

public class DisplayRequestsView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewname = "display requests";
    private final DisplayRequestsController displayRequestsController;
    private final DisplayRequestsViewModel displayRequestsViewModel;
    private final DisplayProfileController displayProfileController;
    private final DisplayProfileViewModel displayProfileViewModel;
    private final AcceptRequestsController acceptRequestsController;
    private final AcceptRequestsViewModel acceptRequestsViewModel;
    private final LoggedInViewModel loggedInViewModel;

    public DisplayRequestsView(DisplayRequestsViewModel displayRequestsViewModel,
                               DisplayRequestsController displayRequestsController,
                               DisplayProfileViewModel displayProfileViewModel,
                               DisplayProfileController displayProfileController,
                               AcceptRequestsController acceptRequestsController,
                               AcceptRequestsViewModel acceptRequestsViewModel,
                               LoggedInViewModel loggedInViewModel) {
        this.displayRequestsController = displayRequestsController;
        this.displayRequestsViewModel = displayRequestsViewModel;
        this.displayProfileController = displayProfileController;
        this.displayProfileViewModel = displayProfileViewModel;
        this.acceptRequestsController = acceptRequestsController;
        this.acceptRequestsViewModel = acceptRequestsViewModel;
        this.loggedInViewModel = loggedInViewModel;

        displayRequestsViewModel.addPropertyChangeListener(this);
        displayProfileViewModel.addPropertyChangeListener(this);
        acceptRequestsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(DisplayRequestsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        DisplayRequestsState currentState = displayRequestsViewModel.getState();
        ArrayList<String> requests = currentState.getRequests();

        for (String request : requests) {
            JLabel requestUsername = new JLabel(request);
            this.add(requestUsername);

            JButton viewProfile = new JButton(DisplayProfileViewModel.VIEW_BUTTON_LABEL);
            // Associate each view profile button with the corresponding request username
            viewProfile.putClientProperty("userString", request);
            buttons.add(viewProfile);

            JButton acceptRequest = new JButton(AcceptRequestsViewModel.ACCEPT_BUTTON_LABEL);
            // Associate each accept button with the corresponding request username
            acceptRequest.putClientProperty("userString", request);
            buttons.add(acceptRequest);

            viewProfile.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(viewProfile)) {
                                DisplayRequestsState currentState = displayRequestsViewModel.getState();
                                // Retrieve the associated request name
                                String associatedString = (String) viewProfile.getClientProperty("userString");
                                currentState.setRequestName(associatedString);

                                displayProfileController.execute(
                                        currentState.getUsername(),
                                        currentState.getRequestName()
                                );
                            }
                        }
                    }
            );

            acceptRequest.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(acceptRequest)) {
                                AcceptRequestsState currentState = acceptRequestViewModel.getState();
                                // Retrieve the associated request name
                                String associatedString = (String) acceptRequest.getClientProperty("userString");
                                currentState.setRequestName(associatedString);

                                acceptRequestController.execute(
                                        currentState.getUsername(),
                                        currentState.getRequestName()
                                ); // Ryan's use case
                            }
                        }
                    }
            );
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            this.add(title);
            this.add(buttons);
        }
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("acceptRequestsState")) {
            JOptionPane.showMessageDialog(this, "You have accepted a request.");
        }
    }
}
