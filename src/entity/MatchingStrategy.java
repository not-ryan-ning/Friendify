package entity;

import java.util.ArrayList;

public interface MatchingStrategy {

    double getSimilarityScore(Playlist playlist1, Playlist playlist2);
    // calculates the similarity score of two users
}