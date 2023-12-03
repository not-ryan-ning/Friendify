package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class ArtistStrategy implements MatchingStrategy {

    /**
     * Calculates the cosine similarity score based on the common artists and its frequency in two playlists.
     * @param playlist1 The first Playlist object for comparison. The first playlist for comparison.
     * @param playlist2 The second Playlist object for comparison. The second playlist for comparison.
     * @return The cosine similarity score between the two playlists.
     */
    @Override
    public double getSimilarityScore(Playlist playlist1, Playlist playlist2) {
        HashMap<String, Integer> artistFrequency1 = playlist1.getArtists();
        HashMap<String, Integer> artistFrequency2 = playlist2.getArtists();

        // Calculate the magnitudes
        double magnitude1 = calculateMagnitude(artistFrequency1);
        double magnitude2 = calculateMagnitude(artistFrequency2);

        // get the dot product:
        double dotProduct = 0.0;
        for (String artist : artistFrequency1.keySet()) {
            if (artistFrequency2.containsKey(artist)) {
                dotProduct += artistFrequency1.get(artist) * artistFrequency2.get(artist);
            }
        }

        // Calculate cosine similarity score
        if (magnitude1 == 0 || magnitude2 == 0) {
            return 0.0; // Handle the case when one or both playlists have no artists
        } else {
            return dotProduct / (magnitude1 * magnitude2);
        }
    }

    /**
     * Calculates the magnitude of a playlist's artist frequencies, which is used in the
     * computation of cosine similarity.
     * @param artistFrequency A mapping of artist names to their frequencies in the playlist.
     * @return The magnitude of the artist frequencies in the playlist.
     */
    private double calculateMagnitude(HashMap<String, Integer> artistFrequency) {
        double magnitude = 0.0;
        for (int frequency: artistFrequency.values()) {
            magnitude += Math.pow(frequency, 2);
        }
        return Math.sqrt(magnitude);
    }
}
