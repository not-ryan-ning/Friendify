package interface_adapter.authorize;

import org.junit.Before;
import org.junit.Test;
import use_case.authorize.AuthorizeInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AuthorizeControllerTest {
    private AuthorizeInputBoundary mockAuthorizeInteractor;

    @Before
    public void init() {
        this.mockAuthorizeInteractor = new MockAuthorizeInteractor();
    }

    @Test
    public void testInitialization() {
        AuthorizeController controller = new AuthorizeController(mockAuthorizeInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        AuthorizeController controller = new AuthorizeController(mockAuthorizeInteractor);

        controller.execute("");

        assertEquals("Success", ((MockAuthorizeInteractor) mockAuthorizeInteractor).getState());
    }
}
