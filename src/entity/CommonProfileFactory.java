package entity;

import java.util.ArrayList;

public class CommonProfileFactory implements ProfileFactory{
    
  @Override
    public Profile create(String bio, ArrayList<String> topThreeArtists, String spotifyHandle) {
        return new CommonProfile(bio, topThreeArtists, spotifyHandle);
    }

}
