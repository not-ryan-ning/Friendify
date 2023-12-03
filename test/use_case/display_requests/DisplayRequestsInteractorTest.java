package use_case.display_requests;

import data_access.FileUserDataAccessObject;
import entity.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.display_friends.DisplayFriendsPresenter;
import interface_adapter.display_friends.DisplayFriendsViewModel;
import interface_adapter.display_requests.DisplayRequestsPresenter;
import interface_adapter.display_requests.DisplayRequestsState;
import interface_adapter.display_requests.DisplayRequestsViewModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.display_friends.DisplayFriendsOutputBoundary;
import use_case.edit_spotify_handle.EditSpotifyHandleUserDataAccessInterface;
import use_case.send_request.SendRequestInputData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

public class DisplayRequestsInteractorTest {
    private DisplayRequestsInteractor displayRequestsInteractor;
    private ViewManagerModel viewManagerModel;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        UserFactory uf = new CommonUserFactory();
        ProfileFactory pf = new CommonProfileFactory();
        DisplayRequestsUserDataAccessInterface user = new FileUserDataAccessObject("./users", uf, pf);
        displayRequestsInteractor = new DisplayRequestsInteractor(user, new DisplayRequestsPresenter(viewManagerModel, new DisplayRequestsViewModel()));
    }

    @Test
    public void testExecute() {
        displayRequestsInteractor.execute("user1");
        assertEquals("show requests", viewManagerModel.getActiveView());
    }

}