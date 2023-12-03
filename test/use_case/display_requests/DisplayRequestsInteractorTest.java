package use_case.display_requests;

import data_access.FileUserDataAccessObject;
import entity.CommonPlaylist;
import entity.CommonProfile;
import entity.CommonUser;
import entity.User;
import interface_adapter.display_requests.DisplayRequestsState;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

public class DisplayRequestsInteractorTest {

    private DisplayRequestsUserDataAccessInterface displayRequestsUserDataAccessInterface;
    private DisplayRequestsInteractor displayRequestsInteractor;

    /**
     * Testing that DisplayRequestsInteractor correctly
     */
    @Test
    public void testExecute() {
        User user = new CommonUser("user1", "password1", new CommonProfile("Hi", new ArrayList<>(),
                "handle1"), new CommonPlaylist("", new ArrayList<>(), new HashMap<>(), new HashMap<>(),
                0, 0,0,0, new ArrayList<>()), new ArrayList<>(Arrays.asList("user2")), new ArrayList<>());

        DisplayRequestsState state = new DisplayRequestsState();
        state.setRequests(new ArrayList<>(Arrays.asList("user1", "user2")));

        displayRequestsInteractor.execute(user.getUsername());

        assertEquals(user.getRequests(), new ArrayList<>(Arrays.asList("user1", "user2")));
    }

}