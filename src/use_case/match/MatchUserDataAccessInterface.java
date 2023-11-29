package use_case.match;

import entity.MatchingStrategy;
import entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public interface MatchUserDataAccessInterface {

    User get(String username);

    /**
     * Loops through users who are not the current user's friends, and compares their playlists with
     * the current user's playlist using the matching strategies in the following order:
     * 1. TitleStrategy
     * 2. ArtistStrategy
     * 3. GenreStrategy
     * 4. AttributeStrategy
     * Once 10 matches are found, they are returned.
     * @param currentUser
     * @return an array list of the usernames of the top 10 matches
     */
    HashMap<String, Double> getMatches(User currentUser, MatchingStrategy matchingStrategy);
}