package interface_adapter.match;

import org.junit.Before;
import org.junit.Test;
import use_case.match.MatchInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MatchControllerTest {
    private MatchInputBoundary mockMatchInteractor;

    @Before
    public void init() {
        this.mockMatchInteractor = new MockMatchInteractor();
    }

    @Test
    public void testInitialization() {
        MatchController controller = new MatchController(mockMatchInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        MatchController controller = new MatchController(mockMatchInteractor);

        controller.execute("");

        assertEquals("Success", ((MockMatchInteractor) mockMatchInteractor).getState());
    }
}