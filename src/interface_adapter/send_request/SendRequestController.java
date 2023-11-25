package interface_adapter.send_request;

import entity.User; // I don't think this is allowed
import use_case.send_request.SendRequestInputBoundary;
import use_case.send_request.SendRequestInputData;
public class SendRequestController {
    final SendRequestInputBoundary sendRequestInteractor;

    public SendRequestController(SendRequestInputBoundary sendRequestInteractor) {
        this.sendRequestInteractor = sendRequestInteractor;
    }

    public void execute(User sender, String receiverUsername) {
        SendRequestInputData sendRequestInputData = new SendRequestInputData(receiverUsername);
        sendRequestInteractor.execute(sender, sendRequestInputData);
    }
}
