package use_case.send_request;

import entity.User;

public interface SendRequestInputBoundary {
    void execute(String senderUsername, SendRequestInputData sendRequestInputData);
}
