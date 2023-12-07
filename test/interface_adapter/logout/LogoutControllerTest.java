package interface_adapter.logout;

import org.junit.Before;
import org.junit.Test;
import use_case.logout.LogoutInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LogoutControllerTest {
    private LogoutInputBoundary mockLogoutInteractor;

    @Before
    public void init() {
        this.mockLogoutInteractor = new MockLogoutInteractor();
    }

    @Test
    public void testInitialization() {
        LogoutController controller = new LogoutController(mockLogoutInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        LogoutController controller = new LogoutController(mockLogoutInteractor);

        controller.execute();

        assertEquals("Success", ((MockLogoutInteractor) mockLogoutInteractor).getState());
    }
}