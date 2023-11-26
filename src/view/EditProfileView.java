package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

import interface_adapter.edit_profile.EditProfileController;
import interface_adapter.edit_profile.EditProfileState;
import interface_adapter.edit_profile.EditProfileViewModel;


public class EditProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "edit profile";
    private final JTextField changeBioInputField = new JTextField(50);
    private final JTextField changeSpotifyInputField = new JTextField(15);

    private final EditProfileController editProfileController;
    private final EditProfileViewModel editProfileViewModel;
    private final EditBioController editBioController;
    private final EditBioViewModel editBioViewModel;
    private final AuthorizeController authorizeController;
    private final AuthorizeViewModel authorizeViewModel;
    private final DisplayPlaylistsController displayPlaylistsController;
    private final DisplayPlaylistsViewModel displayPlaylistsViewModel;
    private final ChoosePlaylistController choosePlaylistController;
    private final ChoosePlaylistViewModel choosePlaylistViewModel;
    private final EditSpotifyHandleController editSpotifyHandleController;
    private final EditSpotifyHandleViewModel editSpotifyHandleViewModel;
    private final GoBackController goBackController;
    private final GoBackViewModel goBackViewModel;

    public EditProfileView(EditProfileController editProfileController, EditProfileViewModel editProfileViewModel,
                           EditBioController editBioController, EditBioViewModel editBioViewModel,
                           AuthorizeController authorizeController, AuthorizeViewModel authorizeViewModel,
                           DisplayPlaylistsController displayPlaylistsController, DisplayPlaylistsViewModel displayPlaylistsViewModel,
                           ChoosePlaylistController choosePlaylistController, ChoosePlaylistViewModel choosePlaylistViewModel,
                           EditSpotifyHandleController editSpotifyHandleController, EditSpotifyHandleViewModel editSpotifyHandleViewModel,
                           GoBackController goBackController, GoBackViewModel goBackViewModel) {
        this.editProfileController = editProfileController;
        this.editProfileViewModel = editProfileViewModel;
        this.editBioController = editBioController;
        this.editBioViewModel = editBioViewModel;
        this.authorizeController = authorizeController;
        this.authorizeViewModel = authorizeViewModel;
        this.displayPlaylistsController = displayPlaylistsController;
        this.displayPlaylistsViewModel = displayPlaylistsViewModel;
        this.choosePlaylistController = choosePlaylistController;
        this.choosePlaylistViewModel = choosePlaylistViewModel;
        this.editSpotifyHandleController = editSpotifyHandleController;
        this.editSpotifyHandleViewModel = editSpotifyHandleViewModel;
        this.goBackController = goBackController;
        this.goBackViewModel = goBackViewModel;
        editProfileViewModel.addPropertyChangeListener(this);
        editBioViewModel.addPropertyChangeListener(this);
        authorizeViewModel.addPropertyChangeListener(this);
        displayPlaylistsViewModel.addPropertyChangeListener(this);
        choosePlaylistViewModel.addPropertyChangeListener(this);
        editSpotifyHandleViewModel.addPropertyChangeListener(this);
        goBackViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(EditProfileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel bioInfo = new LabelTextPanel(
                new JLabel(EditProfileViewModel.BIO_LABEL), changeBioInputField);
        LabelTextPanel playlistInfo = new LabelTextPanel(
                new JLabel(EditProfileViewModel.PLAYLIST_LABEL), changePlaylistInputField );
        LabelTextPanel spotifyInfo = new LabelTextPanel(
                new JLabel(EditProfileViewModel.SPOTIY_HANDLE_LABEL), changeSpotifyInputField);

        JPanel buttons = new JPanel();

        saveBio = new JButton(EditProfileViewModel.SAVE_BIO_LABEL);
        buttons.add(saveBio);

        displayPlaylists = new JButton(EditProfileViewModel.DISPLAY_PLAYLISTS_LABEL);
        buttons.add(displayPlaylists);

        savePlaylist = new JButton(EditProfileViewModel.SAVE_PLAYLIST_LABEL);
        buttons.add(savePlaylist);

        saveSpotifyHandle = new JButton(EditProfileViewModel.SAVE_SPOTIFY_HANDLE_LABEL);
        buttons.add(saveSpotify);

        goBack = new JButton(EditProfileViewModel.GO_BACK_LABEL);
        buttons.add(goBack);

        saveBio.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(saveBio)) {
                            EditBioState currentState = editBioViewModel.getState();

                            editBioController.execute(currentState.getBio());
                        }
                    }
                }
        );

        displayPlaylists.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(displayPlaylists)) {
                            AuthorizeState authorizeState = authorizeViewModel.getState();
                            String authorizationLink = authorizeState.getAuthorizationLink();
                            openWebLink(authorizationLink);
                            authorizeController.execute();

                            DisplayPlaylistsState currentState = displayPlaylistsViewModel.getState();
                            displayPlaylistsController.execute(currentState.getAccessToken());
                        }
                    }
                }
        );

        savePlaylist.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(savePlaylist)) {
                            ChoosePlaylistState currentState = choosePlaylistViewModel.getState();

                            choosePlaylistController.execute(currentState.getPlaylistId(), currentState.getPlaylistName,
                                    currentState.getAccessToken());
                        }
                    }
                }
        );

        saveSpotify.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(saveSpotify)) {
                            EditSpotifyHandleState currentState = editSpotifyHandleViewModel.getState();

                            editSpotifyHandleController.execute(currentState.getSpotifyHandle());
                        }
                    }
                }
        );

        goBack.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(goBack)) {
                            goBackController.execute();
                        }
                    }
                }
        );

        changeBioInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditProfileState currentState = editProfileViewModel.getState();
                        currentState.setBio(changeBioInputField.getText() + e.getKeyChar());
                        editProfileViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        changeSpotifyInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditProfileState currentState = editProfileViewModel.getState();
                        currentState.setSpotify(changeSpotifyInputField.getText() + e.getKeyChar());
                        editProfileViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
                this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

                this.add(title);
                this.add(bioInfo);
                this.add(playlistInfo);
                this.add(spotifyInfo);
                this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("editBioState")) {
            EditBioState editBioState = (EditBioState) evt.getNewValue();
            changeBioInputField.setText(editBioState.getBio());

        } else if (evt.getPropertyName().equals("authorizeState")) {
            AuthorizeState authorizeState = (AuthorizeState) evt.getNewValue();
            DisplayPlaylistsState displayPlaylistsState = new DisplayPlaylistsState();
            displayPlaylistsState.setAccessToken(authorizeState.getAccessToken());

        } else if (evt.getPropertyName().equals("displayPlaylistsState")) {
            DisplayPlaylistsState displayPlaylistsState = (DisplayPlaylistsState) evt.getNewValue();
            List playlistNames = new ArrayList<String>(displayPlaylistsState.getPlaylistIdNames().values());

            // Create a JList with a single selection model
            JList<String> playlistSelectList = new JList<String>((ListModel<String>) playlistNames);
            playlistSelectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            // Get the selected playlist name and its id
            String playlistName = playlistSelectList.getSelectedValue();
            String playlistId = getKeyByValue(displayPlaylistsState.getPlaylistIdNames(), playlistName);

            // Update the choosePlaylistViewModel
            ChoosePlaylistState choosePlaylistState = new ChoosePlaylistState();
            choosePlaylistState.setPlaylistId(playlistId);
            choosePlaylistState.setPlaylistName(playlistName);
            choosePlaylistState.setAccessToken(displayPlaylistsState.getAccessToken());
            choosePlaylistViewModel.setState(choosePlaylistState);

        } else if (evt.getPropertyName().equals("choosePlaylistState")) {
            ChoosePlaylistState choosePlaylistState = (ChoosePlaylistState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, choosePlaylistState.getPlaylistName());

        } else if (evt.getPropertyName().equals("editSpotifyHandle")) {
            EditSpotifyHandleState editSpotifyHandleState = (EditSpotifyHandleState) evt.getNewValue();
            changeSpotifyInputField.setText(editSpotifyHandleState.getSpotifyHandle());
        }
    }
    private static void openWebLink(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }

    private static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null; // Value not found in the map
    }
}


