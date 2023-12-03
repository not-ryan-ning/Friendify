package interface_adapter.accept_request;

import java.util.ArrayList;

public class AcceptRequestState {
    private ArrayList<String> requests;
    private String username;
    public AcceptRequestState(AcceptRequestState copy) {
        this.requests = copy.requests;
        this.username = copy.username;
    }
    public AcceptRequestState() {
    }
}
