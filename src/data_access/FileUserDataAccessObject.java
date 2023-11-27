package data_access;

import entity.*;

import java.io.*;
import java.util.*;

public class FileUserDataAccessObject {
    private final File usersFile;

    // Contains the content in each column
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    // Maps username to User
    private final Map<String, User> accounts = new HashMap<>();

    // Maps username to Playlist
    private final Map<String, Playlist> usernamePlaylist = new HashMap<>();

    private UserFactory userFactory;
    private MatchingStrategy matchingStrategy;

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory, MatchingStrategy matchingStrategy) throws IOException {
        this.userFactory = userFactory;
        this.matchingStrategy = matchingStrategy;
        this.usersFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("bio", 2);
        headers.put("artists", 3);
        headers.put("spotify_handle", 4);
        headers.put("playlistId", 5);
        headers.put("friends", 6);
        headers.put("requests", 7);

        if (this.usersFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split("\\|");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String bio = String.valueOf(col[headers.get("bio")]);
                    String artists = String.valueOf(col[headers.get("artists")]);
                    String spotifyHandle = String.valueOf(col[headers.get("spotify_handle")]);
                    String playlistId = String.valueOf(col[headers.get("playlistId")]);
                    String friends = String.valueOf(col[headers.get("friends")]);
                    String requests = String.valueOf(col[headers.get("requests")]);

                    // column format: username, password, bio, artists, spotifyHandle, playlistId, friends, requests
                    String[] artistsSplit = artists.split(",");
                    ArrayList<String> topThreeArtists = new ArrayList<String>(Arrays.asList(artistsSplit));

                    String[] friendsSplit = friends.split(",");
                    ArrayList<String> friendsArrayList = new ArrayList<String>(Arrays.asList(friendsSplit));

                    String[] requestsSplit = requests.split(",");
                    ArrayList<String> requestsArrayList = new ArrayList<String>(Arrays.asList(requestsSplit));

                    Profile profile = ProfileFactory.create(bio, topThreeArtists, spotifyHandle);
                    Playlist playlist = FilePlaylistsDataAccessObject.getPlaylist(playlistId);

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
            writer.write(String.join("\\|", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                        user.getUsername(), user.getPassword(), user.getProfile().getBio(),
                        user.getProfile().getTopThreeArtists(), user.getProfile().getSpotifyHandle(),
                        user.getPlaylist().getPlaylistId(), user.getFriends(), user.getRequests());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public void sendFriendRequest(User sender, User receiver) {
        //if (receiver.getRequests().contains(sender.getUsername())) {
        //    throw new IllegalStateException("You have already sent a request to this user.");
        // }
        receiver.getRequests().add(sender.getUsername());
    }

    public void setMatchingStrategy(MatchingStrategy matchingStrategy) {
        this.matchingStrategy = matchingStrategy;
    }

    HashMap<String, Double> getMatches(User currentUser) {
        HashMap<String, Double> matches = new HashMap<>();

        for (User user : accounts.values()) {
            if (!currentUser.getFriends().contains(user.getUsername())) {
                Playlist playlistToCheck = user.getPlaylist();
                Double similarityScore = matchingStrategy.getSimilarityScore(user.getPlaylist(), playlistToCheck);
                if (similarityScore >= 0.5) {
                    matches.put(user.getUsername(), similarityScore);
                }
            }
        }
        return matches;
    }

    public void editPlaylist(String username, Playlist playlist) {
        // Update the usernamePlaylist map to the new playlist
        usernamePlaylist.put(username, playlist);
        ArrayList<String> topThreeArtists = playlist.getTopThreeArtists();
        String artists = ""; // need to convert the arrayList into a String
        String playlistId = playlist.getPlaylistId();

        // Update the users csv file
        editFile(username,"artists", artists);
        editFile(username,"playlistId", playlistId);
    }

    private void editFile(String username, String column, String newValue) {

        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split(",");

                if (userInfo[headers.get("username")].equals(username)) {
                    // get the column we want to edit the info
                    int columnIndex = headers.get(column);
                    userInfo[columnIndex] = newValue;
                }

                writer.write(String.join(",", userInfo));
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}