package use_case.send_request;

import entity.User;

import java.util.ArrayList;

public class SendRequestInteractor implements SendRequestInputBoundary {
    final SendRequestUserDataAccessInterface sendRequestUserDAO;
    final SendRequestOutputBoundary sendRequestPresenter;
    public SendRequestInteractor(SendRequestUserDataAccessInterface sendRequestUserDataAccessInterface,
                                 SendRequestOutputBoundary sendRequestOutputBoundary) {
        this.sendRequestUserDAO = sendRequestUserDataAccessInterface;
        this.sendRequestPresenter = sendRequestOutputBoundary;
    }
    @Override
    public void execute(String senderUsername, SendRequestInputData sendRequestInputData) {
        String receiverUsername = sendRequestInputData.getReceiverUsername();

        User sender = sendRequestUserDAO.get(senderUsername);
        User receiver = sendRequestUserDAO.get(receiverUsername);

        //execute if the sender has already requested the receiver
        if (sendRequestUserDAO.isRequested(sender, receiver)) {
            sendRequestPresenter.prepareFailView("You have already requested " + receiverUsername);

            //execute if the sender has not previously requested the receiver
        } else {
            ArrayList<String> requests = sendRequestUserDAO.sendFriendRequest(sender, receiver);
            receiver.setRequests(requests);
            sendRequestUserDAO.editFile(receiverUsername, "requests", requests.toString());

            SendRequestOutputData sendRequestOutputData = new SendRequestOutputData(receiver.getUsername(), false);
            sendRequestPresenter.prepareSuccessView(sendRequestOutputData);
        }
    }
}