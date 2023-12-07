package interface_adapter.edit_bio;

import org.junit.Before;
import org.junit.Test;
import use_case.edit_bio.EditBioInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EditBioControllerTest {
    private EditBioInputBoundary mockEditBioInteractor;

    @Before
    public void init() {
        this.mockEditBioInteractor = new MockEditBioInteractor();
    }

    @Test
    public void testInitialization() {
        EditBioController controller = new EditBioController(mockEditBioInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        EditBioController controller = new EditBioController(mockEditBioInteractor);

        controller.execute("", "");

        assertEquals("Success", ((MockEditBioInteractor) mockEditBioInteractor).getState());
    }
}