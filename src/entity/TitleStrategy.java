package entity;

import java.util.ArrayList;

public class TitleStrategy implements MatchingStrategy {

    @Override
    public double getSimilarityScore(Playlist playlist1, Playlist playlist2) {

        // Find the intersection (common song titles) between the two lists
        ArrayList<String> intersection = new ArrayList<>(playlist1.getTitles());
        playlist1.getTitles().retainAll(playlist2.getTitles());

        // Calculate the percentage of common song titles
        double percentageInCommon = (double) intersection.size() /
                Math.min(playlist1.getTitles().size(), playlist2.getTitles().size()) * 100.0;
        // Denominator is the minimum of the two lists
        // Allows % in common to reach 100%

        return percentageInCommon;
    }
}