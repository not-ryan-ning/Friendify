package interface_adapter.goBack;

import use_case.goBack.GoBackOutputBoundary;

public class GoBackPresenter implements GoBackOutputBoundary {
    private final GoBackViewModel goBackViewModel;
    private ViewManagerModel viewManagerModel;
    public GoBackPresenter(GoBackViewModel goBackViewModel, ViewManagerModel viewManagerModel) {
        this.goBackViewModel = goBackViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {
        // On success, switch to the previous view.
        GoBackState goBackState = goBackViewModel.getState();

    }
}
