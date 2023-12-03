package use_case.login;

import interface_adapter.ViewManagerModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class LoginInteractorTest {
    private LoginInteractor loginInteractor;
    private ViewManagerModel viewManagerModel;
    @BeforeEach
    public void setUp() {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        loginInteractor = ...
    }
    @Test
    public void testExecute() {
        loginInteractor.execute(new LoginInputData("u", "p"));
        assertEquals("log in", viewManagerModel.getActiveView());
    }

}