package interface_adapter.display_profile;

import use_case.display_profile.DisplayProfileInputBoundary;
import use_case.display_profile.DisplayProfileInputData;

public class DisplayProfileController {
    final DisplayProfileInputBoundary displayProfileUseCaseInteractor;

    /**
     * Constructs an instance of DisplayProfileController using DisplayProfileInputBoundary.
     *
     * @param displayProfileUseCaseInteractor An implementation of the DisplayProfileInputBoundary interface.
     */
    public DisplayProfileController(DisplayProfileInputBoundary displayProfileUseCaseInteractor) {
        this.displayProfileUseCaseInteractor = displayProfileUseCaseInteractor;
    }

    /**
     * Initiates the display profile function by calling the execute method.
     *
     * @param username      The username of the current user who wants to view a profile.
     * @param otherUsername The username of the profile to be displayed.
     */
    public void execute(String username, String otherUsername) {
        DisplayProfileInputData displayProfileInputData = new DisplayProfileInputData(otherUsername);
        displayProfileUseCaseInteractor.execute(username, displayProfileInputData);
    }
}
