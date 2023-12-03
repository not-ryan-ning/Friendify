package interface_adapter.accept_request;

import java.util.ArrayList;

/**
 * Represents the state of user accepting a friend request
 */
public class AcceptRequestState {
    private ArrayList<String> requests;
    private String username;
    private String acceptedUsername;
    public AcceptRequestState(AcceptRequestState copy) {
        this.requests = copy.requests;
        this.username = copy.username;
        this.acceptedUsername = copy.acceptedUsername;
    }
    public AcceptRequestState() {
    }
    public ArrayList<String> getRequests() {
        return requests;
    }
    public String getUsername() { return username; }
    public String getAcceptedUsername() { return acceptedUsername; }
    public void setRequests(ArrayList<String> requests) {
        this.requests = requests;
    }
    public void setUsername(String username) { this.username = username; }
    public void setAcceptedUsername(String acceptedUsername) { this.acceptedUsername = acceptedUsername; }
}

