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
        if
        DisplayProfileState state = (DisplayProfileState) evt.getNewValue();
        username.setText(state.getCommonProfile().getUsername());
        bio.setText(state.getCommonProfile().getBio());
        spotifyHandle.setText(state.getCommonProfile().getSpotifyHandle());
        // Need some way
            state.getCommonProfile().getTopThreeArtists();
    }
}
