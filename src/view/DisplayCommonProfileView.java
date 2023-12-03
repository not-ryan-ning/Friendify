package view;

import interface_adapter.display_common_profile.DisplayCommonProfileViewModel;
import interface_adapter.display_common_profile.DisplayCommonProfileViewModel;
import interface_adapter.display_common_profile.DisplayCommonProfileState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The DisplayCommonProfileView class represents the view that displays the common user profile.
 * It extends JPanel and implements ActionListener and PropertyChangeListener to handle user
 * interactions and property changes.
 *  This view includes labels for the username, bio, and Spotify handle,
 *  as well as a button to go back to the logged in view.
 */

public class DisplayCommonProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "User's Profile";
    private final DisplayCommonProfileViewModel displayCommonProfileViewModel;

    JLabel username;
    JLabel spotifyHandle;
    JLabel bio;
    JLabel topThreeArtists;
    public DisplayCommonProfileView(DisplayCommonProfileViewModel displayCommonProfileViewModel) {
        this.displayCommonProfileViewModel = displayCommonProfileViewModel;
        this.displayCommonProfileViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Common User's Profile");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Username: ");
        username = new JLabel();

        JLabel bioInfo = new JLabel("Bio: ");
        bio = new JLabel();

        JLabel spotifyInfo = new JLabel("Spotify handle: ");
        spotifyHandle = new JLabel();

        JLabel topThreeArtistsInfo = new JLabel("Top 3 Artists: ");
        // initializing this label, so if not a friend, we don't need to update this label
        topThreeArtists = new JLabel("You need to be friends to see this...");

        JPanel buttons = new JPanel();

        JButton back = new JButton(GoBackViewModel.GO_BACK_LABEL);
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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(bioInfo);
        this.add(bio);
        this.add(spotifyInfo);
        this.add(spotifyHandle);
        this.add(buttons);
        this.add(topThreeArtistsInfo);
        this.add(topThreeArtists);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // for back button
        System.out.println("Click " + e.getActionCommand());
    }

    /**
     * Responds to property change events, updating DisplayCommonProfileView to display their username, bio and
     * top 3 artists.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DisplayCommonProfileState state = (DisplayCommonProfileState) evt.getNewValue();
        username.setText(state.getUsername());
        bio.setText(state.getCommonProfile().getBio());
        spotifyHandle.setText(state.getCommonProfile().getSpotifyHandle());
    }
}
