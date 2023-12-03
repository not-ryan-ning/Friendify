package interface_adapter.match;

import interface_adapter.logged_in.LoggedInState;
import use_case.match.MatchInputBoundary;

/**
 * Initiates operations related to matching a user with other users.
 */
public class MatchController {
    final MatchInputBoundary matchInteractor;

    public MatchController(MatchInputBoundary matchInputBoundary) {
        this.matchInteractor = matchInputBoundary;
    }

    public void execute(String currentUsername) {
        matchInteractor.execute(currentUsername);
    }
}
