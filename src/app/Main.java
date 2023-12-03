package app;

import data_access.FilePlaylistsDataAccessObject;
import data_access.FileUserDataAccessObject;
import data_access.SpotifyAPIDataAccessObject;
import data_access.SpotifyAuthenticationDataAccessObject;
import entity.CommonPlaylistFactory;
import entity.CommonProfileFactory;
import entity.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.accept_request.AcceptRequestViewModel;
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
        application.setSize(500, 300);


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
        AcceptRequestViewModel acceptRequestViewModel = new AcceptRequestViewModel();

        FileUserDataAccessObject userDataAccessObject;
        FilePlaylistsDataAccessObject filePlaylistsDataAccessObject;
        SpotifyAPIDataAccessObject spotifyAPIDataAccessObject;
        SpotifyAuthenticationDataAccessObject spotifyAuthenticationDataAccessObject;

        try {
            filePlaylistsDataAccessObject = new FilePlaylistsDataAccessObject("./playlists.csv",
                    new CommonPlaylistFactory());

            userDataAccessObject = new FileUserDataAccessObject("./users.csv",
                    new CommonUserFactory(),
                    new CommonPlaylistFactory(),
                    new CommonProfileFactory(),
                    filePlaylistsDataAccessObject);

            spotifyAPIDataAccessObject = new SpotifyAPIDataAccessObject();

            spotifyAuthenticationDataAccessObject = new SpotifyAuthenticationDataAccessObject();
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
                userDataAccessObject,
                displayFriendsViewModel,
                userDataAccessObject,
                matchViewModel,
                userDataAccessObject,
                editProfileViewModel);
        views.add(loggedInView, loggedInView.viewName);

        MatchView matchView = MatchUseCaseFactory.create(viewManagerModel,
                matchViewModel,
                sendRequestViewModel,
                userDataAccessObject,
                goBackViewModel,
                loggedInViewModel);
        views.add(matchView, matchView.viewName);

        EditProfileView editProfileView = EditProfileUseCaseFactory.create(viewManagerModel,
                loggedInViewModel,
                editProfileViewModel,
                editBioViewModel,
                userDataAccessObject,
                displayPlaylistsViewModel,
                spotifyAPIDataAccessObject,
                authorizeViewModel,
                spotifyAuthenticationDataAccessObject,
                choosePlaylistViewModel,
                userDataAccessObject,
                filePlaylistsDataAccessObject,
                spotifyAPIDataAccessObject,
                editSpotifyHandleViewModel,
                userDataAccessObject,
                goBackViewModel);
        views.add(editProfileView, editProfileView.viewName);

        DisplayRequestsView displayRequestsView = DisplayRequestsUseCaseFactory.create(viewManagerModel,
                loggedInViewModel,
                displayRequestsViewModel,
                userDataAccessObject,
                displayProfileViewModel,
                displayCommonProfileViewModel,
                displayFriendProfileViewModel,
                userDataAccessObject,
                goBackViewModel,
                acceptRequestViewModel,
                userDataAccessObject);
        views.add(displayRequestsView, displayRequestsView.viewname);

        DisplayFriendsView displayFriendsView = DisplayFriendsUseCaseFactory.create(viewManagerModel,
                loggedInViewModel,
                displayFriendsViewModel,
                userDataAccessObject,
                displayProfileViewModel,
                displayCommonProfileViewModel,
                displayFriendProfileViewModel,
                userDataAccessObject,
                goBackViewModel);
        views.add(displayFriendsView, displayFriendsView.viewname);

        DisplayCommonProfileView displayCommonProfileView = DisplayProfileUseCaseFactory.create(
                viewManagerModel,
                loggedInViewModel,
                displayCommonProfileViewModel,
                goBackViewModel);
        views.add(displayCommonProfileView, displayCommonProfileView.viewName);

        DisplayFriendProfileView displayFriendProfileView = DisplayProfileUseCaseFactory.create(viewManagerModel,
                loggedInViewModel,
                displayFriendProfileViewModel,
                goBackViewModel);
        views.add(displayFriendProfileView, displayFriendProfileView.viewName);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setSize(800, 600);
        application.setVisible(true);
    }
}