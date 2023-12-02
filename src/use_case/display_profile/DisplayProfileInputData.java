package use_case.display_profile;

public class DisplayProfileInputData {
    final private String otherUsername;

    public DisplayProfileInputData(String otherUsername) {
        this.otherUsername = otherUsername;
    }

    String getOtherUsername() {
        return otherUsername;
    }

}
