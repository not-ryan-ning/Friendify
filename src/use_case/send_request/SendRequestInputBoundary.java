package use_case.send_request;

import entity.User;

public interface SendRequestInputBoundary {
    void execute(User sender, SendRequestInputData sendRequestInputData);
}
