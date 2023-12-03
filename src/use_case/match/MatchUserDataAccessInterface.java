package use_case.match;

import entity.MatchingStrategy;
import entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public interface MatchUserDataAccessInterface {

    User get(String username);

    /**
     * Returns the similarity scores between the current user and other users in the system,
     * given they are not already friends. The similarity scores are calculated based
     * on the provided matching strategy.
     * @param currentUser The currently logged-in user
     * @param matchingStrategy The matching strategy for how similarity scores are calculated
     * @return A HashMap of usernames mapping to similarity scores
     */
    HashMap<String, Double> getScores(User currentUser, MatchingStrategy matchingStrategy);
}