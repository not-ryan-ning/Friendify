package use_case.display_requests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DisplayRequestOutputDataTest {
    private DisplayRequestsOutputData outputData;

    @Before
    public void init() {
        this.outputData = new DisplayRequestsOutputData(new ArrayList<>(List.of("request")));
    }

    @Test
    public void testGetRequests() {
        assertEquals(new ArrayList<>(List.of("request")), outputData.getRequests());
    }
}
