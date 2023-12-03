package use_case.accept_request;

public class AcceptRequestInputData {
    final private String acceptedUsername;
    public AcceptRequestInputData(String acceptedUsername) {
        this.acceptedUsername = acceptedUsername;
    }

    public String getAcceptedUsername() {
        return acceptedUsername;
    }
}
