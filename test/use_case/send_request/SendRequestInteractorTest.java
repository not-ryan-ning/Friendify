package use_case.send_request;

import interface_adapter.ViewManagerModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.match.MatchInteractor;

import static org.junit.Assert.*;

public class SendRequestInteractorTest {
    private SendRequestInteractor sendRequestInteractor;
    private ViewManagerModel viewManagerModel;

    @BeforeEach
    public void setUp() {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        sendRequestInteractor = ...
    }
    @Test
    public void testExecute() {
        sendRequestInteractor.execute("user1", new SendRequestInputData("user2"));
        assertEquals("send request", viewManagerModel.getActiveView());
    }


}