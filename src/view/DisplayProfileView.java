package view;

import interface_adapter.display_profile.DisplayProfileState;
import interface_adapter.display_profile.DisplayProfileViewModel;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DisplayProfileView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "User's Profile";
    private final DisplayProfileViewModel displayProfileViewModel;

    final JButton back;

    JLabel username;
    JLabel spotifyHandle;
    JLabel bio;
    JLabel topThreeArtists;

    /**
     * A window with a title and JButton
     */
    public DisplayProfileView(DisplayProfileViewModel displayProfileViewModel) {
        this.displayProfileViewModel = displayProfileViewModel;
        this.displayProfileViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("User's Profile");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Username: ");
        username = new JLabel();

        JLabel bioInfo = new JLabel("Bio: ");
        bio = new JLabel();

        JLabel spotifyInfo = new JLabel("Spotify handle: ");
        spotifyHandle = new JLabel();

        JLabel topThreeArtists = new JLabel("Top 3 Artists: ");
        // initializing this label, so if not a friend, we don't need to update this label
        topThreeArtists = new JLabel("You need to be friends to see this...");

        JPanel buttons = new JPanel();
        back = new JButton("back");
        buttons.add(back);

        back.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(bioInfo);
        this.add(bio);
        this.add(spotifyInfo);
        this.add(spotifyHandle);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DisplayProfileState state = (DisplayProfileState) evt.getNewValue();
        username.setText(state.getUsername());
        bio.setText(state.getCommonProfile().getBio());
        spotifyHandle.setText(state.getCommonProfile().getSpotifyHandle());
        // Need some way to differentiate between displaying common vs friend

    }
}
