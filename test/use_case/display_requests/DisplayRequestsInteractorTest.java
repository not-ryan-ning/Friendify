package use_case.display_requests;

import data_access.display_requests.MockDisplayRequestUserDataAccessObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DisplayRequestsInteractorTest {
    private DisplayRequestsUserDataAccessInterface mockDisplayRequestsUserDAO;
    private DisplayRequestsOutputBoundary mockDisplayRequestsPresenter;

    @Before
    public void init() {
        this.mockDisplayRequestsUserDAO = new MockDisplayRequestUserDataAccessObject();
        this.mockDisplayRequestsPresenter = new MockDisplayRequestsPresenter();
    }

    @Test
    public void testInitialization() {
        DisplayRequestsInteractor interactor = new DisplayRequestsInteractor(mockDisplayRequestsUserDAO,
                mockDisplayRequestsPresenter);

        assertNotNull(interactor);
    }

    @Test
    public void testExecuteSuccess() {
        DisplayRequestsInteractor interactor = new DisplayRequestsInteractor(mockDisplayRequestsUserDAO,
                mockDisplayRequestsPresenter);


        interactor.execute("");

        assertEquals("Success", ((MockDisplayRequestsPresenter) mockDisplayRequestsPresenter).getState());
    }

}
