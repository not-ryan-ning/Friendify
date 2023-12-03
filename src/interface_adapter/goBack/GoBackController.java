package interface_adapter.goBack;

import use_case.goBack.GoBackInputBoundary;

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
