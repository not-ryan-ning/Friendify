package interface_adapter.display_requests;

import org.junit.Before;
import org.junit.Test;
import use_case.display_requests.DisplayRequestsInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DisplayRequestsControllerTest {
    private DisplayRequestsInputBoundary mockDisplayRequestsInteractor;

    @Before
    public void init() {
        this.mockDisplayRequestsInteractor = new MockDisplayRequestsInteractor();
    }

    @Test
    public void testInitialization() {
        DisplayRequestsController controller = new DisplayRequestsController(mockDisplayRequestsInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        DisplayRequestsController controller = new DisplayRequestsController(mockDisplayRequestsInteractor);

        controller.execute("");

        assertEquals("Success", ((MockDisplayRequestsInteractor) mockDisplayRequestsInteractor).getState());
    }
}