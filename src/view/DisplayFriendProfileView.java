package view;

import interface_adapter.display_friend_profile.DisplayFriendProfileViewModel;
import interface_adapter.display_friend_profile.DisplayFriendProfileState;
import interface_adapter.go_back.GoBackController;
import interface_adapter.go_back.GoBackViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The DisplayFriendProfileView class represents the view that displays the friend user profile.
 * It extends JPanel and implements ActionListener and PropertyChangeListener to handle user
 * interactions and property changes.
 *  This view includes labels for the username, bio, Spotify handle, and top three artists, which only friends can see,
 *  as well as a button to go back to the logged in view.
 */
public class DisplayFriendProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "display friend profile";
    private final DisplayFriendProfileViewModel displayFriendProfileViewModel;
    private final GoBackController goBackController;
    private final GoBackViewModel goBackViewModel;

    JLabel username;
    JLabel bio;
    JLabel topThreeArtists;
    JLabel spotifyHandle;
    public DisplayFriendProfileView(DisplayFriendProfileViewModel displayFriendProfileViewModel,
                                    GoBackController goBackController,
                                    GoBackViewModel goBackViewModel) {
        this.displayFriendProfileViewModel = displayFriendProfileViewModel;
        this.goBackController = goBackController;
        this.goBackViewModel = goBackViewModel;

        this.displayFriendProfileViewModel.addPropertyChangeListener(this);
        this.goBackViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("User's Profile");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel(DisplayFriendProfileViewModel.USERNAME_LABEL);
        username = new JLabel();

        JLabel bioInfo = new JLabel(DisplayFriendProfileViewModel.BIO_LABEL);
        bio = new JLabel();

        JLabel topThreeArtistsInfo = new JLabel(DisplayFriendProfileViewModel.TOP_THREE_ARTISTS_LABEL);
        topThreeArtists = new JLabel();

        JLabel spotifyInfo = new JLabel(DisplayFriendProfileViewModel.SPOTIFY_HANDLE);
        spotifyHandle = new JLabel();

        JPanel buttons = new JPanel();

        JButton goBack = new JButton(GoBackViewModel.BACK_BUTTON_LABEL);
        buttons.add(goBack);

        goBack.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(goBack)) {
                            goBackController.execute();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(bioInfo);
        this.add(bio);
        this.add(topThreeArtistsInfo);
        this.add(topThreeArtists);
        this.add(spotifyInfo);
        this.add(spotifyHandle);
        this.add(buttons);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // for back button
        System.out.println("Click " + e.getActionCommand());
    }

    /**
     * Responds to property change events, updating DisplayFriendProfileView to display the username, bio, spotify handle
     * and top 3 artists.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DisplayFriendProfileState currentState = displayFriendProfileViewModel.getState();
        username.setText(currentState.getUsername());
        bio.setText(currentState.getBio());
        topThreeArtists.setText(String.join(", ", currentState.getTopThreeArtists()));
        spotifyHandle.setText(currentState.getSpotifyHandle());
    }
}
