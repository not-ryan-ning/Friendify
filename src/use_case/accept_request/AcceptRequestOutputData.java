package use_case.accept_request;

import java.util.ArrayList;

public class AcceptRequestOutputData {
    private ArrayList<String> requests;
    private String acceptedUsername;

    public AcceptRequestOutputData(ArrayList<String> requests, String acceptedUsername) {
        this.requests = requests;
        this.acceptedUsername = acceptedUsername;
    }

    public ArrayList<String> getRequests() {
        return requests;
    }

    public String getAcceptedUsername() { return acceptedUsername; }
}
