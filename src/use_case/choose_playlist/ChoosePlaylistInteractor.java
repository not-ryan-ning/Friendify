package use_case.choose_playlist;

import entity.Playlist;
import entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public class ChoosePlaylistInteractor implements ChoosePlaylistInputBoundary {
    final ChoosePlaylistUserDataAccessInterface userDataAccessObject;
    final ChoosePlaylistPlaylistDataAccessInterface playlistDataAccessObject;
    final ChoosePlaylistSpotifyAPIDataAccessInterface spotifyDataAccessObject;
    final ChoosePlaylistOutputBoundary choosePlaylistPresenter;

    public ChoosePlaylistInteractor(ChoosePlaylistUserDataAccessInterface choosePlaylistUserDataAccessInterface,
                                    ChoosePlaylistPlaylistDataAccessInterface choosePlaylistPlaylistDataAccessInterface,
                                    ChoosePlaylistSpotifyAPIDataAccessInterface choosePlaylistSpotifyAPIDataAccessInterface,
                                    ChoosePlaylistOutputBoundary choosePlaylistOutputBoundary) {
        this.userDataAccessObject = choosePlaylistUserDataAccessInterface;
        this.playlistDataAccessObject = choosePlaylistPlaylistDataAccessInterface;
        this.spotifyDataAccessObject = choosePlaylistSpotifyAPIDataAccessInterface;
        this.choosePlaylistPresenter = choosePlaylistOutputBoundary;
    }

    @Override
    public void execute(ChoosePlaylistInputData choosePlaylistInputData) {
        String username = choosePlaylistInputData.getUsername();
        String playlistId = choosePlaylistInputData.getPlaylistId();
        String accessToken = choosePlaylistInputData.getAccessToken();

        ArrayList<Object> playlistInfo = spotifyDataAccessObject.getPlaylistInfo(username, playlistId, accessToken);
        HashMap<String, Integer> titles = (HashMap<String, Integer>) playlistInfo.get(0);
        HashMap<String, Integer> artists = (HashMap<String, Integer>) playlistInfo.get(1);
        HashMap<String, Integer> genres = (HashMap<String, Integer>) playlistInfo.get(2);
        double acousticness = (double) playlistInfo.get(3);
        double energy = (double) playlistInfo.get(4);
        double instrumentalness = (double) playlistInfo.get(5);
        double valence = (double) playlistInfo.get(6);

        userDataAccessObject.editPlaylist(username, playlistId, artists); // this one also changes top three artists data
        playlistDataAccessObject.addPlaylist(playlistId, titles, artists, genres, acousticness, energy, instrumentalness, valence);
        String playlistName = playlistDataAccessObject.gerPlaylistName(playlistId);

        ChoosePlaylistOutputData choosePlaylistOutputData = new ChoosePlaylistOutputData(playlistName);
        choosePlaylistPresenter.prepareSuccessView(choosePlaylistOutputData);
    }

}
