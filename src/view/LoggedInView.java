package view;

import interface_adapter.display_friends.DisplayFriendsState;
import interface_adapter.display_requests.DisplayRequestsState;
import interface_adapter.edit_profile.EditProfileController;
import interface_adapter.edit_profile.EditProfileState;
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

/**
 * The LoggedInView class represents the view of the "main homepage" which users see once they are logged in.
 * It extends JPanel and implements ActionListener and PropertyChangeListener to handle user
 * interactions and property changes.
 * This view includes labels for the username, bio, Spotify handle, and top three artists, which only friends can see,
 * of the loggedin user, as well as buttons to match with others, logout, see requests and friends and edit their
 * profile.
 */
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

        loggedInViewModel.addPropertyChangeListener(this);
        logoutViewModel.addPropertyChangeListener(this);
        displayRequestsViewModel.addPropertyChangeListener(this);
        displayFriendsViewModel.addPropertyChangeListener(this);
        matchViewModel.addPropertyChangeListener(this);
        editProfileViewModel.addPropertyChangeListener(this);


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

    /**
     * Responds to property change events (button clicks), updating the user interface based on certain changes. it maps
     * each unique button click to the corresponding change it results in.
     *
     * @param evt A PropertyChangeEvent object describing the event source and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // need multiple if branches to map each button click to the corresponding action
        LoggedInState loggedInState = (LoggedInState) evt.getNewValue();
        username.setText(loggedInState.getUsername());
        bio.setText(loggedInState.getBio());
        spotifyHandle.setText(loggedInState.getSpotifyHandle());
        topThreeArtists.setText(loggedInState.getTopThreeArtists()); // need to convert this into a string

        if (evt.getPropertyName().equals("displayRequestsState")) {
            DisplayRequestsState state = (DisplayRequestsState) evt.getNewValue();
            state.setUsername(loggedInState.getUsername());
        }

        else if (evt.getPropertyName().equals("displayFriendsState")) {
            DisplayFriendsState state = (DisplayFriendsState) evt.getNewValue();
            state.setUsername(loggedInState.getUsername());
        }

        else if (evt.getPropertyName().equals("matchState")) {
            MatchState state = (MatchState) evt.getNewValue();
            state.setUsername(loggedInState.getUsername());
        }

        else if (evt.getPropertyName().equals("editProfileState")) {
            EditProfileState state = (EditProfileState) evt.getNewValue();
            state.setUsername(loggedInState.getUsername());
        }

        else {
            JOptionPane.showMessageDialog(this, "You have logged out");
        }
    }
}