package use_case.display_profile;

public class DisplayProfileInputData {
    final private String username;

    public DisplayProfileInputData(String username) {
        this.username = username;
    }
    String getUsername() {
        return username;
    }

}
