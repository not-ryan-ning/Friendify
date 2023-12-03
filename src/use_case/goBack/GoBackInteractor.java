package use_case.goBack;

import use_case.go_back.GoBackInputBoundary;
import use_case.go_back.GoBackOutputBoundary;

public class GoBackInteractor implements GoBackInputBoundary {
    final GoBackOutputBoundary goBackPresenter;


    public GoBackInteractor(GoBackOutputBoundary goBackOutputBoundary) {
        this.goBackPresenter = goBackOutputBoundary;
    }

    /**
     * Calls the goBack presenter's prepareSuccessView method to change views.
     */
    @Override
    public void execute() {
        goBackPresenter.prepareSuccessView();
    }
}
