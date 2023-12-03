package interface_adapter.display_requests;

import entity.User;
import use_case.display_requests.DisplayRequestsInputBoundary;

public class DisplayRequestsController {
    final DisplayRequestsInputBoundary displayRequestsInteractor;
    /**
     * Constructs an instance of DisplayRequestsController using DisplayRequestsInputBoundary.
     *
     * @param displayRequestsInteractor An implementation of the DisplayRequestsInputBoundary interface.
     */
    public DisplayRequestsController(DisplayRequestsInputBoundary displayRequestsInteractor) {
        this.displayRequestsInteractor = displayRequestsInteractor;
    }

    /**
     * Initiates the display request function by calling the execute method.
     * @param username The username of the current user who wants to see their requests.
     */
    public void execute(String username) {
        displayRequestsInteractor.execute(username);
    }

}
