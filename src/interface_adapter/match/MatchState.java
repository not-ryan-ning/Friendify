package interface_adapter.match;

import java.util.HashMap;

public class MatchState {
    private HashMap<String, Double> matches;

    public MatchState(MatchState copy) {
        this.matches = copy.matches;
    }
    public MatchState() {}
    public HashMap<String, Double> getMatches() {
        return matches;
    }
    public void setMatches(HashMap<String, Double> matches) {
        this.matches = matches;
    }
}