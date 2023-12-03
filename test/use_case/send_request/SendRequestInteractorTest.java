package use_case.send_request;

import data_access.FileUserDataAccessObject;
import entity.CommonProfileFactory;
import entity.CommonUserFactory;
import entity.ProfileFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.send_request.SendRequestPresenter;
import interface_adapter.send_request.SendRequestViewModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.match.MatchInteractor;

import java.io.IOException;

import static org.junit.Assert.*;

public class SendRequestInteractorTest {
    private SendRequestInteractor sendRequestInteractor;
    private ViewManagerModel viewManagerModel;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        UserFactory uf = new CommonUserFactory();
        ProfileFactory pf = new CommonProfileFactory();
        SendRequestUserDataAccessInterface user = new FileUserDataAccessObject("./users", uf, pf);
        sendRequestInteractor = new SendRequestInteractor(user, new SendRequestPresenter(new SendRequestViewModel(), viewManagerModel));
    }
    @Test
    public void testExecute() {
        sendRequestInteractor.execute("user1", new SendRequestInputData("user2"));
        assertEquals("send request", viewManagerModel.getActiveView());
    }


}