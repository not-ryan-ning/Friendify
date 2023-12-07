package use_case.edit_spotify_handle;

public class MockEditSpotifyHandlePresenter implements EditSpotifyHandleOutputBoundary {

    private String currentState;

    public MockEditSpotifyHandlePresenter() {
        this.currentState = "";
    }
    @Override
    public void prepareSuccessView(EditSpotifyHandleOutputData updatedSpotifyHandle) {
        this.currentState = "Success";
    }

    public String getState() {
        return currentState;
    }
}
