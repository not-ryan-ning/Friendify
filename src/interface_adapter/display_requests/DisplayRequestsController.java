package interface_adapter.display_requests;

import entity.User;
import use_case.display_requests.DisplayRequestsInputBoundary;

public class DisplayRequestsController {
    final DisplayRequestsInputBoundary displayRequestsInteractor;
    public DisplayRequestsController(DisplayRequestsInputBoundary displayRequestsInteractor) {
        this.displayRequestsInteractor = displayRequestsInteractor;
    }

    public void execute(String username) {
        displayRequestsInteractor.execute(username);
    }

}
