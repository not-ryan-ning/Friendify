package interface_adapter.goBack;

import use_case.goBack.GoBackOutputBoundary;

public class GoBackPresenter implements GoBackOutputBoundary {
    private final GoBackViewModel goBackViewModel;
    private ViewManagerModel viewManagerModel;
    private LoggedInViewModel loggedInViewModel;
    public GoBackPresenter(GoBackViewModel goBackViewModel, ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel) {
        this.goBackViewModel = goBackViewModel;
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    /**
     * Prepares and switches the view to back to the logged in view for the back button function.
     */
    @Override
    public void prepareSuccessView() {
        // On success, switch to the home page (the logged in view)
        LoggedInState loggedInState = loggedInViewModel.getState();
        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
