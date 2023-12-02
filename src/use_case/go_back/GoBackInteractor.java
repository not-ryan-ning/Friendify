package use_case.go_back;

public class GoBackInteractor implements GoBackInputBoundary{
    final GoBackOutputBoundary goBackPresenter;


    public GoBackInteractor(GoBackOutputBoundary goBackOutputBoundary) {
        this.goBackPresenter = goBackOutputBoundary;
    }
    @Override
    public void execute() {
        goBackPresenter.prepareSuccessView();
    }
}
