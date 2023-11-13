package data_access;

import use_case.matching.MatchingFileUserDataAccessObject;

import java.util.ArrayList;

public class FileUserDataAccessObject implements MatchingFileUserDataAccessObject {
    @Override
    public ArrayList<String> getArtists() {
        ArrayList<String> artists = new ArrayList<String>();
        return artists;
    }

    @Override
    public ArrayList<String> getTitles() {
        ArrayList<String> titles = new ArrayList<String>();
        return titles;
    }

    @Override
    public double getAcousticness(String playlistId) {
        return -1.0;
    }

    @Override
    public double getEnergy(String playlistId) {
        return -1.0;
    }

    @Override
    public double getInstrumentalness(String playlistId) {
        return -1.0;
    }

    @Override
    public double getValence(String playlistId) {
        return -1.0;
    }

    @Override
    public String getGenre(String playlistId) {
        return "iu";
    }
}
