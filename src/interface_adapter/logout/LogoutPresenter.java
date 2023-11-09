package interface_adapter.logout;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_out.LoggedOutViewModel;
import use_case.logout.LogoutOutputBoundary;
import use_case.logout.LogoutOutputData;
import interface_adapter.logged_out.LoggedOutState;

public class LogoutPresenter implements LogoutOutputBoundary {
    private final LogoutViewModel logoutViewModel;
    private final LoggedOutViewModel loggedOutViewModel;
    private ViewManagerModel viewManagerModel;

    public LogoutPresenter(ViewManagerModel viewManagerModel, LogoutViewModel logoutViewModel, LoggedOutViewModel loggedOutViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.logoutViewModel = logoutViewModel;
        this.loggedOutViewModel = loggedOutViewModel;
    }

    @Override
    public void prepareSuccessView(LogoutOutputData response) {
        // On success, switch to the logged out view.
        LoggedOutState loggedOutState = loggedOutViewModel.getState();
  //      logoutState.setLoggedOutUsers(response.getLoggedoutUser());
        this.loggedOutViewModel.setState(loggedOutState);
        this.loggedOutViewModel.firePropertyChanged();
        this.viewManagerModel.setActiveView(loggedOutViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
