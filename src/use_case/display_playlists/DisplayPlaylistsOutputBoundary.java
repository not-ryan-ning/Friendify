package use_case.display_playlists;

public interface DisplayPlaylistsOutputBoundary {
    void prepareSuccessView(DisplayPlaylistsOutputData playlistIdName);
    void prepareFailView(String failMessage);
}
