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

                    // column format: playlistId, titles, artists, genres, acousticness, energy, instrumentalness, valence, topThreeArtists

                    // Convert CSV string to Arraylist<String> for titles and topThreeArtists
                    String[] titlesSplit = titles.split(",");
                    ArrayList<String> titlesArrayList = new ArrayList<String>(Arrays.asList(titlesSplit));

                    String[] topTreeArtistsSplit = topThreeArtists.split(",");
                    ArrayList<String> topThreeArtistsArrayList = new ArrayList<String>(Arrays.asList(topTreeArtistsSplit));

                    // Convert CSV string to HashMap<String, Integer> for artists and genres
                    HashMap<String, Integer> artistsMap = new HashMap<>();
                    artistsMap.put("defaultArtists", 0);

                    if (!artists.isEmpty()) {
                        artistsMap = Arrays.stream(artists.split("\n"))
                                .map(entry -> entry.split(","))
                                .filter(parts -> parts.length == 2)  // Filter out entries without expected length
                                .collect(Collectors.toMap(
                                        parts -> parts[0],
                                        parts -> {
                                            try {
                                                return Integer.parseInt(parts[1]);
                                            } catch (NumberFormatException e) {
                                                // Handle non-numeric case, e.g., set a default value
                                                return 0;
                                            }
                                        },
                                        (existing, replacement) -> existing,
                                        HashMap::new
                                ));
                    }

                    HashMap<String, Integer> genresMap = new HashMap<>();
                    genresMap.put("defaultGenre", 0);
                    if (!genres.isEmpty()) {
                        genresMap = Arrays.stream(genres.split("\n"))
                                .map(entry -> entry.split(","))
                                .filter(parts -> parts.length == 2)  // Filter out entries without expected length
                                .collect(Collectors.toMap(
                                        parts -> parts[0],
                                        parts -> {
                                            try {
                                                return Integer.parseInt(parts[1]);
                                            } catch (NumberFormatException e) {
                                                // Handle non-numeric case, e.g., set a default value
                                                return 0;
                                            }
                                        },
                                        (existing, replacement) -> existing,
                                        HashMap::new
                                ));
                    }

                    Playlist playlist = playlistFactory.create(playlistId, titlesArrayList, artistsMap, genresMap,
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
                        playlist.getPlaylistId(), playlist.getTitles(), playlist.getArtists(), playlist.getGenres(),
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
