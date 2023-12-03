package interface_adapter.send_request;

import use_case.send_request.SendRequestInputBoundary;
import use_case.send_request.SendRequestInputData;

/**
 * Initiates operations related to sending a user a friend request
 */
public class SendRequestController {
    final SendRequestInputBoundary sendRequestInteractor;

    public SendRequestController(SendRequestInputBoundary sendRequestInteractor) {
        this.sendRequestInteractor = sendRequestInteractor;
    }

    public void execute(String senderUsername, String receiverUsername) {
        SendRequestInputData sendRequestInputData = new SendRequestInputData(receiverUsername);
        sendRequestInteractor.execute(senderUsername, sendRequestInputData);
    }
}
