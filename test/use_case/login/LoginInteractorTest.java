package use_case.login;

import interface_adapter.ViewManagerModel;
import org.junit.Test;
import use_case.edit_bio.EditBioInputData;
import use_case.edit_bio.EditBioInteractor;

import static org.junit.Assert.*;

public class LoginInteractorTest {
    private LoginInteractor loginInteractor;
    private ViewManagerModel viewManagerModel;
    @Test
    public void testExecute() {
        loginInteractor.execute(new LoginInputData("u", "p"));
        assertEquals("log in", viewManagerModel.getActiveView());
    }

}