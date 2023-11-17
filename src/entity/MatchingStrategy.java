package entity;

import java.util.ArrayList;

public interface MatchingStrategy {

    double getSimilarityScore();
    // calculates the similarity score of two users
    void setPlaylistInfo(ArrayList<Object> playlist1Features, ArrayList<Object> playlist2Features);
    // playlist1Features and playlist2Features are array lists of each track's relevant features,
    // which includes titles, artists, acousticness, energy, instrumentalness, and valence
}