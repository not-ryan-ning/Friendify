package entity;

import java.util.ArrayList;

public class ArtistStrategy implements MatchingStrategy {

    @Override
    public double getSimilarityScore(Playlist playlist1, Playlist playlist2) {
        ArrayList<String> intersection = new ArrayList<>(playlist1.getArtists());
        playlist1.getArtists().retainAll(playlist2.getArtists());
        // Calculating the percentage of common elements by dividing it by the minimum size of the 2 playlists
        double percentageInCommon = (double) intersection.size() / Math.min(playlist1.getArtists().size(),
                playlist2.getArtists().size()) * 100.0;

        return percentageInCommon;

    }
}
