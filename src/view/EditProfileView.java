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

import interface_adapter.authorize.AuthorizeController;
import interface_adapter.authorize.AuthorizeState;
import interface_adapter.authorize.AuthorizeViewModel;
import interface_adapter.choose_playlist.ChoosePlaylistController;
import interface_adapter.choose_playlist.ChoosePlaylistState;
import interface_adapter.choose_playlist.ChoosePlaylistViewModel;
import interface_adapter.display_playlists.DisplayPlaylistsController;
import interface_adapter.display_playlists.DisplayPlaylistsState;
import interface_adapter.display_playlists.DisplayPlaylistsViewModel;
import interface_adapter.edit_bio.EditBioController;
import interface_adapter.edit_bio.EditBioState;
import interface_adapter.edit_bio.EditBioViewModel;
import interface_adapter.edit_profile.EditProfileController;
import interface_adapter.edit_profile.EditProfileState;
import interface_adapter.edit_profile.EditProfileViewModel;
import interface_adapter.edit_spotify_handle.EditSpotifyHandleController;
import interface_adapter.edit_spotify_handle.EditSpotifyHandleState;
import interface_adapter.edit_spotify_handle.EditSpotifyHandleViewModel;


public class EditProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "edit profile";
    private final JTextField changeBioInputField = new JTextField(50);
    private final JTextField changeSpotifyInputField = new JTextField(15);

    private final EditProfileController editProfileController;
    private final EditProfileViewModel editProfileViewModel;
    private final EditBioController editBioController;
    private final EditBioViewModel editBioViewModel;
    private final DisplayPlaylistsController displayPlaylistsController;
    private final DisplayPlaylistsViewModel displayPlaylistsViewModel;
    private final AuthorizeController authorizeController;
    private final AuthorizeViewModel authorizeViewModel;
    private final ChoosePlaylistController choosePlaylistController;
    private final ChoosePlaylistViewModel choosePlaylistViewModel;
    private final EditSpotifyHandleController editSpotifyHandleController;
    private final EditSpotifyHandleViewModel editSpotifyHandleViewModel;
    private final GoBackController goBackController;
    private final GoBackViewModel goBackViewModel;

    private final JButton saveBio;
    private final JButton displayPlaylists;
    private final JButton savePlaylist;
    private final JButton saveSpotifyHandle;
    private final JButton goBack;

    public EditProfileView(EditProfileController editProfileController, EditProfileViewModel editProfileViewModel,
                           EditBioController editBioController, EditBioViewModel editBioViewModel,
                           DisplayPlaylistsController displayPlaylistsController, DisplayPlaylistsViewModel displayPlaylistsViewModel,
                           AuthorizeController authorizeController, AuthorizeViewModel authorizeViewModel,
                           ChoosePlaylistController choosePlaylistController, ChoosePlaylistViewModel choosePlaylistViewModel,
                           EditSpotifyHandleController editSpotifyHandleController, EditSpotifyHandleViewModel editSpotifyHandleViewModel,
                           GoBackController goBackController, GoBackViewModel goBackViewModel) {
        // EditProfile
        this.editProfileController = editProfileController;
        this.editProfileViewModel = editProfileViewModel;
        // EditBio
        this.editBioController = editBioController;
        this.editBioViewModel = editBioViewModel;
        // Authorize
        this.authorizeController = authorizeController;
        this.authorizeViewModel = authorizeViewModel;
        // DisplayPlaylists
        this.displayPlaylistsController = displayPlaylistsController;
        this.displayPlaylistsViewModel = displayPlaylistsViewModel;
        // ChoosePlaylist
        this.choosePlaylistController = choosePlaylistController;
        this.choosePlaylistViewModel = choosePlaylistViewModel;
        // EditSpotifyHandle
        this.editSpotifyHandleController = editSpotifyHandleController;
        this.editSpotifyHandleViewModel = editSpotifyHandleViewModel;
        // GoBack
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
                new JLabel(EditBioViewModel.BIO_LABEL), changeBioInputField);
        LabelTextPanel spotifyInfo = new LabelTextPanel(
                new JLabel(EditSpotifyHandleViewModel.SPOTIFY_HANDLE_LABEL), changeSpotifyInputField);

        // Creating all the buttons
        JPanel buttons = new JPanel();

        saveBio = new JButton(EditBioViewModel.SAVE_BIO_BUTTON_LABEL);
        buttons.add(saveBio);

        displayPlaylists = new JButton(DisplayPlaylistsViewModel.DISPLAY_PLAYLISTS_BUTTON_LABEL);
        buttons.add(displayPlaylists);

        savePlaylist = new JButton(ChoosePlaylistViewModel.SAVE_PLAYLIST_BUTTON_LABEL);
        buttons.add(savePlaylist);

        saveSpotifyHandle = new JButton(EditSpotifyHandleViewModel.SAVE_SPOTIFY_HANDLE_BUTTON_LABEL);
        buttons.add(saveSpotifyHandle);

        goBack = new JButton(GoBackViewModel.GO_BACK_LABEL);
        buttons.add(goBack);


        saveBio.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(saveBio)) {
                            String username = editProfileViewModel.getState().getUsername();
                            EditBioState currentState = editBioViewModel.getState();

                            editBioController.execute(
                                    username,
                                    currentState.getBio()
                            );
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
                            String username = editProfileViewModel.getState().getUsername();
                            ChoosePlaylistState currentState = choosePlaylistViewModel.getState();

                            choosePlaylistController.execute(
                                    username,
                                    currentState.getPlaylistId(),
                                    currentState.getPlaylistName(),
                                    currentState.getAccessToken()
                            );
                        }
                    }
                }
        );

        saveSpotifyHandle.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(saveSpotifyHandle)) {
                            String username = editProfileViewModel.getState().getUsername();
                            EditSpotifyHandleState currentState = editSpotifyHandleViewModel.getState();

                            editSpotifyHandleController.execute(
                                    username,
                                    currentState.getSpotifyHandle()
                            );
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
                        EditBioState currentState = editBioViewModel.getState();
                        currentState.setBio(changeBioInputField.getText() + e.getKeyChar());
                        editBioViewModel.setState(currentState);
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
                        EditSpotifyHandleState currentState = editSpotifyHandleViewModel.getState();
                        currentState.setSpotifyHandle(changeSpotifyInputField.getText() + e.getKeyChar());
                        editSpotifyHandleViewModel.setState(currentState);
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
                this.add(spotifyInfo);
                this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
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
            displayPlaylistsViewModel.setState(displayPlaylistsState);

        } else if (evt.getPropertyName().equals("displayPlaylistsState")) {
            DisplayPlaylistsState displayPlaylistsState = (DisplayPlaylistsState) evt.getNewValue();
            List<String> playlistNames = new ArrayList<>(displayPlaylistsState.getPlaylistIdName().values());

            // Create a JList with a single selection model
            JList<String> playlistSelectList = new JList<String>((ListModel<String>) playlistNames);
            playlistSelectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            // Get the selected playlist name and its id, and username
            String playlistName = playlistSelectList.getSelectedValue();
            String playlistId = getKeyByValue(displayPlaylistsState.getPlaylistIdName(), playlistName);

            // Update the choosePlaylistViewModel
            ChoosePlaylistState choosePlaylistState = new ChoosePlaylistState();
            choosePlaylistState.setPlaylistId(playlistId);
            choosePlaylistState.setPlaylistName(playlistName);
            choosePlaylistState.setAccessToken(displayPlaylistsState.getAccessToken());
            choosePlaylistViewModel.setState(choosePlaylistState);

        } else if (evt.getPropertyName().equals("choosePlaylistState")) {
            ChoosePlaylistState choosePlaylistState = (ChoosePlaylistState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, choosePlaylistState.getPlaylistName());

        } else if (evt.getPropertyName().equals("editSpotifyHandleState")) {
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