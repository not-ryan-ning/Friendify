package use_case.edit_profile;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EditProfileInteractorTest {
    private EditProfileOutputBoundary mockEditProfilePresenter;

    @Before
    public void init() {
        this.mockEditProfilePresenter = new MockEditProfilePresenter();

    }

    @Test
    public void testInitialization() {
        EditProfileInteractor interactor = new EditProfileInteractor(mockEditProfilePresenter);

        assertNotNull(interactor);
    }

    @Test
    public void testExecuteSuccess() {
        EditProfileInteractor interactor = new EditProfileInteractor(mockEditProfilePresenter);

        interactor.execute();

        assertEquals("Success", ((MockEditProfilePresenter) mockEditProfilePresenter).getState());

    }
}
