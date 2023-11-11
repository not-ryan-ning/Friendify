package interface_adapter.logout;

import interface_adapter.ViewManagerModel;
import use_case.logout.LogoutOutputBoundary;
import use_case.logout.LogoutOutputData;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.LoginState;

public class LogoutPresenter implements LogoutOutputBoundary {
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;
    private LogoutViewModel logoutViewModel;

    public LogoutPresenter(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, LogoutViewModel logoutViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.logoutViewModel = logoutViewModel;
    }

    @Override
    public void prepareSuccessView(LogoutOutputData response) {
        LogoutState logoutState = logoutViewModel.getState();


        this.logoutViewModel.setState(logoutState);
        this.logoutViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(logoutViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

        // now switch to login screen
        LoginState loginState = loginViewModel.getState();
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
