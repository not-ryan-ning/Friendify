package use_case.send_request;

import entity.User;

public interface SendRequestInputBoundary {
    /**
     * Receives inputs from user, accesses entities to perform the logic of send request,
     * and invokes the Presenter.
     * @param senderUsername The username of the user who is sending the friend request
     * @param sendRequestInputData The Input Data of the send request use case
     */
    void execute(String senderUsername, SendRequestInputData sendRequestInputData);
}
