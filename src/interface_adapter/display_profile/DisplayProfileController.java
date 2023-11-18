package interface_adapter.display_profile;

import use_case.display_profile.DisplayProfileInputBoundary;

public class DisplayProfileController {
    final DisplayProfileInputBoundary displayProfileUseCaseInteractor;

    public DisplayProfileController(DisplayProfileInputBoundary displayProfileUseCaseInteractor) {
        this.displayProfileUseCaseInteractor = displayProfileUseCaseInteractor;
    }

    public void execute() {
        displayProfileUseCaseInteractor.execute();
    }
}
