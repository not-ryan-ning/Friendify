package use_case.signup;

import data_access.signup.MockSignupUserDataAccessObject;
import entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SignupInteractorTest {
    private SignupUserDataAccessInterface mockSignupUserDAO;
    private SignupOutputBoundary mockSignupPresenter;
    private UserFactory userFactory;
    private ProfileFactory profileFactory;
    private PlaylistFactory playlistFactory;

    @Before
    public void init() {
        this.mockSignupUserDAO = new MockSignupUserDataAccessObject();
        this.mockSignupPresenter = new MockSignupPresenter();
        this.userFactory = new CommonUserFactory();
        this.profileFactory = new CommonProfileFactory();
        this.playlistFactory = new CommonPlaylistFactory();
    }

    @Test
    public void testInitialization() {
        SignupInteractor interactor = new SignupInteractor(mockSignupUserDAO,
                mockSignupPresenter,
                userFactory, profileFactory, playlistFactory);

        assertNotNull(interactor);
    }

    @Test
    public void testExecuteSuccess() {
        SignupInteractor interactor = new SignupInteractor(mockSignupUserDAO,
                mockSignupPresenter,
                userFactory, profileFactory, playlistFactory);
        SignupInputData inputData = new MockSignupInputData("", "", "");

        interactor.execute(inputData);

        assertEquals("Success", ((MockSignupPresenter) mockSignupPresenter).getState());
    }

    @Test
    public void testExecuteFailureUserAlreadyExist() {
        SignupInteractor interactor = new SignupInteractor(mockSignupUserDAO,
                mockSignupPresenter,
                userFactory, profileFactory, playlistFactory);
        SignupInputData inputData = new MockSignupInputData("aaa", "", "");

        interactor.execute(inputData);

        assertEquals("Failure", ((MockSignupPresenter) mockSignupPresenter).getState());
    }

    @Test
    public void testExecuteFailurePasswordMismatch() {
        SignupInteractor interactor = new SignupInteractor(mockSignupUserDAO,
                mockSignupPresenter,
                userFactory, profileFactory, playlistFactory);
        SignupInputData inputData = new MockSignupInputData("", "aaa", "");

        interactor.execute(inputData);

        assertEquals("Failure", ((MockSignupPresenter) mockSignupPresenter).getState());
    }


}
