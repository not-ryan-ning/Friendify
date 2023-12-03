package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import interface_adapter.go_back.GoBackController;
import interface_adapter.go_back.GoBackViewModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;

/**
 * The EditProfileView class represents the view that displays prompts which allows users to modify their information.
 *  This view includes labels and buttons so a user can change and save their bio, playlist, spotify handle as well as
 *  go back to the loggedinView.
 */
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
    private final LoggedInViewModel loggedInViewModel;

    private final JButton saveBio;
    private final JButton displayPlaylists;
    private final JButton savePlaylist;
    private final JButton saveSpotifyHandle;
    private final JButton back;
    private final JList<String> playlistSelectList;
    private final DefaultListModel<String> listModel;
    private final JScrollPane scrollPane;

    public EditProfileView(EditProfileController editProfileController, EditProfileViewModel editProfileViewModel,
                           EditBioController editBioController, EditBioViewModel editBioViewModel,
                           DisplayPlaylistsController displayPlaylistsController, DisplayPlaylistsViewModel displayPlaylistsViewModel,
                           AuthorizeController authorizeController, AuthorizeViewModel authorizeViewModel,
                           ChoosePlaylistController choosePlaylistController, ChoosePlaylistViewModel choosePlaylistViewModel,
                           EditSpotifyHandleController editSpotifyHandleController, EditSpotifyHandleViewModel editSpotifyHandleViewModel,
                           GoBackController goBackController, GoBackViewModel goBackViewModel, LoggedInViewModel loggedInViewModel) {
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
        // Logged In
        this.loggedInViewModel = loggedInViewModel;

        editProfileViewModel.addPropertyChangeListener(this);
        editBioViewModel.addPropertyChangeListener(this);
        authorizeViewModel.addPropertyChangeListener(this);
        displayPlaylistsViewModel.addPropertyChangeListener(this);
        choosePlaylistViewModel.addPropertyChangeListener(this);
        editSpotifyHandleViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(EditProfileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel bioInfo = new LabelTextPanel(
                new JLabel(EditBioViewModel.BIO_LABEL), changeBioInputField);
        LabelTextPanel spotifyInfo = new LabelTextPanel(
                new JLabel(EditSpotifyHandleViewModel.SPOTIFY_HANDLE_LABEL), changeSpotifyInputField);

        // Create JList and JScrollPane
        listModel = new DefaultListModel<>();
        playlistSelectList = new JList<>(listModel);
        playlistSelectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(playlistSelectList);
        scrollPane.setPreferredSize(new Dimension(200, 200));
        scrollPane.setVisible(false);
        JPanel buttonsAndScroll = new JPanel();
        buttonsAndScroll.setLayout(new BoxLayout(buttonsAndScroll, BoxLayout.Y_AXIS));

        JPanel buttons = new JPanel();

        saveBio = new JButton(EditBioViewModel.SAVE_BIO_BUTTON_LABEL);
        buttons.add(saveBio);

        saveSpotifyHandle = new JButton(EditSpotifyHandleViewModel.SAVE_SPOTIFY_HANDLE_BUTTON_LABEL);
        buttons.add(saveSpotifyHandle);

        displayPlaylists = new JButton(DisplayPlaylistsViewModel.DISPLAY_PLAYLISTS_BUTTON_LABEL);
        buttons.add(displayPlaylists);

        savePlaylist = new JButton(ChoosePlaylistViewModel.SAVE_PLAYLIST_BUTTON_LABEL);
        buttons.add(savePlaylist);

        back = new JButton(GoBackViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        EditProfileState editProfileState = editProfileViewModel.getState();

        saveBio.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(saveBio)) {
                            EditBioState currentState = editBioViewModel.getState();

                            editBioController.execute(
                                    editProfileState.getUsername(),
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
                            authorizeController.execute(authorizationLink);

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

                            choosePlaylistController.execute(
                                    editProfileState.getUsername(),
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
                            EditSpotifyHandleState currentState = editSpotifyHandleViewModel.getState();

                            editSpotifyHandleController.execute(
                                    editProfileState.getUsername(),
                                    currentState.getSpotifyHandle()
                            );
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(back)) {
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
        buttonsAndScroll.add(scrollPane);
        buttonsAndScroll.add(buttons);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(bioInfo);
        this.add(spotifyInfo);
        this.add(buttonsAndScroll);
    }

    /**
     * Responds to property change events (button clicks), updating the edit profile view based on certain changes.
     * It maps each unique button click to the corresponding change it results in.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoggedInState loggedInState = loggedInViewModel.getState();

        if (evt.getPropertyName().equals("editBioState")) {
            EditBioState editBioState = (EditBioState) evt.getNewValue();
            changeBioInputField.setText(editBioState.getBio());
            loggedInState.setBio(editBioState.getBio());

        } else if (evt.getPropertyName().equals("authorizeState")) {
            AuthorizeState authorizeState = (AuthorizeState) evt.getNewValue();
            DisplayPlaylistsState displayPlaylistsState = new DisplayPlaylistsState();
            displayPlaylistsState.setAccessToken(authorizeState.getAccessToken());
            displayPlaylistsViewModel.setState(displayPlaylistsState);

        } else if (evt.getPropertyName().equals("displayPlaylistsState")) {
            DisplayPlaylistsState displayPlaylistsState = (DisplayPlaylistsState) evt.getNewValue();
            ArrayList<String> playlistNames = new ArrayList<>(displayPlaylistsState.getPlaylistIdName().values());

            // Clear previous data
            listModel.clear();

            // Add new data to the list model
            for (String item : playlistNames) {
                listModel.addElement(item);
            }

            // Make the JScrollPane visible
            scrollPane.setVisible(true);

            // Repaint the panel to reflect changes
            this.revalidate();
            this.repaint();

            playlistSelectList.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        // Get the selected playlist name
                        String playlistName = playlistSelectList.getSelectedValue();

                        // Use the selected playlist name to get the corresponding playlist ID
                        String playlistId = getKeyByValue(displayPlaylistsState.getPlaylistIdName(), playlistName);

                        // Update the choosePlaylistViewModel
                        ChoosePlaylistState choosePlaylistState = new ChoosePlaylistState();
                        choosePlaylistState.setPlaylistId(playlistId);
                        choosePlaylistState.setPlaylistName(playlistName);
                        choosePlaylistState.setAccessToken(displayPlaylistsState.getAccessToken());
                        choosePlaylistViewModel.setState(choosePlaylistState);
                    }
                }
            });
        } else if (evt.getPropertyName().equals("choosePlaylistState")) {
            ChoosePlaylistState choosePlaylistState = (ChoosePlaylistState) evt.getNewValue();
            JOptionPane.showMessageDialog(this, choosePlaylistState.getPlaylistName() + " saved");


        } else if (evt.getPropertyName().equals("editSpotifyHandleState")) {
            EditSpotifyHandleState editSpotifyHandleState = (EditSpotifyHandleState) evt.getNewValue();
            changeSpotifyInputField.setText(editSpotifyHandleState.getSpotifyHandle());
            loggedInState.setSpotifyHandle(editSpotifyHandleState.getSpotifyHandle());
        }
        loggedInViewModel.setState(loggedInState);

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