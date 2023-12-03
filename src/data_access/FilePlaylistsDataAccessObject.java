package data_access;

import entity.Playlist;
import entity.PlaylistFactory;
import entity.User;
import use_case.choose_playlist.ChoosePlaylistPlaylistDataAccessInterface;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FilePlaylistsDataAccessObject implements ChoosePlaylistPlaylistDataAccessInterface {
    private final File playlistsFile;

    // Contains the content in each column
    private final Map<String, Integer> headers = new LinkedHashMap<>();

    // Maps playlistId to the Playlist object
    private final Map<String, Playlist> playlists = new HashMap<>();

    private PlaylistFactory playlistFactory;

    public FilePlaylistsDataAccessObject(String csvPath, PlaylistFactory playlistFactory) throws IOException {
        this.playlistFactory = playlistFactory;
        this.playlistsFile = new File(csvPath);
        headers.put("playlistId", 0);
        headers.put("titles", 1);
        headers.put("artists", 2);
        headers.put("genres", 3);
        headers.put("acousticness", 4);
        headers.put("energy", 5);
        headers.put("instrumentalness", 6);
        headers.put("valence", 7);
        headers.put("topThreeArtists", 8);

        if (this.playlistsFile.length() == 0) {
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(playlistsFile))) {
                String header = reader.readLine();

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split("\\|");
                    String playlistId = String.valueOf(col[headers.get("playlistId")]);
                    String titles = String.valueOf(col[headers.get("titles")]);
                    String artists = String.valueOf(col[headers.get("artists")]);
                    String genres = String.valueOf(col[headers.get("genres")]);
                    String acousticness = String.valueOf(col[headers.get("acousticness")]);
                    String energy = String.valueOf(col[headers.get("energy")]);
                    String instrumentalness = String.valueOf(col[headers.get("instrumentalness")]);
                    String valence = String.valueOf(col[headers.get("valence")]);
                    String topThreeArtists = String.valueOf(col[headers.get("topThreeArtists")]);

                    // Convert CSV string to Arraylist<String> for titles and topThreeArtists
                    String[] titlesSplit = titles.substring(1, titles.length() - 1).split(", ");
                    ArrayList<String> titlesArrayList = new ArrayList<>(Arrays.asList(titlesSplit));

                    String[] topThreeArtistsSplit = topThreeArtists.substring(1, topThreeArtists.length() - 1).split(", ");
                    ArrayList<String> topThreeArtistsArrayList = new ArrayList<>(Arrays.asList(topThreeArtistsSplit));

                    // Convert CSV string to HashMap<String, Integer> for artists and genres

                    // Remove curly braces and spaces
                    String cleanedArtistsInput = artists.replaceAll("[{}\\s]", "");
                    String cleanedGenresInput = genres.replaceAll("[{}\\s]", "");

                    // Split into key-value pairs
                    String[] artistsKeyValuePairs = cleanedArtistsInput.split(",");
                    String[] genresKeyValuePairs = cleanedGenresInput.split(",");

                    // Split each key-value pair and populate the HashMap
                    HashMap<String, Integer> artistsHashMap = new HashMap<>();
                    for (String pair : artistsKeyValuePairs) {
                        String[] entry = pair.split("=");

                        if (entry.length == 2) {
                            String key = entry[0];
                            try {
                                int value = Integer.parseInt(entry[1]);
                                artistsHashMap.put(key, value);
                            } catch (NumberFormatException e) {
                                System.err.println("Invalid value for key '" + key + "': " + entry[1]);
                                // Handle non-numeric case, e.g., set a default value
                                artistsHashMap.put(key, 0);
                            }
                        }
                    }

                    HashMap<String, Integer> genresHashMap = new HashMap<>();
                    for (String pair : genresKeyValuePairs) {
                        String[] entry = pair.split("=");

                        if (entry.length == 2) {
                            String key = entry[0];
                            try {
                                int value = Integer.parseInt(entry[1]);
                                genresHashMap.put(key, value);
                            } catch (NumberFormatException e) {
                                System.err.println("Invalid value for key '" + key + "': " + entry[1]);
                                // Handle non-numeric case, e.g., set a default value
                                genresHashMap.put(key, 0);
                            }
                        }
                    }

                    Playlist playlist = playlistFactory.create(playlistId, titlesArrayList, artistsHashMap, genresHashMap,
                            Double.parseDouble(acousticness), Double.parseDouble(energy), Double.parseDouble(instrumentalness),
                            Double.parseDouble(valence), topThreeArtistsArrayList);

                    playlists.put(playlistId, playlist);
                }
            }
        }
    }

    @Override
    public void storePlaylist(Playlist playlist) {
        playlists.put(playlist.getPlaylistId(), playlist);
        this.save();
    }
    @Override
    public boolean isIn(String playlistId) { return playlists.containsKey(playlistId); }
    @Override
    public Playlist getPlaylist(String playlistId) {
        return playlists.get(playlistId);
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(playlistsFile));
            writer.write(String.join("|", headers.keySet()));
            writer.newLine();

            for (Playlist playlist : playlists.values()) {
                String line = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s",
                        playlist.getPlaylistId(), playlist.getTitles(), playlist.getArtists().toString(), playlist.getGenres().toString(),
                        playlist.getAcousticness(), playlist.getEnergy(),
                        playlist.getInstrumentalness(), playlist.getValence(), playlist.getTopThreeArtists());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}