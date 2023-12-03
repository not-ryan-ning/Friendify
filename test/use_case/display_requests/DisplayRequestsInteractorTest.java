package use_case.display_requests;

import data_access.FileUserDataAccessObject;
import entity.CommonPlaylist;
import entity.CommonProfile;
import entity.CommonUser;
import entity.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.display_friends.DisplayFriendsPresenter;
import interface_adapter.display_requests.DisplayRequestsState;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.display_friends.DisplayFriendsOutputBoundary;
import use_case.send_request.SendRequestInputData;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

public class DisplayRequestsInteractorTest {
    private DisplayRequestsInteractor displayRequestsInteractor;
    private ViewManagerModel viewManagerModel;

    @BeforeEach
    public void setUp() {
        // Initialize the objects before each test
        displayRequestsInteractor = new DisplayRequestsInteractor(new DisplayRequestsUserDataAccessInterface(), new DisplayFriendsPresenter())
        viewManagerModel = new ViewManagerModel();
    }

    @Test
    public void testExecute() {
        displayRequestsInteractor.execute("user1");
        assertEquals("show requests", viewManagerModel.getActiveView());
    }

}