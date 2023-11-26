package interface_adapter.display_matches;

import java.util.HashMap;

public class DisplayMatchesState {
    private HashMap<String, Double> matches;
    public DisplayMatchesState(DisplayMatchesState copy) {
        this.matches = copy.matches;
    }
    public DisplayMatchesState() {}

    public HashMap<String, Double> getMatches() {
        return matches;
    }
    public void setMatches(HashMap<String, Double> matches) {
        this.matches = matches;
    }
}
