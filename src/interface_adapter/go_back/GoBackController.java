package interface_adapter.go_back;

import use_case.go_back.GoBackInputBoundary;

/**
 * Initiates operations related to going back to the logged in page.
 */
public class GoBackController {
    final GoBackInputBoundary goBackUseCaseInteractor;

    public GoBackController(GoBackInputBoundary logoutUseCaseInteractor) {
        this.goBackUseCaseInteractor = logoutUseCaseInteractor;
    }

    /**
     * Executes the function of going back to logged in page.
     */
    public void execute() {
        goBackUseCaseInteractor.execute();
    }
}
