package interface_adapter.match;

import java.util.ArrayList;
import java.util.HashMap;

public class MatchState {
    private HashMap<String, Double> topSimilarUsers;

    private String username;

    public MatchState(MatchState copy) {
        this.topSimilarUsers = copy.topSimilarUsers;
    }
    public MatchState() {}
    public HashMap<String, Double> getTopSimilarUsers() {
        return topSimilarUsers;
    }
    public void setTopSimilarUsers(HashMap<String, Double> topSimilarUsers) {
        this.topSimilarUsers = topSimilarUsers;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
 }