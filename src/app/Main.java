package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.display_friends.DisplayFriendsViewModel;
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

import view.ViewManager;

import javax.swing.*;
import java.awt.*;

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
        DisplayProfile
    }
}
