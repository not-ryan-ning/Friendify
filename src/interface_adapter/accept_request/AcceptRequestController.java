package interface_adapter.accept_request;

import use_case.accept_request.AcceptRequestInputBoundary;
import use_case.accept_request.AcceptRequestInputData;

/**
 * Initiates operations for a user accepting another user's request.
 */
public class AcceptRequestController {
    final AcceptRequestInputBoundary acceptRequestInteractor;

    public AcceptRequestController(AcceptRequestInputBoundary acceptRequestInteractor) {
        this.acceptRequestInteractor = acceptRequestInteractor;
    }

    public void execute(String currentUsername, String acceptedUsername) {
        AcceptRequestInputData acceptRequestInputData = new AcceptRequestInputData(acceptedUsername);
        acceptRequestInteractor.execute(currentUsername, acceptRequestInputData);
    }

}
