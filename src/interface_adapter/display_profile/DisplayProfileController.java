package interface_adapter.display_profile;

import use_case.display_profile.DisplayProfileInputBoundary;
import use_case.display_profile.DisplayProfileInputData;

public class DisplayProfileController {
    final DisplayProfileInputBoundary displayProfileUseCaseInteractor;

    public DisplayProfileController(DisplayProfileInputBoundary displayProfileUseCaseInteractor) {
        this.displayProfileUseCaseInteractor = displayProfileUseCaseInteractor;
    }

    public void execute(String username, String otherUsername) {
        DisplayProfileInputData displayProfileInputData = new DisplayProfileInputData(otherUsername);
        displayProfileUseCaseInteractor.execute(username, displayProfileInputData);
    }
}
