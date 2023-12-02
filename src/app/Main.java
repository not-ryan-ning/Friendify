package app;

import data_access.FilePlaylistsDataAccessObject;
import data_access.FileUserDataAccessObject;
import data_access.SpotifyAPIDataAccessObject;
import data_access.SpotifyAuthenticationDataAccessObject;
import entity.CommonPlaylistFactory;
import entity.CommonProfileFactory;
import entity.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.authorize.AuthorizeViewModel;
import interface_adapter.choose_playlist.ChoosePlaylistViewModel;
import interface_adapter.display_common_profile.DisplayCommonProfileViewModel;
import interface_adapter.display_friend_profile.DisplayFriendProfileViewModel;
import interface_adapter.display_friends.DisplayFriendsViewModel;
import interface_adapter.display_playlists.DisplayPlaylistsViewModel;
import interface_adapter.display_profile.DisplayProfileViewModel;
import interface_adapter.display_requests.DisplayRequestsViewModel;
import interface_adapter.edit_bio.EditBioViewModel;
import interface_adapter.edit_profile.EditProfileViewModel;
import interface_adapter.edit_spotify_handle.EditSpotifyHandleViewModel;
import interface_adapter.go_back.GoBackViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutViewModel;
import interface_adapter.match.MatchViewModel;
import interface_adapter.send_request.SendRequestViewModel;
import interface_adapter.signup.SignupViewModel;

import view.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        JFrame application = new JFrame("Friendify");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LogoutViewModel logoutViewModel = new LogoutViewModel();
        MatchViewModel matchViewModel = new MatchViewModel();
        SendRequestViewModel sendRequestViewModel = new SendRequestViewModel();
        GoBackViewModel goBackViewModel = new GoBackViewModel();
        EditSpotifyHandleViewModel editSpotifyHandleViewModel = new EditSpotifyHandleViewModel();
        EditProfileViewModel editProfileViewModel = new EditProfileViewModel();
        EditBioViewModel editBioViewModel = new EditBioViewModel();
        DisplayRequestsViewModel displayRequestsViewModel = new DisplayRequestsViewModel();
        DisplayProfileViewModel displayProfileViewModel = new DisplayProfileViewModel();
        DisplayPlaylistsViewModel displayPlaylistsViewModel = new DisplayPlaylistsViewModel();
        DisplayFriendsViewModel displayFriendsViewModel = new DisplayFriendsViewModel();
        DisplayFriendProfileViewModel displayFriendProfileViewModel = new DisplayFriendProfileViewModel();
        DisplayCommonProfileViewModel displayCommonProfileViewModel = new DisplayCommonProfileViewModel();
        ChoosePlaylistViewModel choosePlaylistViewModel = new ChoosePlaylistViewModel();
        AuthorizeViewModel authorizeViewModel = new AuthorizeViewModel();

        FileUserDataAccessObject userDataAccessObject;
        FileUserDataAccessObject displayRequestsUserDataAccessObject;
        FileUserDataAccessObject displayFriendsUserDataAccessObject;
        FileUserDataAccessObject matchUserDataAccessObject;
        FileUserDataAccessObject sendRequestUserDataAccessObject;
        FileUserDataAccessObject editBioUserDataAccessObject;
        SpotifyAPIDataAccessObject displayPlaylistsSpotifyAPIDataAccessObject;
        SpotifyAuthenticationDataAccessObject authorizeSpotifyAuthenticationDataAccessObject;
        FileUserDataAccessObject choosePlaylistUserDataAccessObject;
        FilePlaylistsDataAccessObject choosePlaylistPlaylistDataAccessObject;
        SpotifyAPIDataAccessObject choosePlaylistSpotifyAPIDataAccessObject;
        FileUserDataAccessObject editSpotifyHandleUserDataAccessObject;
        FileUserDataAccessObject displayProfileUserDataAccessObject;

        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv",
                    new CommonUserFactory(),
                    new CommonProfileFactory());

            displayRequestsUserDataAccessObject = new FileUserDataAccessObject("./users.csv",
                    new CommonUserFactory(),
                    new CommonProfileFactory());

            displayFriendsUserDataAccessObject = new FileUserDataAccessObject("./users.csv",
                    new CommonUserFactory(),
                    new CommonProfileFactory());

            matchUserDataAccessObject = new FileUserDataAccessObject("./users.csv",
                    new CommonUserFactory(),
                    new CommonProfileFactory());

            sendRequestUserDataAccessObject = new FileUserDataAccessObject("./users.csv",
                    new CommonUserFactory(),
                    new CommonProfileFactory());

            editBioUserDataAccessObject = new FileUserDataAccessObject("./users.csv",
                    new CommonUserFactory(),
                    new CommonProfileFactory());

            displayPlaylistsSpotifyAPIDataAccessObject = new SpotifyAPIDataAccessObject();

            authorizeSpotifyAuthenticationDataAccessObject = new SpotifyAuthenticationDataAccessObject();

            choosePlaylistUserDataAccessObject = new FileUserDataAccessObject("./users.csv",
                    new CommonUserFactory(),
                    new CommonProfileFactory());

            choosePlaylistPlaylistDataAccessObject = new FilePlaylistsDataAccessObject("./playlists.csv",
                    new CommonPlaylistFactory());

            choosePlaylistSpotifyAPIDataAccessObject = new SpotifyAPIDataAccessObject();

            editSpotifyHandleUserDataAccessObject = new FileUserDataAccessObject("./users.csv",
                    new CommonUserFactory(),
                    new CommonProfileFactory());

            displayProfileUserDataAccessObject = new FileUserDataAccessObject("./users.csv",
                    new CommonUserFactory(),
                    new CommonProfileFactory());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        LoggedInView loggedInView = LoginUseCaseFactory.create(viewManagerModel,
                loggedInViewModel,
                loginViewModel,
                logoutViewModel,
                displayRequestsViewModel,
                displayRequestsUserDataAccessObject,
                displayFriendsViewModel,
                displayFriendsUserDataAccessObject,
                matchViewModel,
                matchUserDataAccessObject,
                editProfileViewModel);
        views.add(loggedInView, loggedInView.viewName);

        MatchView matchView = MatchUseCaseFactory.create(viewManagerModel,
                matchViewModel,
                sendRequestViewModel,
                sendRequestUserDataAccessObject,
                goBackViewModel,
                loggedInViewModel);
        views.add(matchView, matchView.viewName);

        EditProfileView editProfileView = EditProfileUseCaseFactory.create(viewManagerModel,
                loggedInViewModel,
                editProfileViewModel,
                editBioViewModel,
                editBioUserDataAccessObject,
                displayPlaylistsViewModel,
                displayPlaylistsSpotifyAPIDataAccessObject,
                authorizeViewModel,
                authorizeSpotifyAuthenticationDataAccessObject,
                choosePlaylistViewModel,
                choosePlaylistUserDataAccessObject,
                choosePlaylistPlaylistDataAccessObject,
                choosePlaylistSpotifyAPIDataAccessObject,
                editSpotifyHandleViewModel,
                editSpotifyHandleUserDataAccessObject,
                goBackViewModel);
        views.add(editProfileView, editProfileView.viewName);

        DisplayRequestsView displayRequestsView = DisplayRequestsUseCaseFactory.create(viewManagerModel,
                loggedInViewModel,
                displayRequestsViewModel,
                displayRequestsUserDataAccessObject,
                displayProfileViewModel,
                displayCommonProfileViewModel,
                displayFriendProfileViewModel,
                displayProfileUserDataAccessObject,
                goBackViewModel);
        views.add(displayRequestsView);

        DisplayFriendsView displayFriendsView = DisplayFriendsUseCaseFactory.create(viewManagerModel,
                loggedInViewModel,
                displayFriendsViewModel,
                displayFriendsUserDataAccessObject,
                displayProfileViewModel,
                displayCommonProfileViewModel,
                displayFriendProfileViewModel,
                displayProfileUserDataAccessObject,
                goBackViewModel);
        views.add(displayFriendsView);

        DisplayCommonProfileView displayCommonProfileView = DisplayProfileUseCaseFactory.create(
                viewManagerModel,
                loggedInViewModel,
                displayCommonProfileViewModel,
                goBackViewModel);
        views.add(displayCommonProfileView);

        DisplayFriendProfileView displayFriendProfileView = DisplayProfileUseCaseFactory.create(viewManagerModel,
                loggedInViewModel,
                displayFriendProfileViewModel,
                goBackViewModel);
        views.add(displayFriendProfileView);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
