package use_case.edit_profile;

import interface_adapter.ViewManagerModel;
import interface_adapter.edit_profile.EditProfilePresenter;
import interface_adapter.edit_profile.EditProfileViewModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class EditProfileInteractorTest {
    private EditProfileInteractor editProfileInteractor;
    private ViewManagerModel viewManagerModel;
    @BeforeEach
    public void setUp() {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        editProfileInteractor = new EditProfileInteractor(new EditProfilePresenter(viewManagerModel, new EditProfileViewModel()));
    }
    @Test
    public void testExecute() {
        editProfileInteractor.execute();
        assertEquals("Edit Profile", viewManagerModel.getActiveView());
    }

}