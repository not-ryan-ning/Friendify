package entity;

import data_access.FileUserDataAccessObject;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

public class CommonProfileTest {
    private Profile profile;

    /**
     * Add a user so that we can test its common profile
     */
    @BeforeEach
    public void addUser() {
        UserFactory uf = new CommonUserFactory();
        ProfileFactory pf = new CommonProfileFactory();
        FileUserDataAccessObject fudao;
        try {
            fudao = new FileUserDataAccessObject("./users.csv", uf, pf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> topThreeArtists = new ArrayList<>(Arrays.asList("Artist1", "Artist2", "Artist3"));
        profile = new CommonProfile("Hi", topThreeArtists, "spotify_handle1");
        Playlist playlist = new CommonPlaylist("id", new ArrayList<>(), new HashMap<>(), new HashMap<>(), 0, 0,0,0, new ArrayList<>());

        fudao.save(uf.create("user1", "password1", profile, playlist, new ArrayList<>(), new ArrayList<>()));

        profile.setBio("hello");
        profile.setSpotifyHandle("11");
        profile.setTopThreeArtists(new ArrayList<>(Arrays.asList("1", "2", "3")));
    }

    /**
     *
     * Testing the setter methods of CommonProfile to ensure they correctly update.
     */
    @org.junit.Test
    public void testSetBio() {
        assertEquals("hello", profile.getBio());
    }
    @org.junit.Test
    public void testSetSpotifyHandle() {
        assertEquals("11", profile.getSpotifyHandle());

    }
    @org.junit.Test
    public void testSetTopThreeArtists() {
        assertEquals(new ArrayList<>(Arrays.asList("1", "2", "3")), profile.getTopThreeArtists());

    }

}