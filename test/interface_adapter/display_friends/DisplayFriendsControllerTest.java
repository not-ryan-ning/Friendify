package interface_adapter.display_friends;

import org.junit.Before;
import org.junit.Test;
import use_case.display_friends.DisplayFriendsInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DisplayFriendsControllerTest {
    private DisplayFriendsInputBoundary mockDisplayFriendsInteractor;

    @Before
    public void init() {
        this.mockDisplayFriendsInteractor = new MockDisplayFriendsInteractor();
    }

    @Test
    public void testInitialization() {
        DisplayFriendsController controller = new DisplayFriendsController(mockDisplayFriendsInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        DisplayFriendsController controller = new DisplayFriendsController(mockDisplayFriendsInteractor);

        controller.execute("");

        assertEquals("Success", ((MockDisplayFriendsInteractor) mockDisplayFriendsInteractor).getState());
    }
}