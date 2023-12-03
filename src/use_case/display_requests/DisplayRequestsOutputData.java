package use_case.display_requests;

import java.util.ArrayList;
public class DisplayRequestsOutputData {
    private final ArrayList<String> requests;
    public DisplayRequestsOutputData(ArrayList<String> requests) {
        this.requests = requests;
    }
    public ArrayList<String> getRequests() { return this.requests; }
}
