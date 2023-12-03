package interface_adapter.logout;

import interface_adapter.ViewManagerModel;
import use_case.logout.LogoutOutputBoundary;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.LoginState;
/**
 * Prepares and updates view for corresponding operation.
 */
public class LogoutPresenter implements LogoutOutputBoundary {
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;
    private LogoutViewModel logoutViewModel;

    public LogoutPresenter(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, LogoutViewModel logoutViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.logoutViewModel = logoutViewModel;
    }

    /**
     * Prepares and switches the view back to the login view for the logout function.
     */
    @Override
    public void prepareSuccessView() {
        LogoutState logoutState = logoutViewModel.getState();

        this.logoutViewModel.setState(logoutState);
        this.logoutViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(logoutViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

        LoginState loginState = loginViewModel.getState();
        // clearing the previous login information.
        loginState.setUsername("");
        loginState.setPassword("");
        this.loginViewModel.setState(loginState);
        this.loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
