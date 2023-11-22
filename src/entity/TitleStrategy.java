package entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TitleStrategy implements MatchingStrategy {

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