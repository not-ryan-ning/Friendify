package use_case.display_friends;

import interface_adapter.ViewManagerModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.display_requests.DisplayRequestsInteractor;
import use_case.edit_profile.EditProfileInteractor;

import static org.junit.Assert.*;

public class DisplayFriendsInteractorTest {
    private DisplayFriendsInteractor displayFriendsInteractor;
    private ViewManagerModel viewManagerModel;
    @BeforeEach
    public void setUp() {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        displayFriendsInteractor = ...
    }
    @Test
    public void testExecute() {
        displayFriendsInteractor.execute("user");
        assertEquals("DisplayFriends", viewManagerModel.getActiveView());
    }

}