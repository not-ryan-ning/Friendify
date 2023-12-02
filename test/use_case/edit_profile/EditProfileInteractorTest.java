package use_case.edit_profile;

import interface_adapter.ViewManagerModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class EditProfileInteractorTest {
    private EditProfileInteractor editProfileInteractor;
    private ViewManagerModel viewManagerModel;
    @Test
    public void testExecute() {
        editProfileInteractor.execute();
        assertEquals("Edit Profile", viewManagerModel.getActiveView());
    }

}