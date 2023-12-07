package use_case.display_friends;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DisplayFriendsOutputDataTest {
    private DisplayFriendsOutputData outputData;

    @Before
    public void init() {
        this.outputData = new DisplayFriendsOutputData(new ArrayList<>(List.of("friend1")));
    }

    @Test
    public void testGetFriendNames() {
        assertEquals(new ArrayList<>(List.of("friend1")), outputData.getFriendNames());
    }
}
