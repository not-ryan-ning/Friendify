package interface_adapter.send_request;

public class SendRequestState {
    private String requestSent = "";
    private String friendError = null;

    public SendRequestState(SendRequestState copy) {
        requestSent = copy.requestSent;
        friendError = copy.friendError;
    }

    public SendRequestState() {
    }

    public String getRequestSent() {
        return requestSent;
    }

    public void setRequestSent(String requestSent) {
        this.requestSent = requestSent;
    }

    public String getFriendError() {
        return friendError;
    }

    public void setFriendError(String friendError) {
        this.friendError = friendError;
    }
}
