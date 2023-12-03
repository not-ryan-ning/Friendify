package entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TitleStrategy implements MatchingStrategy {
    /**
     * Calculates the Jaccard similarity score between two playlists based on common songs.
     * The Jaccard similarity score is found by the size of the intersection of the two sets of titles divided by
     * the size of the union of the sets.
     * @param playlist1 The first Playlist object for comparison.
     * @param playlist2 The second Playlist object for comparison.
     * @return The Jaccard similarity score between the two playlists.
     */
    @Override
    public double getSimilarityScore(Playlist playlist1, Playlist playlist2) {
        // Get the lists of song titles from the input Playlist Objects, and create sets to get unique elements
        Set<String> titles1 = new HashSet<>(playlist1.getTitles());
        Set<String> titles2 = new HashSet<>(playlist2.getTitles());

        // Find the intersection (common song titles) between the two sets
        Set<String> intersection = new HashSet<>(titles1);
        intersection.retainAll(titles2);

        // Find the union of the two sets
        Set<String> union = new HashSet<>(titles1);
        union.addAll(titles2);

        // Calculate Jaccard similarity score
        double similarityScore = 0.0;
        if (!union.isEmpty()) {
            similarityScore = (double) intersection.size() / union.size();
        }
        return similarityScore;
    }
}