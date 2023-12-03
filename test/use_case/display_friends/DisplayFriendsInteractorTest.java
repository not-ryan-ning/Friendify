package use_case.display_friends;

import data_access.FileUserDataAccessObject;
import entity.CommonProfileFactory;
import entity.CommonUserFactory;
import entity.ProfileFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.display_friends.DisplayFriendsPresenter;
import interface_adapter.display_friends.DisplayFriendsViewModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.display_requests.DisplayRequestsInteractor;
import use_case.edit_profile.EditProfileInteractor;
import use_case.login.LoginUserDataAccessInterface;

import java.io.IOException;

import static org.junit.Assert.*;

public class DisplayFriendsInteractorTest {
    private DisplayFriendsInteractor displayFriendsInteractor;
    private ViewManagerModel viewManagerModel;
    @BeforeEach
    public void setUp() throws IOException {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        UserFactory uf = new CommonUserFactory();
        ProfileFactory pf = new CommonProfileFactory();
        DisplayFriendsUserDataAccessInterface user = new FileUserDataAccessObject("./users", uf, pf);
        displayFriendsInteractor = new DisplayFriendsInteractor(user, new DisplayFriendsPresenter(viewManagerModel, new DisplayFriendsViewModel()));
    }
    @Test
    public void testExecute() {
        displayFriendsInteractor.execute("user");
        assertEquals("DisplayFriends", viewManagerModel.getActiveView());
    }

}