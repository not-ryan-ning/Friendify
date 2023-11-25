package use_case.send_request;

public class SendRequestInputData {
    final private String senderUsername;
    final private String receiverUsername;
    public SendRequestInputData(String senderUsername, String receiverUsername) {
        this.senderUsername = senderUsername;
        this.receiverUsername = receiverUsername;
    }
    String getSenderUsername() {
        return senderUsername;
    }

    String getReceiverUsername() {
        return receiverUsername;
    }

}
