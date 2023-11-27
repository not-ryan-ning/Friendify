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

    @Override
    public void execute(String username, ChoosePlaylistInputData choosePlaylistInputData) {
        String playlistId = choosePlaylistInputData.getPlaylistId();
        String playlistName = choosePlaylistInputData.getPlaylistName();
        String accessToken = choosePlaylistInputData.getAccessToken();

        ArrayList<Object> playlistInfo = spotifyDataAccessObject.getPlaylistInfo(username, playlistId, accessToken);
        ArrayList<String> titles = (ArrayList<String>) playlistInfo.get(0);
        HashMap<String, Integer> artists = (HashMap<String, Integer>) playlistInfo.get(1);
        HashMap<String, Integer> genres = (HashMap<String, Integer>) playlistInfo.get(2);
        double acousticness = (double) playlistInfo.get(3);
        double energy = (double) playlistInfo.get(4);
        double instrumentalness = (double) playlistInfo.get(5);
        double valence = (double) playlistInfo.get(6);
        ArrayList<String> topTreeArtists = (ArrayList<String>) playlistInfo.get(7);

        Playlist playlist = playlistFactory.create(playlistId, titles, artists, genres, acousticness,
                energy, instrumentalness, valence, topTreeArtists);

        User user = userDataAccessObject.getUser(username);
        userDataAccessObject.editPlaylist(user.getUsername(), playlist);
        playlistDataAccessObject.storePlaylist(playlist);

        ChoosePlaylistOutputData choosePlaylistOutputData = new ChoosePlaylistOutputData(playlistName);
        choosePlaylistPresenter.prepareSuccessView(choosePlaylistOutputData);
    }
}
