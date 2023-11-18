package use_case.display_profile;

public class DisplayProfileInputData {
    final private String username;
    final private String otherUsername;

    public DisplayProfileInputData(String username, String otherUsername) {
        this.username = username;
        this.otherUsername = otherUsername;
    }
    String getUsername() {
        return username;
    }

    String getOtherUsername() {
        return otherUsername;
    }

}
