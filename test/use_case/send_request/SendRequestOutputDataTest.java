package use_case.send_request;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SendRequestOutputDataTest {

    private SendRequestOutputData outputData;

    @Before
    public void init() {
        this.outputData = new SendRequestOutputData("user", false);
    }

    @Test
    public void testGetReceiverUsername() {
        assertEquals("user", outputData.getReceiverUsername());
    }


}
