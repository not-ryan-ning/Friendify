package interface_adapters.match;

import entity.User;
import interface_adapters.logged_in.LoggedInState;
import use_case.match.MatchInputBoundary;

public class MatchController {
    final MatchInputBoundary matchInteractor;

    final LoggedInState loggedInState;

    public MatchController(MatchInputBoundary matchInputBoundary,
                           LoggedInState loggedInState) {
        this.matchInteractor = matchInputBoundary;
        this.loggedInState = loggedInState;
    }

    public void execute() {
        // Retrieve current user from LoggedInState
        User currentUser = loggedInState.getCurrentUser();
        matchInteractor.execute(currentUser);
    }
}
