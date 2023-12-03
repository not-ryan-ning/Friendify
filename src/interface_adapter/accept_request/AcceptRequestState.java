package interface_adapter.accept_request;

import java.util.ArrayList;

/**
 * Represents the state of user accepting a friend request
 */
public class AcceptRequestState {
    private ArrayList<String> requests;
    private String username;
    public AcceptRequestState(AcceptRequestState copy) {
        this.requests = copy.requests;
        this.username = copy.username;
    }
    public AcceptRequestState() {
    }
    public ArrayList<String> getRequests() {
        return requests;
    }
    public String getUsername() { return username; }
    public void setRequests(ArrayList<String> requests) {
        this.requests = requests;
    }
    public void setUsername(String username) { this.username = username; }
}

