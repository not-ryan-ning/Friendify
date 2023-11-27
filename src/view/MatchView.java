package view;

import interface_adapter.match.MatchState;
import interface_adapter.match.MatchViewModel;
import interface_adapter.send_request.SendRequestController;
import interface_adapter.send_request.SendRequestState;
import interface_adapter.send_request.SendRequestViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class MatchView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "display matches";
    private final MatchViewModel matchViewModel;
    private final SendRequestViewModel sendRequestViewModel;
    private final SendRequestController sendRequestController;

    public MatchView(MatchViewModel matchViewModel,
                     SendRequestViewModel sendRequestViewModel,
                     SendRequestController sendRequestController) {

        this.matchViewModel = matchViewModel;
        this.sendRequestViewModel = sendRequestViewModel;
        this.sendRequestController = sendRequestController;

        matchViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(MatchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        // Adding request buttons for all the matches from the current state
        MatchState currentState = matchViewModel.getState();
        HashMap<String, Double> matches = currentState.getMatches();

        for (String username : matches.keySet()) {
            JLabel matchUsername = new JLabel(username);
            JLabel similarityScore = new JLabel(matches.get(username).toString());

            this.add(matchUsername);
            this.add(similarityScore);

            JButton request = new JButton(MatchViewModel.REQUEST_BUTTON_LABEL);
            buttons.add(request);

            request.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(request)) {
                                SendRequestState currentState = sendRequestViewModel.getState();
                                String senderUsername = currentState.getUsername();
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SendRequestState state = (SendRequestState) evt.getNewValue();
        if (state.getRequestError() != null) {
            JOptionPane.showMessageDialog(this, state.getRequestError());
        }
        JOptionPane.showMessageDialog(this, state.getRequestSentMessage());
    }
}