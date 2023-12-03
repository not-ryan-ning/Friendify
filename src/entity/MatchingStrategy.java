package entity;

import java.util.ArrayList;

/**
 * The MatchingStrategy interface provides a template for classes, with
 * a method for calculating the similarity score between two playlists.
 */

public interface MatchingStrategy {
    /**
     * Calculates similarity score of two user's playlists
     * @param playlist1 The first Playlist object for comparison.
     * @param playlist2 The second Playlist object for comparison.
     * @return A double representing the similarity score between the two playlists. The score depends
     * on the specific MatchingStrategy implementation.
     */
    double getSimilarityScore(Playlist playlist1, Playlist playlist2);
    // calculates the similarity score of two users' playlists
}