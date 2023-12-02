package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.display_common_profile.DisplayCommonProfileViewModel;
import interface_adapter.display_friend_profile.DisplayFriendProfileViewModel;
import interface_adapter.display_friends.DisplayFriendsController;
import interface_adapter.display_friends.DisplayFriendsPresenter;
import interface_adapter.display_friends.DisplayFriendsViewModel;
import interface_adapter.display_profile.DisplayProfileController;
import interface_adapter.display_profile.DisplayProfilePresenter;
import interface_adapter.display_profile.DisplayProfileViewModel;
import interface_adapter.go_back.GoBackController;
import interface_adapter.go_back.GoBackPresenter;
import interface_adapter.go_back.GoBackViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.display_friends.DisplayFriendsInputBoundary;
import use_case.display_friends.DisplayFriendsInteractor;
import use_case.display_friends.DisplayFriendsOutputBoundary;
import use_case.display_friends.DisplayFriendsUserDataAccessInterface;
import use_case.display_profile.DisplayProfileInputBoundary;
import use_case.display_profile.DisplayProfileInteractor;
import use_case.display_profile.DisplayProfileOutputBoundary;
import use_case.display_profile.DisplayProfileUserDataAccessInterface;
import use_case.go_back.GoBackInputBoundary;
import use_case.go_back.GoBackInteractor;
import use_case.go_back.GoBackOutputBoundary;
import view.DisplayFriendsView;

import javax.swing.*;
import java.io.IOException;

public class DisplayFriendsUseCaseFactory {
    private DisplayFriendsUseCaseFactory() {}

    public static DisplayFriendsView create(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            DisplayFriendsViewModel displayFriendsViewModel,
            DisplayFriendsUserDataAccessInterface displayFriendsUserDataAccessObject,
            DisplayProfileViewModel displayProfileViewModel,
            DisplayCommonProfileViewModel displayCommonProfileViewModel,
            DisplayFriendProfileViewModel displayFriendProfileViewModel,
            DisplayProfileUserDataAccessInterface displayProfileUserDataAccessObject,
            GoBackViewModel goBackViewModel
    ) {
        try {
            DisplayFriendsController displayFriendsController = createDisplayFriendsUseCase(viewManagerModel, displayFriendsViewModel, displayFriendsUserDataAccessObject);
            DisplayProfileController displayProfileController = createDisplayProfileUseCase(viewManagerModel, displayProfileViewModel, displayCommonProfileViewModel, displayFriendProfileViewModel, displayProfileUserDataAccessObject);
            GoBackController goBackController = createGoBackUseCase(viewManagerModel, goBackViewModel, loggedInViewModel);

            return new DisplayFriendsView(displayFriendsController, displayFriendsViewModel, displayProfileController, displayProfileViewModel, loggedInViewModel, goBackController, goBackViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static DisplayFriendsController createDisplayFriendsUseCase(ViewManagerModel viewManagerModel, DisplayFriendsViewModel displayFriendsViewModel, DisplayFriendsUserDataAccessInterface displayFriendsUserDataAccessObject) throws IOException {
        DisplayFriendsOutputBoundary displayFriendsOutputBoundary = new DisplayFriendsPresenter(viewManagerModel, displayFriendsViewModel);
        DisplayFriendsInputBoundary displayFriendsInteractor = new DisplayFriendsInteractor(displayFriendsUserDataAccessObject, displayFriendsOutputBoundary);

        return new DisplayFriendsController(displayFriendsInteractor);
    }

    private static DisplayProfileController createDisplayProfileUseCase(ViewManagerModel viewManagerModel, DisplayProfileViewModel displayProfileViewModel, DisplayCommonProfileViewModel displayCommonProfileViewModel, DisplayFriendProfileViewModel displayFriendProfileViewModel, DisplayProfileUserDataAccessInterface displayProfileUserDataAccessObject) throws IOException {
        DisplayProfileOutputBoundary displayProfileOutputBoundary = new DisplayProfilePresenter(displayFriendProfileViewModel, displayCommonProfileViewModel, viewManagerModel);
        DisplayProfileInputBoundary displayProfileInteractor = new DisplayProfileInteractor(displayProfileUserDataAccessObject, displayProfileOutputBoundary, displayProfileViewModel);

        return new DisplayProfileController(displayProfileInteractor);
    }
    private static GoBackController createGoBackUseCase(ViewManagerModel viewManagerModel, GoBackViewModel goBackViewModel, LoggedInViewModel loggedInViewModel) throws IOException {
        GoBackOutputBoundary goBackOutputBoundary = new GoBackPresenter(viewManagerModel, goBackViewModel, loggedInViewModel);
        GoBackInputBoundary goBackInteractor = new GoBackInteractor(goBackOutputBoundary);

        return new GoBackController(goBackInteractor);
    }
}