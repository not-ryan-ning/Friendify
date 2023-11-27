package use_case.send_request;

public class SendRequestInputData {
    final private String receiverUsername;

    public SendRequestInputData(String receiverUsername) {
        this.receiverUsername = receiverUsername;
    }

    String getReceiverUsername() {
        return receiverUsername;
    }
}
