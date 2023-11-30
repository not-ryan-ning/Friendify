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

        JButton back = new JButton("Go Back");
        buttons.add(back);

        back.addActionListener(this);
        back.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(back)) {
                            backController.execute();
                        }
                    }
                }
        );


        // Adding view profile and accept request buttons for every request
        DisplayRequestsState currentState = displayRequestsViewModel.getState();
        ArrayList<String> requests = currentState.getRequests();
        for (String request : requests) {
            JLabel requestUsername = new JLabel(request);
            this.add(requestUsername);

            JButton view = new JButton(DisplayRequestsViewModel.VIEW_BUTTON_LABEL);
            buttons.add(view);

            JButton accept = new JButton(DisplayRequestsViewModel.ACCEPT_BUTTON_LABEL);
            buttons.add(accept);

            view.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(view)) {
                                displayProfileController.execute();
                            }
                        }
                    }
            );

            accept.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(accept)) {

                                acceptRequestController.execute(); // Ryan's use case
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
        JOptionPane.showConfirmDialog(this, "You have accepted this request.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //does not display anything for either state...

    }
}
