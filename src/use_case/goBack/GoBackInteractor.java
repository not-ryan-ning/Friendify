package use_case.goBack;

public class GoBackInteractor implements GoBackInputBoundary{
    final GoBackUserDataAcessInterface userDataAccessObject;
    final GoBackOutputBoundary goBackPresenter;


    public GoBackInteractor(GoBackUserDataAcessInterface userDataAccessInterface,
                            GoBackOutputBoundary goBackOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.goBackPresenter = goBackOutputBoundary;
    }
    @Override
    public void execute() {
        goBackPresenter.prepareSuccessView();
    }
}
