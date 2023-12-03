package entity;

import java.util.ArrayList;

/**
 * Implementation of the ProfileFactory interface for creating instances of CommonProfile.
 * This factory provides a method to create CommonProfile objects with specified attributes.
 */
public class CommonProfileFactory implements ProfileFactory{
    
  @Override
    public Profile create(String bio, ArrayList<String> topThreeArtists, String spotifyHandle) {
        return new CommonProfile(bio, topThreeArtists, spotifyHandle);
    }

}
