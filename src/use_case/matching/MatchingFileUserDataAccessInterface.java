package use_case.matching;

import java.util.ArrayList;

public interface MatchingFileUserDataAccessInterface {
    // returns all artists from the playlist
    ArrayList<String> getArtists();
    // returns all song titles from the playlist
    ArrayList<String> getTitles();

    // getAcousticness(Playlist.playlistId)
    // 0-1
    double getAcousticness(String playlistId);
    // 0-1
    double getEnergy(String playlistId);
    // 0-1
    double getInstrumentalness(String playlistId);
    // 0-1
    double getValence(String playlistId);
}
