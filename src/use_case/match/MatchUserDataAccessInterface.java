package use_case.match;

import entity.User;

import java.util.ArrayList;

public interface MatchUserDataAccessInterface {

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
    ArrayList<String> match(User currentUser);
    // Loop through all the non-friend users' playlists, and runs the matching strategy or strategies.
    // Return an array list of matches
    // Still need to think of the threshold for scores
}