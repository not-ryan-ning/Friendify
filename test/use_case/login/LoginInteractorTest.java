package use_case.login;

import data_access.login.MockLoginUserDataAccessObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LoginInteractorTest {
    private LoginUserDataAccessInterface mockLoginUserDAO;
    private LoginOutputBoundary mockLoginPresenter;

    @Before
    public void init() {
        this.mockLoginUserDAO = new MockLoginUserDataAccessObject();
        this.mockLoginPresenter = new MockLoginPresenter();
    }

    @Test
    public void testInitialization() {
        LoginInteractor interactor = new LoginInteractor(mockLoginUserDAO,
                mockLoginPresenter);

        assertNotNull(interactor);
    }

    @Test
    public void testExecuteSuccess() {
        LoginInteractor interactor = new LoginInteractor(mockLoginUserDAO,
                mockLoginPresenter);
        LoginInputData inputData = new MockLoginInputData("", "");

        interactor.execute(inputData);

        assertEquals("Success", ((MockLoginPresenter) mockLoginPresenter).getState());
    }

    @Test
    public void testExecuteFailureNonExistence() {
        LoginInteractor interactor = new LoginInteractor(mockLoginUserDAO,
                mockLoginPresenter);
        LoginInputData inputData = new MockLoginInputData("failureUser", "");

        interactor.execute(inputData);

        assertEquals("Failure", ((MockLoginPresenter) mockLoginPresenter).getState());
    }

    @Test
    public void testExecuteNull() {
        LoginInteractor interactor = new LoginInteractor(mockLoginUserDAO,
                mockLoginPresenter);
        LoginInputData inputData = new MockLoginInputData("failureUserNull", "");

        interactor.execute(inputData);

        assertEquals("Success", ((MockLoginPresenter) mockLoginPresenter).getState());
    }

    @Test
    public void testExecuteFailurePassword() {
        LoginInteractor interactor = new LoginInteractor(mockLoginUserDAO,
                mockLoginPresenter);
        LoginInputData inputData = new MockLoginInputData("successUser", "notCorrect");

        interactor.execute(inputData);

        assertEquals("Failure", ((MockLoginPresenter) mockLoginPresenter).getState());
    }



}
