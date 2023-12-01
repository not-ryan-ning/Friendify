package interface_adapter.goBack;

import use_case.goBack.GoBackInputBoundary;

public class GoBackController {
    final GoBackInputBoundary goBackUseCaseInteractor;

    public GoBackController(GoBackInputBoundary logoutUseCaseInteractor) {
        this.goBackUseCaseInteractor = logoutUseCaseInteractor;
    }

    public void execute() {
        goBackUseCaseInteractor.execute();
    }
}
