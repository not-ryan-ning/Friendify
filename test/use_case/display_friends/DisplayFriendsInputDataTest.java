package use_case.display_friends;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DisplayFriendsInputDataTest {
    private DisplayFriendsInputData inputData;

    @Before
    public void init() {
        this.inputData = new DisplayFriendsInputData();
    }

    @Test
    public void testInitialization() {
        assertNotNull(inputData);
    }



}
