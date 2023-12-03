package view;

import interface_adapter.display_friends.DisplayFriendsController;
import interface_adapter.display_friends.DisplayFriendsState;
import interface_adapter.display_friends.DisplayFriendsViewModel;
import interface_adapter.display_profile.DisplayProfileController;
import interface_adapter.display_profile.DisplayProfileViewModel;
import interface_adapter.go_back.GoBackController;
import interface_adapter.go_back.GoBackViewModel;
import interface_adapter.logged_in.LoggedInViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class DisplayFriendsView extends JPanel implements ActionListener, PropertyChangeListener {
    public String viewname = "display friends";
    private final DisplayFriendsController displayFriendsController;
    private final DisplayFriendsViewModel displayFriendsViewModel;
    private final DisplayProfileController displayProfileController;
    private final DisplayProfileViewModel displayProfileViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final GoBackController goBackController;
    private final GoBackViewModel goBackViewModel;
    private JPanel buttons;
    private JPanel friendsComponents;

    public DisplayFriendsView(DisplayFriendsController displayFriendsController,
                              DisplayFriendsViewModel displayFriendsViewModel,
                              DisplayProfileController displayProfileController,
                              DisplayProfileViewModel displayProfileViewModel,
                              LoggedInViewModel loggedInViewModel, GoBackController goBackController,
                              GoBackViewModel goBackViewModel) {

        this.displayFriendsController = displayFriendsController;
        this.displayFriendsViewModel = displayFriendsViewModel;
        this.displayProfileController = displayProfileController;
        this.displayProfileViewModel = displayProfileViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.goBackController = goBackController;
        this.goBackViewModel = goBackViewModel;

        displayFriendsViewModel.addPropertyChangeListener(this);
        displayProfileViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(DisplayFriendsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttons = new JPanel();
        friendsComponents = new JPanel();

        JButton back = new JButton(GoBackViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(buttons);

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(back)) {
                            goBackController.execute();
                        }
                    }
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(friendsComponents);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("displayFriendsState")) {
            DisplayFriendsState displayFriendsState = displayFriendsViewModel.getState();
            ArrayList<String> friends = displayFriendsState.getFriends();

        friendsComponents.removeAll();

        if (!(friends == null)) {
            for (String friend: friends) {
                JLabel friendUsername = new JLabel(friend);
                buttons.add(friendUsername);

                JButton viewProfile = new JButton(DisplayProfileViewModel.VIEW_BUTTON_LABEL);

                // Associate each view profile button with the corresponding friend username
                viewProfile.putClientProperty("userString", friend);
                buttons.add(viewProfile);

                viewProfile.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                if (evt.getSource().equals(viewProfile)) {
                                    // Retrieve the associated friend name
                                    String associatedString = (String) viewProfile.getClientProperty("userString");
                                    displayFriendsState.setFriendName(associatedString);

                                    displayProfileController.execute(
                                            displayFriendsState.getUsername(),
                                            displayFriendsState.getFriendName()
                                    );
                                }
                            }
                        }
                );
                friendsComponents.add(friendUsername);
                friendsComponents.add(viewProfile);
            }
            friendsComponents.revalidate();
            friendsComponents.repaint();
        }
    }
    }
}
