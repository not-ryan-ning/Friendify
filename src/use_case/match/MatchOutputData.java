package use_case.match;

import java.util.HashMap;

public class MatchOutputData {
    private final HashMap<String, Double> topSimilarUsers;
    public MatchOutputData(HashMap<String, Double> topSimilarUsers) {
        this.topSimilarUsers = topSimilarUsers;
    }
    public HashMap<String, Double> getTopSimilarUsers() {
        return topSimilarUsers;
    }
}