package entity;

public class AttributeStrategy implements MatchingStrategy {
    @Override
    public double getSimilarityScore(Playlist playlist1, Playlist playlist2) {
        double acousticness1 = playlist1.getAcousticness();
        double acousticness2 = playlist2.getAcousticness();
        double energy1 = playlist1.getEnergy();
        double energy2 = playlist2.getEnergy();
        double instrumentalness1 = playlist1.getInstrumentalness();
        double instrumentalness2 = playlist2.getInstrumentalness();
        double valence1 = playlist1.getValence();
        double valence2 = playlist2.getValence();

        // Calculate dot product
        double dotProduct = acousticness1 * acousticness2 + energy1 * energy2 +
                instrumentalness1 * instrumentalness2 + valence1 * valence2;

        // Calculate magnitudes
        double magnitude1 = Math.sqrt(acousticness1 * acousticness1 + energy1 * energy1 +
                instrumentalness1 * instrumentalness1 + valence1 * valence1);
        double magnitude2 = Math.sqrt(acousticness2 * acousticness2 + energy2 * energy2 +
                instrumentalness2 * instrumentalness2 + valence2 * valence2);

        // Calculate cosine similarity
        if (magnitude1 == 0 || magnitude2 == 0) {
            return 0.0; // Handle the case when one or both playlists have no attributes
        } else {
            return dotProduct / (magnitude1 * magnitude2);
        }
    }
}