package entity;

import java.util.HashMap;

public class GenreStrategy implements MatchingStrategy {
    @Override
    public double getSimilarityScore(Playlist playlist1, Playlist playlist2) {
        // Calculates the dot product of the genre frequencies and then normalizes it
        // by dividing by the magnitudes of the individual playlists

        HashMap<String, Integer> genreFrequency1 = playlist1.getGenres();
        HashMap<String, Integer> genreFrequency2 = playlist2.getGenres();

        // Calculate the magnitudes
        double magnitude1 = calculateMagnitude(genreFrequency1);
        double magnitude2 = calculateMagnitude(genreFrequency2);

        // Calculate the dot product
        double dotProduct = 0.0;
        for (String genre : genreFrequency1.keySet()) {
            if (genreFrequency2.containsKey(genre)) {
                dotProduct += genreFrequency1.get(genre) * genreFrequency2.get(genre);
            }
        }

        // Calculate cosine similarity score
        if (magnitude1 == 0 || magnitude2 == 0) {
            return 0.0; // Handle the case when one or both playlists have no genres
        } else {
            return dotProduct / (magnitude1 * magnitude2);
        }
    }

    // calculating the length of
    private double calculateMagnitude(HashMap<String, Integer> genreFrequency) {
        double magtinude = 0.0;
        for (int frequency: genreFrequency.values()) {
            magtinude += Math.pow(frequency, 2);
        }
        return Math.sqrt(magtinude);
    }
}
