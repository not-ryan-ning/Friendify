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

public class DisplayCommonProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "User's Profile";
    private final DisplayCommonProfileViewModel displayCommonProfileViewModel;

    final JButton back;

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
        back = new JButton("back");
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DisplayCommonProfileState state = (DisplayCommonProfileState) evt.getNewValue();
        username.setText(state.getUsername());
        bio.setText(state.getCommonProfile().getBio());
        spotifyHandle.setText(state.getCommonProfile().getSpotifyHandle());
    }
}
