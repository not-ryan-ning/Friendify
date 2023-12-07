package interface_adapter.go_back;

import org.junit.Before;
import org.junit.Test;
import use_case.go_back.GoBackInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GoBackControllerTest {
    private GoBackInputBoundary mockGoBackInteractor;

    @Before
    public void init() {
        this.mockGoBackInteractor = new MockGoBackInteractor();
    }

    @Test
    public void testInitialization() {
        GoBackController controller = new GoBackController(mockGoBackInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        GoBackController controller = new GoBackController(mockGoBackInteractor);

        controller.execute();

        assertEquals("Success", ((MockGoBackInteractor) mockGoBackInteractor).getState());
    }
}