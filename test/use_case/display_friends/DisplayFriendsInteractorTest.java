package use_case.display_friends;

import data_access.display_friends.MockDisplayFriendsUserDataAccessObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DisplayFriendsInteractorTest {
    private DisplayFriendsUserDataAccessInterface mockDisplayFriendsUserDAO;
    private DisplayFriendsOutputBoundary mockDisplayFriendsPresenter;

    @Before
    public void init() {
        this.mockDisplayFriendsUserDAO = new MockDisplayFriendsUserDataAccessObject();
        this.mockDisplayFriendsPresenter = new MockDisplayFriendsPresenter();
    }

    @Test
    public void testInitialization() {
        DisplayFriendsInteractor interactor = new DisplayFriendsInteractor(mockDisplayFriendsUserDAO,
                mockDisplayFriendsPresenter);

        assertNotNull(interactor);
    }
    @Test
    public void testExecuteSuccess() {
        DisplayFriendsInteractor interactor = new DisplayFriendsInteractor(mockDisplayFriendsUserDAO,
                mockDisplayFriendsPresenter);

        interactor.execute("");

        assertEquals("Success", ((MockDisplayFriendsPresenter) mockDisplayFriendsPresenter).getState());
    }
}
