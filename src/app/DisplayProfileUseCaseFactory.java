package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.display_common_profile.DisplayCommonProfileViewModel;
import interface_adapter.display_friend_profile.DisplayFriendProfileViewModel;

import interface_adapter.go_back.GoBackController;
import interface_adapter.go_back.GoBackPresenter;
import interface_adapter.go_back.GoBackViewModel;
import interface_adapter.logged_in.LoggedInViewModel;

import use_case.go_back.GoBackInputBoundary;
import use_case.go_back.GoBackInteractor;
import use_case.go_back.GoBackOutputBoundary;
import view.DisplayCommonProfileView;
import view.DisplayFriendProfileView;

import javax.swing.*;
import java.io.IOException;

public class DisplayProfileUseCaseFactory {
    private DisplayProfileUseCaseFactory() {}

    public static DisplayFriendProfileView create(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            DisplayFriendProfileViewModel displayFriendProfileViewModel,
            GoBackViewModel goBackViewModel
    ) {
        try {
            GoBackController goBackController = createGoBackUseCase(viewManagerModel, goBackViewModel, loggedInViewModel);

            return new DisplayFriendProfileView(displayFriendProfileViewModel, goBackController, goBackViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;

    }

    public static DisplayCommonProfileView create(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            DisplayCommonProfileViewModel displayCommonProfileViewModel,
            GoBackViewModel goBackViewModel
    ) {
        try {
            GoBackController goBackController = createGoBackUseCase(viewManagerModel, goBackViewModel, loggedInViewModel);

            return new DisplayCommonProfileView(displayCommonProfileViewModel, goBackController, goBackViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;

    }

    private static GoBackController createGoBackUseCase(ViewManagerModel viewManagerModel, GoBackViewModel goBackViewModel, LoggedInViewModel loggedInViewModel) throws IOException {
        GoBackOutputBoundary goBackOutputBoundary = new GoBackPresenter(viewManagerModel, goBackViewModel, loggedInViewModel);
        GoBackInputBoundary goBackInteractor = new GoBackInteractor(goBackOutputBoundary);

        return new GoBackController(goBackInteractor);
    }
}
