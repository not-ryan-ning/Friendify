package interface_adapter.display_friends;

import java.util.ArrayList;

public class DisplayFriendsState {
    private ArrayList<String> friends;
    private String username;
    private String friendName;
    public DisplayFriendsState(DisplayFriendsState copy) {
        this.friends = copy.friends;
        this.username = copy.username;
        this.friendName = copy.friendName;
    }

    public DisplayFriendsState() {}
    public ArrayList<String> getFriends() { return friends; }
    public String getUsername() { return username; }
    public String getFriendName() { return friendName; }
    public void setFriends(ArrayList<String> friends) { this.friends = friends; }
    public void setUsername(String username) { this.username = username; }
    public void setFriendName(String friendName) { this.friendName = friendName; }

}
