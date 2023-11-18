package use_case.display_friends;

public class DisplayFriendsInputData {
    final private String username;
    public DisplayFriendsInputData(String username) {
        this.username = username;
    }

    String getUsername() {
        return username;
    }
}
