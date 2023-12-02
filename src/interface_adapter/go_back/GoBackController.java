package interface_adapter.go_back;

import use_case.go_back.GoBackInputBoundary;

public class GoBackController {
    final GoBackInputBoundary goBackUseCaseInteractor;

    public GoBackController(GoBackInputBoundary logoutUseCaseInteractor) {
        this.goBackUseCaseInteractor = logoutUseCaseInteractor;
    }

    public void execute() {
        goBackUseCaseInteractor.execute();
    }
}
