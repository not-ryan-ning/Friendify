package entity;

import java.util.ArrayList;

public class TitleStrategy implements MatchingStrategy {
    private ArrayList<String> playlist1Titles;
    private ArrayList<String> playlist2Titles;

    @Override
    public double getSimilarityScore() {

        // Find the intersection (common song titles) between the two lists
        ArrayList<String> intersection = new ArrayList<>(playlist1Titles);
        playlist1Titles.retainAll(playlist2Titles);

        // Calculate the percentage of common song titles
        double percentageInCommon = (double) intersection.size() /
                Math.min(playlist1Titles.size(), playlist2Titles.size()) * 100.0;

        return percentageInCommon;
    }

    @Override
    public void setPlaylistInfo(ArrayList<Object> playlist1Features, ArrayList<Object> playlist2Features) {
        this.playlist1Titles = (ArrayList<String>) playlist1Features.get(0);
        this.playlist2Titles = (ArrayList<String>) playlist2Features.get(0);
    }
}