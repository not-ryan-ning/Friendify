package data_access;

import entity.*;
import use_case.choose_playlist.ChoosePlaylistUserDataAccessInterface;
import use_case.display_friends.DisplayFriendsUserDataAccessInterface;
import use_case.display_profile.DisplayProfileUserDataAccessInterface;
import use_case.display_requests.DisplayRequestsUserDataAccessInterface;
import use_case.edit_bio.EditBioUserDataAccessInterface;
import use_case.edit_spotify_handle.EditSpotifyHandleUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.match.MatchUserDataAccessInterface;
import use_case.send_request.SendRequestUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.*;
import java.util.*;

public class FileUserDataAccessObject implements DisplayFriendsUserDataAccessInterface, ChoosePlaylistUserDataAccessInterface,
        EditBioUserDataAccessInterface, EditSpotifyHandleUserDataAccessInterface, LoginUserDataAccessInterface,
        MatchUserDataAccessInterface, SendRequestUserDataAccessInterface, DisplayRequestsUserDataAccessInterface,
        DisplayProfileUserDataAccessInterface, SignupUserDataAccessInterface {
    private final File usersFile;

    // Contains the content in each column
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    // Maps username to User
    private final Map<String, User> accounts = new HashMap<>();

    // Maps username to Playlist
    private final Map<String, Playlist> usernamePlaylist = new HashMap<>();

    private UserFactory userFactory;
    private ProfileFactory profileFactory;
    private PlaylistFactory playlistFactory;
    private FilePlaylistsDataAccessObject playlistsDataAccessObject;

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory, PlaylistFactory playlistFactory, ProfileFactory profileFactory, FilePlaylistsDataAccessObject filePlaylistsDataAccessObject) throws IOException {
        this.userFactory = userFactory;
        this.profileFactory = profileFactory;
        this.playlistFactory = playlistFactory;
        this.usersFile = new File(csvPath);
        this.playlistsDataAccessObject = filePlaylistsDataAccessObject;

        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("bio", 2);
        headers.put("artists", 3);
        headers.put("spotifyHandle", 4);
        headers.put("playlistId", 5);
        headers.put("friends", 6);
        headers.put("requests", 7);

        if (this.usersFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
                String header = reader.readLine();

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split("\\|");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String bio = String.valueOf(col[headers.get("bio")]);
                    String artists = String.valueOf(col[headers.get("artists")]);
                    String spotifyHandle = String.valueOf(col[headers.get("spotifyHandle")]);
                    String playlistId = String.valueOf(col[headers.get("playlistId")]);
                    String friends = String.valueOf(col[headers.get("friends")]);
                    String requests = String.valueOf(col[headers.get("requests")]);

                    // column format: username, password, bio, artists, spotifyHandle, playlistId, friends, requests
                    String[] topThreeArtistsSplit = artists.substring(1, artists.length() - 1).split(", ");  // Remove square brackets and split
                    ArrayList<String> topThreeArtistsArrayList = new ArrayList<>(Arrays.asList(topThreeArtistsSplit));

                    String[] friendsSplit = friends.substring(1, friends.length() - 1).split(", ");  // Remove square brackets and split
                    ArrayList<String> friendsArrayList = new ArrayList<>(Arrays.asList(friendsSplit));

                    String[] requestsSplit = requests.substring(1, requests.length() - 1).split(", ");  // Remove square brackets and split
                    ArrayList<String> requestsArrayList = new ArrayList<>(Arrays.asList(requestsSplit));

                    Profile profile = profileFactory.create(bio, topThreeArtistsArrayList, spotifyHandle);
                    Playlist playlist = playlistsDataAccessObject.getPlaylist(playlistId);

                    if (playlistId.isEmpty()) {
                        playlist = playlistFactory.create(playlistId, new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                                0.0, 0.0,0.0,0.0, new ArrayList<>());
                    }

                    User user = userFactory.create(username, password, profile, playlist, friendsArrayList, requestsArrayList);
                    accounts.put(username, user);
                }
            }
        }

    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(usersFile));
            writer.write(String.join("|", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                if (user.getPlaylist() != null && user.getProfile() != null){
                    String line = String.format("%s|%s|%s|%s|%s|%s|%s|%s",
                            user.getUsername(), user.getPassword(), user.getProfile().getBio(),
                            user.getProfile().getTopThreeArtists(), user.getProfile().getSpotifyHandle(),
                            user.getPlaylist().getPlaylistId(), user.getFriends(), user.getRequests());
                    writer.write(line);
                    writer.newLine();
                } else {
                    String line = String.format("%s|%s|%s|%s|%s|%s|%s|%s",
                            user.getUsername(), user.getPassword(),
                            "", "[]", "", "", "[]", "[]");
                    writer.write(line);
                    writer.newLine();
                }
            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void save(User user) {
        accounts.put(user.getUsername(), user);
        this.save();
    }

    public User get(String username) {
        return accounts.get(username);
    }

    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    public boolean isRequested(User sender, User receiver) {
        return receiver.getRequests().contains(sender.getUsername());
    }

    public ArrayList<String> sendFriendRequest(User sender, User receiver) {
        receiver.getRequests().add(sender.getUsername());
        return receiver.getRequests();
    }

    public HashMap<String, Double> getScores(User currentUser, MatchingStrategy matchingStrategy) {
        HashMap<String, Double> scores = new HashMap<>();

        Playlist currentPlaylist = currentUser.getPlaylist();

        for (User user : accounts.values()) {
            // Execute if the current user is not already friends with the user being checked
            // and if the current user is not the user being checked
            if (currentUser.getFriends() != null & !currentUser.getFriends().contains(user.getUsername()) & !currentUser.equals(user)) {
                // Retrieve the playlist to check
                Playlist playlistToCheck = user.getPlaylist();
                Double similarityScore = matchingStrategy.getSimilarityScore(currentPlaylist, playlistToCheck);
                scores.put(user.getUsername(), similarityScore);
            }
        }
        return scores;
    }

    public void editPlaylist(String username, Playlist playlist) {
        // Update the usernamePlaylist map to the new playlist
        usernamePlaylist.put(username, playlist);
        ArrayList<String> topThreeArtists = playlist.getTopThreeArtists();
        String artists = topThreeArtists.toString();
        String playlistId = playlist.getPlaylistId();

        // Update the users csv file
        editFile(username,"artists", artists);
        editFile(username,"playlistId", playlistId);
    }

    public void editFile(String username, String column, String newValue) {
        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
            // Read all lines into memory
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split("\\|");

                if (userInfo[headers.get("username")].equals(username)) {
                    // get the column we want to edit the info
                    int columnIndex = headers.get(column);
                    userInfo[columnIndex] = newValue;
                }

                content.append(String.join("|", userInfo)).append(System.lineSeparator());
            }

            // Write the modified content back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile))) {
                writer.write(content.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}