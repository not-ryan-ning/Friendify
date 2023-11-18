package entity;

import java.util.ArrayList;

public class ArtistStrategy implements MatchingStrategy {

    @Override
    public double getSimilarityScore(ArrayList playlist1, ArrayList playlist2) {
        ArrayList<String> intersection = new ArrayList<>(playlist1);
        intersection.retainAll(playlist2);
        // Calculating the percentage of common elements by dividing it by the minimum size of the 2 playlists
        double percentageInCommon = (double) intersection.size() / Math.min(playlist1.size(), playlist2.size()) * 100.0;

        return percentageInCommon;

    }

    @Override
    public void setPlaylistInfo(ArrayList<Object> playlist1Features, ArrayList<Object> playlist2Features) {

    }
}
