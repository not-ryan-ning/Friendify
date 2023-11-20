package use_case.display_requests;

import java.util.ArrayList;

public class DisplayRequestsInputData {
    final private String username;

    public DisplayRequestsInputData(String username) {
        this.username = username;
    }
    String getUsername() {
        return username;
    }
}
