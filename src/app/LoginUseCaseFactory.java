package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.display_friends.DisplayFriendsController;
import interface_adapter.display_friends.DisplayFriendsPresenter;
import interface_adapter.display_friends.DisplayFriendsViewModel;
import interface_adapter.display_requests.DisplayRequestsController;
import interface_adapter.display_requests.DisplayRequestsPresenter;
import interface_adapter.display_requests.DisplayRequestsViewModel;
import interface_adapter.edit_profile.EditProfileController;
import interface_adapter.edit_profile.EditProfilePresenter;
import interface_adapter.edit_profile.EditProfileViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.logout.LogoutViewModel;
import interface_adapter.match.MatchController;
import interface_adapter.match.MatchPresenter;
import interface_adapter.match.MatchViewModel;
import use_case.display_friends.*;
import use_case.display_requests.*;
import use_case.edit_profile.EditProfileInputBoundary;
import use_case.edit_profile.EditProfileInteractor;
import use_case.edit_profile.EditProfileOutputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.match.MatchInputBoundary;
import use_case.match.MatchInteractor;
import use_case.match.MatchOutputBoundary;
import use_case.match.MatchUserDataAccessInterface;
import view.LoggedInView;
import view.LoginView;
import view.MatchView;

import javax.swing.*;
import java.io.IOException;

public class LoginUseCaseFactory {

    /** Prevent instantiation. */
    private LoginUseCaseFactory() {}

    public static LoginView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            LoggedInViewModel loggedInViewModel,
            LoginUserDataAccessInterface userDataAccessObject) {

        try {
            LoginController loginController = createLoginUseCase(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
            return new LoginView(loginViewModel, loginController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    public static LoggedInView create(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            LoginViewModel loginViewModel,
            LogoutViewModel logoutViewModel,
            DisplayRequestsViewModel displayRequestsViewModel,
            DisplayRequestsUserDataAccessInterface displayRequestsUserDataAccessObject,
            DisplayFriendsViewModel displayFriendsViewModel,
            DisplayFriendsUserDataAccessInterface displayFriendsUserDataAccessObject,
            MatchViewModel matchViewModel,
            MatchUserDataAccessInterface matchUserDataAccessObject,
            EditProfileViewModel editProfileViewModel) {
        try {
            LogoutController logoutController = createLogoutUseCase(viewManagerModel, loginViewModel, logoutViewModel);
            DisplayRequestsController displayRequestsController = createDisplayRequestsUseCase(viewManagerModel, displayRequestsViewModel, displayRequestsUserDataAccessObject);
            DisplayFriendsController displayFriendsController = createDisplayFriendsUseCase(viewManagerModel, displayFriendsViewModel, displayFriendsUserDataAccessObject);
            MatchController matchController = createMatchUseCase(viewManagerModel, matchViewModel, matchUserDataAccessObject);
            EditProfileController editProfileController = createEditProfileUseCase(viewManagerModel, editProfileViewModel);

            return new LoggedInView(loggedInViewModel, logoutController, displayRequestsViewModel, displayRequestsController, displayFriendsViewModel, displayFriendsController, matchViewModel, matchController, editProfileViewModel, editProfileController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static LoginController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            LoggedInViewModel loggedInViewModel,
            LoginUserDataAccessInterface userDataAccessObject) throws IOException {

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);
        LoginInputBoundary loginInteractor = new LoginInteractor(userDataAccessObject, loginOutputBoundary);

        return new LoginController(loginInteractor);
    }

    private static LogoutController createLogoutUseCase(ViewManagerModel viewManagerModel,
                                                        LoginViewModel loginViewModel,
                                                        LogoutViewModel logoutViewModel) throws IOException {

        LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel, loginViewModel, logoutViewModel);
        LogoutInputBoundary logoutInteractor = new LogoutInteractor(logoutOutputBoundary);

        return new LogoutController(logoutInteractor);
    }

    private static DisplayRequestsController createDisplayRequestsUseCase(ViewManagerModel viewManagerModel,
                                                                          DisplayRequestsViewModel displayRequestsViewModel,
                                                                          DisplayRequestsUserDataAccessInterface displayRequestsUserDataAccessObject) throws IOException {
        DisplayRequestsOutputBoundary displayRequestsOutputBoundary = new DisplayRequestsPresenter(viewManagerModel, displayRequestsViewModel);
        DisplayRequestsInputBoundary displayRequestsInteractor = new DisplayRequestsInteractor(displayRequestsUserDataAccessObject, displayRequestsOutputBoundary);

        return new DisplayRequestsController(displayRequestsInteractor);
    }

    private static DisplayFriendsController createDisplayFriendsUseCase(ViewManagerModel viewManagerModel,
                                                                        DisplayFriendsViewModel displayFriendsViewModel,
                                                                        DisplayFriendsUserDataAccessInterface displayFriendsUserDataAccessObject) throws IOException {
        DisplayFriendsOutputBoundary displayFriendsOutputBoundary = new DisplayFriendsPresenter(viewManagerModel, displayFriendsViewModel);
        DisplayFriendsInputBoundary displayFriendsInteractor = new DisplayFriendsInteractor(displayFriendsUserDataAccessObject, displayFriendsOutputBoundary);

        return new DisplayFriendsController(displayFriendsInteractor);
    }

    private static MatchController createMatchUseCase(ViewManagerModel viewManagerModel,
                                                         MatchViewModel matchViewModel,
                                                         MatchUserDataAccessInterface matchUserDataAccessObject) throws IOException {
        MatchOutputBoundary matchOutputBoundary = new MatchPresenter(viewManagerModel, matchViewModel);
        MatchInputBoundary matchInteractor = new MatchInteractor(matchUserDataAccessObject, matchOutputBoundary);

        return new MatchController(matchInteractor);
    }

    private static EditProfileController createEditProfileUseCase(ViewManagerModel viewManagerModel,
                                                                  EditProfileViewModel editProfileViewModel) throws IOException {
        EditProfileOutputBoundary editProfileOutputBoundary = new EditProfilePresenter(viewManagerModel, editProfileViewModel);
        EditProfileInputBoundary editProfileInteractor = new EditProfileInteractor(editProfileOutputBoundary);

        return new EditProfileController(editProfileInteractor);
    }
}
