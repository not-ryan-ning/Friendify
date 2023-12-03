package use_case.match;

import java.util.LinkedHashMap;

public class MatchOutputData {
    private LinkedHashMap<String, Double> topSimilarUsers;

    public MatchOutputData(LinkedHashMap<String, Double> topSimilarUsers) {
        this.topSimilarUsers = topSimilarUsers;
    }
    public LinkedHashMap<String, Double> getTopSimilarUsers() {
        return topSimilarUsers;
    }
}