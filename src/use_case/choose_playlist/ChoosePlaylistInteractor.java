package use_case.choose_playlist;

import entity.Playlist;
import entity.PlaylistFactory;
import entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public class ChoosePlaylistInteractor implements ChoosePlaylistInputBoundary {
    final ChoosePlaylistUserDataAccessInterface userDataAccessObject;
    final ChoosePlaylistPlaylistDataAccessInterface playlistDataAccessObject;
    final ChoosePlaylistSpotifyAPIDataAccessInterface spotifyDataAccessObject;
    final ChoosePlaylistOutputBoundary choosePlaylistPresenter;
    final PlaylistFactory playlistFactory;

    public ChoosePlaylistInteractor(ChoosePlaylistUserDataAccessInterface choosePlaylistUserDataAccessInterface,
                                    ChoosePlaylistPlaylistDataAccessInterface choosePlaylistPlaylistDataAccessInterface,
                                    ChoosePlaylistSpotifyAPIDataAccessInterface choosePlaylistSpotifyAPIDataAccessInterface,
                                    ChoosePlaylistOutputBoundary choosePlaylistOutputBoundary,
                                    PlaylistFactory playlistFactory) {
        this.userDataAccessObject = choosePlaylistUserDataAccessInterface;
        this.playlistDataAccessObject = choosePlaylistPlaylistDataAccessInterface;
        this.spotifyDataAccessObject = choosePlaylistSpotifyAPIDataAccessInterface;
        this.choosePlaylistPresenter = choosePlaylistOutputBoundary;
        this.playlistFactory = playlistFactory;
    }

    /**
     * Executes the function of choosing a playlist, updating user and playlist information based on
     * the provided input data. This method is responsible for retrieving playlist information from
     * the Spotify data access object, creating a Playlist object, associating it with the user, and
     *s toring it in the data access objects.
     * @param username This is the username of the user choosing the playlist
     * @param choosePlaylistInputData Input data containing details about the playlist
     */
    @Override
    public void execute(String username, ChoosePlaylistInputData choosePlaylistInputData) {
        String playlistId = choosePlaylistInputData.getPlaylistId();
        String playlistName = choosePlaylistInputData.getPlaylistName();
        String accessToken = choosePlaylistInputData.getAccessToken();

        User user = userDataAccessObject.get(username);
        Playlist playlist;

        if (!playlistDataAccessObject.isIn(playlistId)) {
            ArrayList<Object> playlistInfo = spotifyDataAccessObject.getPlaylistInfo(username, playlistId, accessToken);
            ArrayList<String> titles = (ArrayList<String>) playlistInfo.get(0);
            HashMap<String, Integer> artists = (HashMap<String, Integer>) playlistInfo.get(1);
            HashMap<String, Integer> genres = (HashMap<String, Integer>) playlistInfo.get(2);
            double acousticness = (double) playlistInfo.get(3);
            double energy = (double) playlistInfo.get(4);
            double instrumentalness = (double) playlistInfo.get(5);
            double valence = (double) playlistInfo.get(6);
            ArrayList<String> topTreeArtists = (ArrayList<String>) playlistInfo.get(7);

            playlist = playlistFactory.create(playlistId, titles, artists, genres, acousticness,
                    energy, instrumentalness, valence, topTreeArtists);

            playlistDataAccessObject.storePlaylist(playlist);
        } else {
            playlist = playlistDataAccessObject.getPlaylist(playlistId);
        }

        user.setPlaylist(playlist);
        user.getProfile().setTopThreeArtists(playlist.getTopThreeArtists());
        userDataAccessObject.editPlaylist(user.getUsername(), playlist);

        ChoosePlaylistOutputData choosePlaylistOutputData = new ChoosePlaylistOutputData(playlistName, playlist.getTopThreeArtists());
        choosePlaylistPresenter.prepareSuccessView(choosePlaylistOutputData);
    }
}
