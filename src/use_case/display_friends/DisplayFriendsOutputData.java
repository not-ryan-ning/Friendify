package use_case.display_friends;

import java.util.ArrayList;

public class DisplayFriendsOutputData {
    private final ArrayList<String> friendNames;
    public DisplayFriendsOutputData(ArrayList<String> friendNames) {
        this.friendNames = friendNames;
    }
}
