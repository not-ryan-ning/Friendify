package interface_adapter.send_request;

public class SendRequestState {
    private String receiverUsername = "";
    private String requestError = null;

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
}
