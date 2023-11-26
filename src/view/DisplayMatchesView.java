package view;

import interface_adapter.display_matches.DisplayMatchesState;
import interface_adapter.display_matches.DisplayMatchesViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.match.MatchController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class DisplayMatchesView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "display matches";
    private final LoggedInViewModel loggedInViewModel;
    private final DisplayMatchesViewModel displayMatchesViewModel;
    private final MatchController matchController;

    public DisplayMatchesView(DisplayMatchesViewModel displayMatchesViewModel,
                              MatchController matchController,
                              LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.displayMatchesViewModel = displayMatchesViewModel;
        this.matchController = matchController;

        JLabel title = new JLabel(DisplayMatchesViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        // Adding request buttons for all the matches from the current state
        DisplayMatchesState currentState = displayMatchesViewModel.getState();
        HashMap<String, Double> matches = currentState.getMatches();

        for (String username : matches.keySet()) {
            JButton request = new JButton(DisplayMatchesViewModel.REQUEST_BUTTON_LABEL);
            buttons.add(request);
            JLabel matchUsername = new JLabel(username);
            JLabel similarityScore = new JLabel(matches.get(username).toString());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
