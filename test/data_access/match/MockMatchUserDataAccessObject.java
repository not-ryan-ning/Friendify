package data_access.match;

import entity.*;
import use_case.match.MatchUserDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MockMatchUserDataAccessObject implements MatchUserDataAccessInterface {
    @Override
    public User get(String username) {
        ProfileFactory profileFactory = new CommonProfileFactory();
        PlaylistFactory playlistFactory = new CommonPlaylistFactory();
        UserFactory userFactory = new CommonUserFactory();

        ArrayList<String> title1 = new ArrayList<>(List.of("Pretender"));

        HashMap<String, Integer> artist1 = new HashMap<>();
        artist1.put("Valley", 2);

        HashMap<String, Integer> genre1 = new HashMap<>();
        genre1.put("Jazz", 3);
        genre1.put("Pop", 4);

        Playlist playlist1 = playlistFactory.create("1", title1, artist1, genre1,
                0.0, 0.0, 0.0, 0.0,
                new ArrayList<>());

        Profile emptyProfile = profileFactory.create("", new ArrayList<>(), "");

        User user = userFactory.create("", "", emptyProfile, playlist1,
                new ArrayList<>(), new ArrayList<>());

        return user;
    }

    @Override
    public HashMap<String, Double> getScores(User currentUser, MatchingStrategy matchingStrategy) {
        HashMap<String, Double> map1 = new HashMap<>();
        map1.put("Valley", 2.0);

        return map1;
    }
}
