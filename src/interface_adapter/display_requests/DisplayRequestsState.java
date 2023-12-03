package interface_adapter.display_requests;
import java.util.ArrayList;

/**
 * Represents the state for displaying requests, including the list of requests, a username, and a request name.
 */
public class DisplayRequestsState {
    private ArrayList<String> requests;
    private String username;
    private String requestName;
    public DisplayRequestsState(DisplayRequestsState copy) {
        this.requests = copy.requests;
        this.username = copy.username;
        this.requestName = copy.requestName;
    }
    public DisplayRequestsState() {
    }
    public ArrayList<String> getRequests() {
        return requests;
    }
    public String getUsername() { return username; }
    public String getRequestName() { return requestName; }
    public void setRequests(ArrayList<String> requests) {
        this.requests = requests;
    }
    public void setUsername(String username) { this.username = username; }
    public void setRequestName(String requestName) { this.requestName = requestName; }
}
