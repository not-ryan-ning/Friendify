package use_case.goBack;

public class GoBackInteractor implements GoBackInputBoundary{
    final GoBackUserDataAccessInterface userDataAccessObject;
    final GoBackOutputBoundary goBackPresenter;


    public GoBackInteractor(GoBackUserDataAccessInterface userDataAccessInterface,
                            GoBackOutputBoundary goBackOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.goBackPresenter = goBackOutputBoundary;
    }
    @Override
    public void execute() {
        goBackPresenter.prepareSuccessView();
    }
}
