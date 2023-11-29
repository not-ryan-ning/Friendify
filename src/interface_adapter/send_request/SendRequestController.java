package interface_adapter.send_request;

import entity.User;
import use_case.send_request.SendRequestInputBoundary;
import use_case.send_request.SendRequestInputData;
public class SendRequestController {
    final SendRequestInputBoundary sendRequestInteractor;

    public SendRequestController(SendRequestInputBoundary sendRequestInteractor) {
        this.sendRequestInteractor = sendRequestInteractor;
    }

    public void execute(String senderUsername, String receiverUsername) {
        // Retrieve current user from LoggedInState
        SendRequestInputData sendRequestInputData = new SendRequestInputData(receiverUsername);
        sendRequestInteractor.execute(senderUsername, sendRequestInputData);
    }
}
