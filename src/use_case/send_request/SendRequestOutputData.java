package use_case.send_request;

public class SendRequestOutputData {
    private final String receiverUsername;
    private boolean useCaseFailed;

    public SendRequestOutputData(String receiverUsername, boolean useCaseFailed) {
        this.receiverUsername = receiverUsername;
        this.useCaseFailed = useCaseFailed;
    }

    public String requestSent() {
        return "Friend Request Sent to" + receiverUsername;
    }
}
