package interface_adapter.send_request;

import org.junit.Before;
import org.junit.Test;
import use_case.send_request.SendRequestInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SendRequestControllerTest {
    private SendRequestInputBoundary mockSendRequestInteractor;

    @Before
    public void init() {
        this.mockSendRequestInteractor = new MockSendRequestInteractor();
    }

    @Test
    public void testInitialization() {
        SendRequestController controller = new SendRequestController(mockSendRequestInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        SendRequestController controller = new SendRequestController(mockSendRequestInteractor);

        controller.execute("", "");

        assertEquals("Success", ((MockSendRequestInteractor) mockSendRequestInteractor).getState());
    }
}