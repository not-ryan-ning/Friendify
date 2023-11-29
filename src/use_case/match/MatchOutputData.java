package use_case.match;

import java.util.ArrayList;

public class MatchOutputData {
    private final ArrayList<String> topSimilarUsers;

    public MatchOutputData(ArrayList<String> topSimilarUsers) {
        this.topSimilarUsers = topSimilarUsers;
    }
    public ArrayList<String> getTopSimilarUsers() {
        return topSimilarUsers;
    }
}