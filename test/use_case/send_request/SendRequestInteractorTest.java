package use_case.send_request;

import data_access.send_request.MockSendRequestUserDataAccessObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SendRequestInteractorTest {
    private SendRequestUserDataAccessInterface mockSendRequestUserDAO;
    private SendRequestOutputBoundary mockSendRequestPresenter;

    @Before
    public void init() {
        this.mockSendRequestUserDAO = new MockSendRequestUserDataAccessObject();
        this.mockSendRequestPresenter = new MockSendRequestPresenter();
    }

    @Test
    public void testInitialization() {
        SendRequestInteractor interactor = new SendRequestInteractor(mockSendRequestUserDAO,
                mockSendRequestPresenter);

        assertNotNull(interactor);
    }

    @Test
    public void testExecuteSuccess() {
        SendRequestInteractor interactor = new SendRequestInteractor(mockSendRequestUserDAO,
                mockSendRequestPresenter);
        SendRequestInputData inputData = new MockSendRequestInputData("");

        interactor.execute("", inputData);

        assertEquals("Success", ((MockSendRequestPresenter) mockSendRequestPresenter).getState());
    }

    @Test
    public void testExecuteFailure() {
        SendRequestInteractor interactor = new SendRequestInteractor(mockSendRequestUserDAO,
                mockSendRequestPresenter);
        SendRequestInputData inputData = new MockSendRequestInputData("Reciever");

        interactor.execute("", inputData);

        assertEquals("Failure", ((MockSendRequestPresenter) mockSendRequestPresenter).getState());
    }
}
