package use_case.send_request;

import entity.User;

public class SendRequestInteractor implements SendRequestInputBoundary {
    final SendRequestUserDataAccessInterface sendRequestUserDAO;
    final SendRequestOutputBoundary sendRequestPresenter;
    public SendRequestInteractor(SendRequestUserDataAccessInterface sendRequestUserDataAccessInterface,
                                 SendRequestOutputBoundary sendRequestOutputBoundary) {
        this.sendRequestUserDAO = sendRequestUserDataAccessInterface;
        this.sendRequestPresenter = sendRequestOutputBoundary;
    }
    @Override
    public void execute(SendRequestInputData sendRequestInputData) {
        String senderUsername = sendRequestInputData.getSenderUsername();
        String receiverUsername = sendRequestInputData.getReceiverUsername();

        //execute if the sender and receiver are already friends
        if (sendRequestUserDAO.isFriend(senderUsername, receiverUsername)) {
            sendRequestPresenter.prepareFailView("Already friends with" + receiverUsername);

        //execute if the sender and receiver are not friends
        } else {
            User sender = sendRequestUserDAO.get(senderUsername);
            User receiver = sendRequestUserDAO.get(receiverUsername);
            sendRequestUserDAO.sendFriendRequest(sender, receiver);

            SendRequestOutputData sendRequestOutputData = new SendRequestOutputData(receiver.getUsername(), false);
            sendRequestPresenter.prepareSuccessView(sendRequestOutputData);
        }
    }
}
