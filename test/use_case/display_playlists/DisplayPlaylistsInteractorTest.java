package use_case.display_playlists;

import interface_adapter.ViewManagerModel;
import org.junit.Test;
import use_case.display_friends.DisplayFriendsInteractor;

import static org.junit.Assert.*;

public class DisplayPlaylistsInteractorTest {
    private DisplayPlaylistsInteractor displayPlaylistsInteractor;
    private ViewManagerModel viewManagerModel;
    @Test
    public void testExecute() {
        displayPlaylistsInteractor.execute(new DisplayPlaylistsInputData("token"));
        assertEquals("DisplayPlaylists", viewManagerModel.getActiveView());
    }

}