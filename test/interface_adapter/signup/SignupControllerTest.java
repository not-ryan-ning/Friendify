package interface_adapter.signup;

import org.junit.Before;
import org.junit.Test;
import use_case.signup.SignupInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SignupControllerTest {
    private SignupInputBoundary mockSignupInteractor;

    @Before
    public void init() {
        this.mockSignupInteractor = new MockSignupInteractor();
    }

    @Test
    public void testInitialization() {
        SignupController controller = new SignupController(mockSignupInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        SignupController controller = new SignupController(mockSignupInteractor);

        controller.execute("","", "");

        assertEquals("Success", ((MockSignupInteractor) mockSignupInteractor).getState());
    }
}