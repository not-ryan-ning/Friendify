package interface_adapter.edit_profile;

import org.junit.Before;
import org.junit.Test;
import use_case.edit_profile.EditProfileInputBoundary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EditProfileControllerTest {
    private EditProfileInputBoundary mockEditProfileInteractor;

    @Before
    public void init() {
        this.mockEditProfileInteractor = new MockEditProfileInteractor();
    }

    @Test
    public void testInitialization() {
        EditProfileController controller = new EditProfileController(mockEditProfileInteractor);

        assertNotNull(controller);
    }

    @Test
    public void testExecuteSuccess() {
        EditProfileController controller = new EditProfileController(mockEditProfileInteractor);

        controller.execute();

        assertEquals("Success", ((MockEditProfileInteractor) mockEditProfileInteractor).getState());
    }
}