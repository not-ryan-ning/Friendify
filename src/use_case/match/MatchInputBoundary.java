package use_case.match;

import entity.User;

public interface MatchInputBoundary {
    void execute(User currentUser);
}
