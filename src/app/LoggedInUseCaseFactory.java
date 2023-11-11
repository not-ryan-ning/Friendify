package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.logout.LogoutViewModel;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.logout.LogoutUserDataAccessInterface;
import view.view.LoggedInView;

import javax.swing.*;
import java.io.IOException;

public class LoggedInUseCaseFactory {
    private LoggedInUseCaseFactory() {}
    public static LoggedInView create(
            ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel, LogoutViewModel logoutViewModel,
            LogoutUserDataAccessInterface logoutUserDataAccessInterface, LoginViewModel loginViewModel) {

        try {
            LogoutController logoutController = createLogoutUseCase(viewManagerModel, logoutUserDataAccessInterface, loginViewModel);
            return new LoggedInView(loggedInViewModel, logoutViewModel, logoutController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

                           
private static LogoutController createLogoutUseCase(ViewManagerModel viewManagerModel, LogoutUserDataAccessInterface logoutUserDataAccessInterface,
                                                    LoginViewModel loginViewModel) throws IOException {
        LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel, loginViewModel);
        LogoutInputBoundary logoutInteractor = new LogoutInteractor(logoutUserDataAccessInterface, logoutOutputBoundary);
        return new LogoutController(logoutInteractor);
    }
}
