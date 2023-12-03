package use_case.edit_profile;

import interface_adapter.ViewManagerModel;
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
        editProfileInteractor = ...
    }
    @Test
    public void testExecute() {
        editProfileInteractor.execute();
        assertEquals("Edit Profile", viewManagerModel.getActiveView());
    }

}