package use_case.accept_request;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AcceptRequestOutputDataTest {

    private AcceptRequestOutputData outputData;

    @Before
    public void init() {
        ArrayList<String> requests = new ArrayList<>();
        requests.add("NormalPersonName");
        this.outputData = new AcceptRequestOutputData(requests, "user");
    }

    @Test
    public void testGetFriends() {
        ArrayList<String> requests = new ArrayList<>();
        requests.add("NormalPersonName");
        assertEquals(requests, outputData.getRequests());
    }

    @Test
    public void testGetAcceptedUsername() {
        assertEquals("user", outputData.getAcceptedUsername());
    }
}
