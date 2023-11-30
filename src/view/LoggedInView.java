package view;

import interface_adapter.display_friends.DisplayFriendsState;
import interface_adapter.edit_profile.EditProfileController;
import interface_adapter.edit_profile.EditProfileViewModel;
import interface_adapter.display_friends.DisplayFriendsViewModel;
import interface_adapter.display_friends.DisplayFriendsController;
import interface_adapter.display_requests.DisplayRequestsViewModel;
import interface_adapter.display_requests.DisplayRequestsController;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutViewModel;
import interface_adapter.match.MatchController;
import interface_adapter.match.MatchState;
import interface_adapter.match.MatchViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final LogoutViewModel logoutViewModel;
    private final LogoutController logoutController;
    private final DisplayRequestsViewModel displayRequestsViewModel;
    private final DisplayRequestsController displayRequestsController;
    private final DisplayFriendsViewModel displayFriendsViewModel;
    private final DisplayFriendsController displayFriendsController;
    private final MatchViewModel matchViewModel;
    private final MatchController matchController;
    private final EditProfileViewModel editProfileViewModel;
    private final EditProfileController editProfileController;

    JLabel username;
    JLabel bio;
    JLabel spotifyHandle;
    JLabel topThreeArtists;

    final JButton logout;
    final JButton requests;
    final JButton friends;
    final JButton match;
    final JButton editProfile;

    /**
     * A window with a title and a JButton.
     */
    public LoggedInView(LoggedInViewModel loggedInViewModel,
                        LogoutViewModel logoutViewModel,
                        LogoutController logoutController,
                        DisplayRequestsViewModel displayRequestsViewModel,
                        DisplayRequestsController displayRequestsController,
                        DisplayFriendsViewModel displayFriendsViewModel,
                        DisplayFriendsController displayFriendsController,
                        MatchViewModel matchViewModel,
                        MatchController matchController,
                        EditProfileViewModel editProfileViewModel,
                        EditProfileController editProfileController) {

        this.loggedInViewModel = loggedInViewModel;
        this.logoutViewModel = logoutViewModel;
        this.logoutController = logoutController;
        this.displayRequestsViewModel = displayRequestsViewModel;
        this.displayRequestsController = displayRequestsController;
        this.displayFriendsViewModel = displayFriendsViewModel;
        this.displayFriendsController = displayFriendsController;
        this.matchViewModel = matchViewModel;
        this.matchController = matchController;
        this.editProfileViewModel = editProfileViewModel;
        this.editProfileController = editProfileController;

        this.loggedInViewModel.addPropertyChangeListener(this);


        logoutViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Profile");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();
        bio = new JLabel();
        spotifyHandle = new JLabel();
        topThreeArtists = new JLabel();

        JPanel buttons = new JPanel();
        logout = new JButton(loggedInViewModel.LOGOUT_BUTTON_LABEL);
        buttons.add(logout);

        requests = new JButton(loggedInViewModel.REQUESTS_BUTTON_LABEL);
        buttons.add(requests);

        friends = new JButton(loggedInViewModel.FRIENDS_BUTTON_LABEL);
        buttons.add(friends);

        match = new JButton(loggedInViewModel.MATCH_BUTTON_LABEL);
        buttons.add(match);

        editProfile = new JButton(loggedInViewModel.EDIT_PROFILE_BUTTON_LABEL);
        buttons.add(editProfile);

        logout.addActionListener(this);
        logout.addActionListener(
            // This creates an anonymous subclass of ActionListener and instantiates it.
            new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getSource().equals(logout)) {
                        logoutController.execute();
                    }
                }
            }
        );


        requests.addActionListener(this);
        requests.addActionListener(
            // This creates an anonymous subclass of ActionListener and instantiates it.
            new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if (evt.getSource().equals(requests)) {
                        DisplayRequestsState currentState = displayRequestsViewModel.getState();

                        displayRequestsController.execute(currentState.getUsername());
                    }
                }
            }
        );

        friends.addActionListener(this);
        friends.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(friends)) {
                            DisplayFriendsState currentState = displayFriendsViewModel.getState();

                            displayFriendsController.execute(currentState.getUsername());
                        }
                    }
                }
        );

        match.addActionListener(this);
        match.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(match)) {
                            MatchState currentState = matchViewModel.getState();

                            matchController.execute(currentState.getUsername());
                        }
                    }
                }
        );

        editProfile.addActionListener(this);
        editProfile.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(editProfile)) {
                            editProfileController.execute();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(bio);
        this.add(spotifyHandle);
        this.add(topThreeArtists);
        this.add(buttons);
}


    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // need multiple if branches to map each button click to the corresponding action
        if (evt.getPropertyName().equals("state")) {
            LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText(state.getUsername());
        }
        else {
            JOptionPane.showMessageDialog(this, "You have logged out");
        }
    }
}