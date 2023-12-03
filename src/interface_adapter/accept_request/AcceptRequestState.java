package interface_adapter.accept_request;

import java.util.ArrayList;

/**
 * Represents the state of user accepting a friend request
 */
public class AcceptRequestState {
    private ArrayList<String> requests;
    private String username;
    private String acceptedUsername;
    private String acceptError = null;
    private final String acceptedMessage = "Accepted";
    public AcceptRequestState(AcceptRequestState copy) {
        this.requests = copy.requests;
        this.username = copy.username;
        this.acceptedUsername = copy.acceptedUsername;
    }
    public AcceptRequestState() {}
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getAcceptError() { return acceptError; }
    public void setAcceptError(String acceptError) { this.acceptError = acceptError; }
    public String getAcceptedMessage() { return acceptedMessage; }
}

