package view;

import interface_adapter.display_friend_profile.DisplayFriendProfileViewModel;
import interface_adapter.display_friend_profile.DisplayFriendProfileState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class DisplayFriendProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "User's Profile";
    private final DisplayFriendProfileViewModel displayFriendProfileViewModel;

    JLabel username;
    JLabel spotifyHandle;
    JLabel bio;
    JLabel topThreeArtists;
    public DisplayFriendProfileView(DisplayFriendProfileViewModel displayFriendProfileViewModel) {
        this.displayFriendProfileViewModel = displayFriendProfileViewModel;
        this.displayFriendProfileViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("User's Profile");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Username: ");
        username = new JLabel();

        JLabel bioInfo = new JLabel("Bio: ");
        bio = new JLabel();

        JLabel spotifyInfo = new JLabel("Spotify handle: ");
        spotifyHandle = new JLabel();

        JLabel topThreeArtistsInfo = new JLabel("Top 3 Artists: ");
        topThreeArtists = new JLabel();

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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DisplayFriendProfileState state = (DisplayFriendProfileState) evt.getNewValue();
        username.setText(state.getUsername());
        bio.setText(state.getFriendProfile().getBio());
        spotifyHandle.setText(state.getFriendProfile().getSpotifyHandle());

        ArrayList<String> topThreeArtistsList = state.getFriendProfile().getTopThreeArtists();

        // Using String.join to concatenate the elements with a separator (e.g., comma and space)
        String topThreeArtistsText = String.join(", ", topThreeArtistsList);
        topThreeArtists.setText(topThreeArtistsText);
    }
}
