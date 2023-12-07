package interface_adapter.display_profile;

import org.junit.Before;
import org.junit.Test;
import use_case.display_profile.DisplayProfileInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DisplayProfileControllerTest {
    private DisplayProfileInputBoundary mockDisplayProfileInteractor;

    @Before
    public void init() {
        this.mockDisplayProfileInteractor = new MockDisplayProfileInteractor();
    }

    @Test
    public void testInitialization() {
        DisplayProfileController controller = new DisplayProfileController(mockDisplayProfileInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        DisplayProfileController controller = new DisplayProfileController(mockDisplayProfileInteractor);
        controller.execute("", "");

        assertEquals("Success", ((MockDisplayProfileInteractor) mockDisplayProfileInteractor).getState());
    }
}