package use_case.match;

import java.util.ArrayList;
import java.util.HashMap;

public class MatchOutputData {
    private final HashMap<String, Double> matches;

    public MatchOutputData(HashMap<String, Double> matches) {
        this.matches = matches;
    }
    public HashMap<String, Double> getMatches() {
        return matches;
    }
}