package use_case.display_friends;

import interface_adapter.ViewManagerModel;
import org.junit.Test;
import use_case.edit_profile.EditProfileInteractor;

import static org.junit.Assert.*;

public class DisplayFriendsInteractorTest {
    private DisplayFriendsInteractor displayFriendsInteractor;
    private ViewManagerModel viewManagerModel;
    @Test
    public void testExecute() {
        displayFriendsInteractor.execute("user");
        assertEquals("DisplayFriends", viewManagerModel.getActiveView());
    }

}