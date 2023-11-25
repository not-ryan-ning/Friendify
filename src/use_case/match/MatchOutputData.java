package use_case.match;

import java.util.ArrayList;

public class MatchOutputData {
    private final ArrayList<String> matches;

    public MatchOutputData(ArrayList<String> matches) {
        this.matches = matches;
    }
    public ArrayList<String> getMatches() {
        return matches;
    }
}
