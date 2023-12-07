package use_case.display_requests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DisplayRequestInputDataTest {
    private DisplayRequestsInputData inputData;

    @Before
    public void init() {
        this.inputData = new DisplayRequestsInputData("name");
    }

    @Test
    public void testGetUsername() {
        assertEquals("name", inputData.getUsername());
    }

}
