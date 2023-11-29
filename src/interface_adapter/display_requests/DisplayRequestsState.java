package interface_adapter.display_requests;
import java.util.ArrayList;

public class DisplayRequestsState {
    private ArrayList<String> requests;
    public DisplayRequestsState(DisplayRequestsState copy) {
        this.requests = requests;
    }
    public DisplayRequestsState() {
    }
    public ArrayList<String> getRequests() {
        return requests;
    }
    public void setRequests(ArrayList<String> requests) {
        this.requests = requests;
    }

    public void addRequests(String username) {
        requests.add(username);
    }

}
