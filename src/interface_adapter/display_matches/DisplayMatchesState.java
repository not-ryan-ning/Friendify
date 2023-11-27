package interface_adapter.display_matches;

import java.util.HashMap;

public class DisplayMatchesState {
    private HashMap<String, Double> matches;
    private String receiverUsername;
    private String requestError = null;

    public DisplayMatchesState(DisplayMatchesState copy) {
        this.matches = copy.matches;
        this.receiverUsername = copy.receiverUsername;
        this.requestError = copy.requestError;
    }
    public DisplayMatchesState() {}

    public HashMap<String, Double> getMatches() {
        return matches;
    }
    public void setMatches(HashMap<String, Double> matches) {
        this.matches = matches;
    }
    public String getReceiverUsername() {
        return receiverUsername;
    }
    public void setReceiverUsername(String recieverUsername) {
        this.receiverUsername = recieverUsername;
    }
    public String getRequestError() {
        return requestError;
    }
    public void setRequestError(String requestError) {
        this.requestError = requestError;
    }
}