package entity;

import java.util.ArrayList;

public interface ProfileFactory {
    Profile create(String bio, ArrayList<String> topThreeArtists, String spotifyHandle);
}
