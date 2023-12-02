package interface_adapter.go_back;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.go_back.GoBackOutputBoundary;

public class GoBackPresenter implements GoBackOutputBoundary {
    private final GoBackViewModel goBackViewModel;
    private ViewManagerModel viewManagerModel;
    private LoggedInViewModel loggedInViewModel;
    public GoBackPresenter(ViewManagerModel viewManagerModel, GoBackViewModel goBackViewModel, LoggedInViewModel loggedInViewModel) {
        this.goBackViewModel = goBackViewModel;
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView() {
        // On success, switch to the home page (the logged in view)
        LoggedInState loggedInState = loggedInViewModel.getState();
        this.loggedInViewModel.setState(loggedInState);

        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
