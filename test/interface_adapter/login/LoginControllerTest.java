package interface_adapter.login;

import org.junit.Before;
import org.junit.Test;
import use_case.login.LoginInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LoginControllerTest {
    private LoginInputBoundary mockLoginInteractor;

    @Before
    public void init() {
        this.mockLoginInteractor = new MockLoginInteractor();
    }

    @Test
    public void testInitialization() {
        LoginController controller = new LoginController(mockLoginInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        LoginController controller = new LoginController(mockLoginInteractor);

        controller.execute("", "");

        assertEquals("Success", ((MockLoginInteractor) mockLoginInteractor).getState());
    }
}