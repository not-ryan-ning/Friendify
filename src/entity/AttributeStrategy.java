package entity;

import java.util.HashMap;
import java.util.Map;

public class AttributeStrategy implements MatchingStrategy {
    @Override
    public double getSimilarityScore(Playlist playlist1, Playlist playlist2) {
        // Initialize two HashMaps for each playlist
        // Each Key represents a song attribute
        // Each Value represents a normalized percentage of an attribute for a playlist
        Map<String, Double> playlist1Attributes = new HashMap<>();
        Map<String, Double> playlist2Attributes = new HashMap<>();

        playlist1Attributes.put("Acoustiness", playlist1.getAcousticness());
        playlist2Attributes.put("Acoustiness", playlist2.getAcousticness());

        playlist1Attributes.put("Energy", playlist1.getEnergy());
        playlist2Attributes.put("Energy", playlist2.getEnergy());

        playlist1Attributes.put("Instrumentalness", playlist1.getInstrumentalness());
        playlist2Attributes.put("Instrumentalness", playlist2.getInstrumentalness());

        playlist1Attributes.put("Valence", playlist1.getValence());
        playlist2Attributes.put("Valence", playlist2.getValence());

        Double totalSumEuclideanDistances = 0.0;

        // Calculate the Euclidean distances
        // For each attribute, calculate the difference between two playlists, then square the difference
        // The formula is as follows (playlist1.attribute - playlist2.attribute) ** 2
        for (String attribute : playlist1Attributes.keySet()) {
            totalSumEuclideanDistances += Math.pow((playlist1Attributes.get(attribute) -
                    playlist2Attributes.get(attribute)), 2);
        }

        // Similarity score square root of total Euclidean distance.
        // Score of 0 means that the playlists are exactly identical
        return 1.0 - (Math.sqrt(totalSumEuclideanDistances) / 2.0);
    }
}
