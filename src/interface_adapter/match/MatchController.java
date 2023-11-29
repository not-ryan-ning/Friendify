package interface_adapter.match;

import entity.User;
import interface_adapter.logged_in.LoggedInState;
import use_case.match.MatchInputBoundary;

public class MatchController {
    final MatchInputBoundary matchInteractor;

    final LoggedInState loggedInState;

    public MatchController(MatchInputBoundary matchInputBoundary,
                           LoggedInState loggedInState) {
        this.matchInteractor = matchInputBoundary;
        this.loggedInState = loggedInState;
    }

    public void execute(String currentUsername) {
        matchInteractor.execute(currentUsername);
    }
}
