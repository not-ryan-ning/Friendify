package use_case.accept_request;

public class AcceptRequestInputData {
    final private String currentUsername;
    final private String acceptedUsername;
    public AcceptRequestInputData(String currentUsername,
                                  String acceptedUsername) {
        this.currentUsername = currentUsername;
        this.acceptedUsername = acceptedUsername;
    }

    public String getCurrentUsername() {
        return currentUsername;
    }

    public String getAcceptedUsername() {
        return acceptedUsername;
    }

}
