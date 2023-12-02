package view;

import interface_adapter.display_profile.DisplayProfileController;
import interface_adapter.display_profile.DisplayProfileViewModel;
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

import interface_adapter.go_back.GoBackController;
import interface_adapter.go_back.GoBackViewModel;
import interface_adapter.logged_in.LoggedInViewModel;

public class DisplayRequestsView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewname = "display requests";
    private final DisplayRequestsController displayRequestsController;
    private final DisplayRequestsViewModel displayRequestsViewModel;
    private final DisplayProfileController displayProfileController;
    private final DisplayProfileViewModel displayProfileViewModel;
    // private final AcceptRequestsController acceptRequestsController;
    // private final AcceptRequestsViewModel acceptRequestsViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final GoBackController goBackController;
    private final GoBackViewModel goBackViewModel;

    public DisplayRequestsView(DisplayRequestsViewModel displayRequestsViewModel,
                               DisplayRequestsController displayRequestsController,
                               DisplayProfileController displayProfileController,
                               DisplayProfileViewModel displayProfileViewModel,
                               // AcceptRequestsController acceptRequestsController,
                               // AcceptRequestsViewModel acceptRequestsViewModel,
                               LoggedInViewModel loggedInViewModel,
                               GoBackController goBackController,
                               GoBackViewModel goBackViewModel) {
        this.displayRequestsController = displayRequestsController;
        this.displayRequestsViewModel = displayRequestsViewModel;
        this.displayProfileController = displayProfileController;
        this.displayProfileViewModel = displayProfileViewModel;
        // this.acceptRequestsController = acceptRequestsController;
        // this.acceptRequestsViewModel = acceptRequestsViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.goBackController = goBackController;
        this.goBackViewModel = goBackViewModel;

        displayRequestsViewModel.addPropertyChangeListener(this);
        displayProfileViewModel.addPropertyChangeListener(this);
        // acceptRequestsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(DisplayRequestsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        JButton back = new JButton(GoBackViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        back.addActionListener(this);
        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(back)) {
                            goBackController.execute();
                        }
                    }
                }
        );

        DisplayRequestsState currentState = displayRequestsViewModel.getState();
        ArrayList<String> requests = currentState.getRequests();

        if (!(requests == null)) {
            for (String request : requests) {
                JLabel requestUsername = new JLabel(request);
                this.add(requestUsername);

                JButton viewProfile = new JButton(DisplayProfileViewModel.VIEW_BUTTON_LABEL);
                // Associate each view profile button with the corresponding request username
                viewProfile.putClientProperty("userString", request);
                buttons.add(viewProfile);

                // JButton acceptRequest = new JButton(AcceptRequestsViewModel.ACCEPT_BUTTON_LABEL);
                // Associate each accept button with the corresponding request username
                // acceptRequest.putClientProperty("userString", request);
                // buttons.add(acceptRequest);

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
            }


//            acceptRequest.addActionListener(
//                    new ActionListener() {
//                        public void actionPerformed(ActionEvent evt) {
//                            if (evt.getSource().equals(acceptRequest)) {
//                                AcceptRequestsState currentState = acceptRequestViewModel.getState();
//                                // Retrieve the associated request name
//                                String associatedString = (String) acceptRequest.getClientProperty("userString");
//                                currentState.setRequestName(associatedString);
//
//                                acceptRequestController.execute(
//                                        currentState.getUsername(),
//                                        currentState.getRequestName()
//                                ); // Ryan's use case
//                            }
//                        }
//                    }
//            );
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
        if (evt.getPropertyName().equals("acceptRequestsState")) {
            // AcceptRequestsState acceptRequestsState = (AcceptRequestsState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, "You have accepted a request.");
        }
    }
}
