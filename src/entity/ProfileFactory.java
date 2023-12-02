package entity;

import java.util.ArrayList;

/**
 *  The ProfileFactory interface defines a template for classes that implement
 *  the creation of user profiles.
 */
public interface ProfileFactory {

    /**
     * Creates a Profile instance with the specified initial attributes.
     *
     * @param bio             A String representing the user's bio.
     * @param topThreeArtists An ArrayList containing the names of the user's top three artists.
     * @param spotifyHandle   A String representing the user's Spotify handle.
     * @return A Profile object with the specified initial attributes.
     */
    Profile create(String bio, ArrayList<String> topThreeArtists, String spotifyHandle);

}
