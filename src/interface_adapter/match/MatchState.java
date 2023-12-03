package interface_adapter.match;

import java.util.LinkedHashMap;

public class MatchState {
    private LinkedHashMap<String, Double> topSimilarUsers;

    private String username;

    public MatchState(MatchState copy) {
        this.topSimilarUsers = copy.topSimilarUsers;
    }
    public MatchState() {}
    public LinkedHashMap<String, Double> getTopSimilarUsers() {
        return topSimilarUsers;
    }
    public void setTopSimilarUsers(LinkedHashMap<String, Double> topSimilarUsers) {
        this.topSimilarUsers = topSimilarUsers;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
 }