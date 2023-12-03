package use_case.match;

import java.util.LinkedHashMap;

public class MatchOutputData {
<<<<<<< HEAD
    private final HashMap<String, Double> topSimilarUsers;
    public MatchOutputData(HashMap<String, Double> topSimilarUsers) {
=======
    private LinkedHashMap<String, Double> topSimilarUsers;

    public MatchOutputData(LinkedHashMap<String, Double> topSimilarUsers) {
>>>>>>> main
        this.topSimilarUsers = topSimilarUsers;
    }
    public LinkedHashMap<String, Double> getTopSimilarUsers() {
        return topSimilarUsers;
    }
}