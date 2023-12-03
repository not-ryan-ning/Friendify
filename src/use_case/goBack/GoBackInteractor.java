package use_case.goBack;

public class GoBackInteractor implements GoBackInputBoundary{
    final GoBackUserDataAccessInterface userDataAccessObject;
    final GoBackOutputBoundary goBackPresenter;


    public GoBackInteractor(GoBackUserDataAccessInterface userDataAccessInterface,
                            GoBackOutputBoundary goBackOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
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
