package use_case.display_profile;

import data_access.display_profile.MockDisplayProfileUserDataAccessObject;
import interface_adapter.display_profile.DisplayProfileViewModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DisplayProfileInteractorTest {
    private DisplayProfileUserDataAccessInterface mockDisplayProfileUserDAO;
    private DisplayProfileOutputBoundary mockDisplayProfilePresenter;
    private DisplayProfileViewModel mockDisplayProfileViewModel;

    @Before
    public void init() {
        this.mockDisplayProfileUserDAO = new MockDisplayProfileUserDataAccessObject();
        this.mockDisplayProfilePresenter = new MockDisplayProfilePresenter();
        this.mockDisplayProfileViewModel = new MockDisplayProfileViewModel();
    }

    @Test
    public void testInitialization() {
        DisplayProfileInteractor interactor = new DisplayProfileInteractor(mockDisplayProfileUserDAO,
                mockDisplayProfilePresenter, mockDisplayProfileViewModel);

        assertNotNull(interactor);
    }

    @Test
    public void testExecuteCommon() {
        DisplayProfileInteractor interactor = new DisplayProfileInteractor(mockDisplayProfileUserDAO,
                mockDisplayProfilePresenter, mockDisplayProfileViewModel);
        MockDisplayProfileInputData inputData = new MockDisplayProfileInputData("");

        interactor.execute("", inputData);

        assertEquals("Common", ((MockDisplayProfilePresenter) mockDisplayProfilePresenter).getState());
    }

    @Test
    public void testExecuteFriends() {
        DisplayProfileInteractor interactor = new DisplayProfileInteractor(mockDisplayProfileUserDAO,
                mockDisplayProfilePresenter, mockDisplayProfileViewModel);
        MockDisplayProfileInputData inputData = new MockDisplayProfileInputData("Josh Hutcherson");

        interactor.execute("", inputData);

        assertEquals("Friends", ((MockDisplayProfilePresenter) mockDisplayProfilePresenter).getState());
    }
}

