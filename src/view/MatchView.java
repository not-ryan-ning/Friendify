package view;

import interface_adapter.match.MatchState;
import interface_adapter.match.MatchViewModel;
import interface_adapter.send_request.SendRequestViewModel;
import interface_adapter.send_request.SendRequestController;
import interface_adapter.send_request.SendRequestState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

/**
 *  The MatchView class represents a panel for displaying the logged-in user's matches.
 * This view displays a list of matched users with their similarity scores, and buttons for the logged-in user to
 * send requests or go back to the loggedinView.
 */
public class MatchView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "display matches";
    private final MatchViewModel matchViewModel;
    private final SendRequestViewModel sendRequestViewModel;
    private final SendRequestController sendRequestController;
    private final GoBackViewModel goBackViewModel;

    public MatchView(MatchViewModel matchViewModel,
                     SendRequestViewModel sendRequestViewModel,
                     SendRequestController sendRequestController,
                     GoBackViewModel goBackViewModel) {

        this.matchViewModel = matchViewModel;
        this.sendRequestViewModel = sendRequestViewModel;
        this.sendRequestController = sendRequestController;
        this.goBackViewModel = goBackViewModel;

        matchViewModel.addPropertyChangeListener(this);
        sendRequestViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(MatchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        // Adding request buttons for all the matches from the current state
        MatchState currentState = matchViewModel.getState();
        HashMap<String, Double> topSimilarUsers = currentState.getTopSimilarUsers();

        for (String username : topSimilarUsers.keySet()) {
            JLabel matchUsername = new JLabel(username);
            JLabel similarityScore = new JLabel(topSimilarUsers.get(username).toString());

            this.add(matchUsername);
            this.add(similarityScore);

            JButton request = new JButton(MatchViewModel.REQUEST_BUTTON_LABEL);

            // Associate each request button with the corresponding top similar username
            request.putClientProperty("userString", username);
            buttons.add(request);

            JButton back = new JButton(GoBackViewModel.GO_BACK_LABEL);
            buttons.add(back);

            request.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(request)) {
                                // Retrieve the associated username
                                String associatedString = (String) request.getClientProperty("userString");
                                SendRequestState currentState = sendRequestViewModel.getState();
                                String senderUsername = currentState.getUsername();
                                currentState.setReceiverUsername(associatedString);
                                String receiverUsername = currentState.getReceiverUsername();

                                sendRequestController.execute(senderUsername, receiverUsername);
                            }
                        }
                    }
            );
        }
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    /**
     * Responds to property change events (button clicks), updating the Match View to either a fail message or a
     * request sent message.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SendRequestState state = (SendRequestState) evt.getNewValue();
        if (state.getRequestError() != null) {
            JOptionPane.showMessageDialog(this, state.getRequestError());
        } else {
            JOptionPane.showMessageDialog(this, state.getRequestSentMessage());
        }
    }
}