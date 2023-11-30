package interface_adapter.match;

import entity.User;
import interface_adapter.logged_in.LoggedInState;
import use_case.match.MatchInputBoundary;

public class MatchController {
    final MatchInputBoundary matchInteractor;

    public MatchController(MatchInputBoundary matchInputBoundary) {
        this.matchInteractor = matchInputBoundary;
    }

    public void execute(String currentUsername) {
        matchInteractor.execute(currentUsername);
    }
}
