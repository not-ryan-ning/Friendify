package interface_adapter.send_request;

/**
 * Represents the state of a user sending a request to another user
 */
public class SendRequestState {
    private String receiverUsername = "";
    private String requestError = null;
    private final String requestSentMessage = "Request Sent";

    public SendRequestState(SendRequestState copy){
        this.receiverUsername = copy.receiverUsername;
        this.requestError = copy.requestError;
    }
    public SendRequestState(){}
    public String getReceiverUsername() {
        return receiverUsername;
    }
    public void setReceiverUsername(String receiverUsername) {
        this.receiverUsername = receiverUsername;
    }
    public String getRequestError() {
        return requestError;
    }
    public void setRequestError(String requestError) {
        this.requestError = requestError;
    }
    public String getRequestSentMessage(){
        return requestSentMessage;
    }
}