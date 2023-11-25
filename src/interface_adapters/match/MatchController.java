package interface_adapters.matching;

import entity.User;
import use_case.matching.MatchingInputBoundary;

public class MatchingController {
    final MatchingInputBoundary matchingInteractor;

    public MatchingController(MatchingInputBoundary matchingInputBoundary) {
        this.matchingInteractor = matchingInputBoundary;
    }

    public void execute() {
        // Retrieve current user from LoggedInState
        User currentUser = LoggedInState.getCurrentUser();
        matchingInteractor.execute(currentUser);
    }
}
