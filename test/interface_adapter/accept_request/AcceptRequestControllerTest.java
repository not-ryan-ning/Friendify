package interface_adapter.accept_request;

import org.junit.Before;
import org.junit.Test;
import use_case.accept_request.AcceptRequestInputData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AcceptRequestControllerTest {

    private MockAcceptRequestInteractor mockAcceptRequestInteractor;

    @Before
    public void init() {
        this.mockAcceptRequestInteractor = new MockAcceptRequestInteractor();
    }

    @Test
    public void testInitialization() {
        AcceptRequestController controller = new AcceptRequestController(mockAcceptRequestInteractor);
        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        AcceptRequestController controller = new AcceptRequestController(mockAcceptRequestInteractor);
        AcceptRequestInputData inputData = new MockAcceptRequestInputData("");

        controller.execute("", "");
        assertEquals("success", ((MockAcceptRequestInteractor) mockAcceptRequestInteractor).getState());
    }
}
