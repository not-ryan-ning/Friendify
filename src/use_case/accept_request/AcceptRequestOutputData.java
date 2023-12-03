package use_case.accept_request;

import java.util.ArrayList;

public class AcceptRequestOutputData {
    private ArrayList<String> requests;

    public AcceptRequestOutputData(ArrayList<String> requests) {
        this.requests = requests;
    }

    public ArrayList<String> getRequests() {
        return requests;
    }
}
