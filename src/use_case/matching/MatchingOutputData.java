package use_case.matching;

import java.util.ArrayList;

public class MatchingOutputData {
    private final ArrayList<String> matches;

    public MatchingOutputData(ArrayList<String> matches) {
        this.matches = matches;
    }
    public ArrayList<String> getMatches() {
        return matches;
    }
}
