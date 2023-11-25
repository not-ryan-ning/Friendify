package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import interface_adapter.EditProfileController;
import interface_adapter.EditProfileViewModel;
import interface_adapter.EditProfileState;


public class EditProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Edit Profile";
    private final JTextField changeBioInputField = new JTextField(15);
    private final JTextField changePlaylistInputField = new JTextField(15);
    private final JTextField changeSpotifyInputField = new JTextField(15);

    // after a user presses save, it saves the new information and then takes user back to the profile view
    private final JButton save;

    private final EditProfileController editProfileController;
    private final EditProfileViewModel editProfileViewModel;

    public EditProfileView(EditProfileController editProfileController, EditProfileViewModel editProfileViewModel) {
        this.editProfileController = editProfileController;
        this.editProfileViewModel = editProfileViewModel;

        editProfileViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(EditProfileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel bioInfo = new LabelTextPanel(
                new JLabel(EditProfileViewModel.USERNAME_LABEL), changeBioInputField);
        LabelTextPanel playlistInfo = new LabelTextPanel(
                new JLabel(EditProfileViewModel.PASSWORD_LABEL), changePlaylistInputField );
        LabelTextPanel spotifyInfo = new LabelTextPanel(
                new JLabel(EditProfileViewModel.REPEAT_PASSWORD_LABEL), changeSpotifyInputField);

        JPanel buttons = new JPanel();
        save = new JButton(EditProfileViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(save);

        save.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(save)) {
                            EditProfileState currentState = editProfileViewModel.getState();

                            editProfileController.execute(
                                    currentState.setBio(),
                                    currentState.setPlaylist(),
                                    currentState.setSpotify()
                            );
                        }
                    }
                }
        );

        changeBioInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditProfileState currentState = editProfileViewModel.getState();
                        String text = changeBioInputField.getText() + e.getKeyChar();
                        currentState.setBio(text);
                        editProfileViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        changePlaylistInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditProfileState currentState = editProfileViewModel.getState();
                        String text = changePlaylistInputField.getText() + e.getKeyChar();
                        currentState.setPlaylist(text);
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
                        String text = changeSpotifyInputField.getText() + e.getKeyChar();
                        currentState.setSpotify(text);
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
        EditProfileState state = (EditProfileState) evt.getNewValue();
        JOptionPane.showMessageDialog(this, "Saved changes.");

    }
}


