package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.display_common_profile.DisplayCommonProfileViewModel;
import interface_adapter.display_friend_profile.DisplayFriendProfileViewModel;
import interface_adapter.display_profile.DisplayProfileController;
import interface_adapter.display_profile.DisplayProfilePresenter;
import interface_adapter.display_profile.DisplayProfileViewModel;
import interface_adapter.display_requests.DisplayRequestsController;
import interface_adapter.display_requests.DisplayRequestsPresenter;
import interface_adapter.display_requests.DisplayRequestsViewModel;
import interface_adapter.go_back.GoBackController;
import interface_adapter.go_back.GoBackPresenter;
import interface_adapter.go_back.GoBackViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.display_profile.DisplayProfileInputBoundary;
import use_case.display_profile.DisplayProfileInteractor;
import use_case.display_profile.DisplayProfileOutputBoundary;
import use_case.display_profile.DisplayProfileUserDataAccessInterface;
import use_case.display_requests.DisplayRequestsInputBoundary;
import use_case.display_requests.DisplayRequestsInteractor;
import use_case.display_requests.DisplayRequestsOutputBoundary;
import use_case.display_requests.DisplayRequestsUserDataAccessInterface;
import use_case.go_back.GoBackInputBoundary;
import use_case.go_back.GoBackInteractor;
import use_case.go_back.GoBackOutputBoundary;
import view.DisplayRequestsView;

import javax.swing.*;
import java.io.IOException;

public class DisplayRequestsUseCaseFactory {
    private DisplayRequestsUseCaseFactory() {}

    public static DisplayRequestsView create(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            DisplayRequestsViewModel displayRequestsViewModel,
            DisplayRequestsUserDataAccessInterface displayRequestsUserDataAccessObject,
            DisplayProfileViewModel displayProfileViewModel,
            DisplayCommonProfileViewModel displayCommonProfileViewModel,
            DisplayFriendProfileViewModel displayFriendProfileViewModel,
            DisplayProfileUserDataAccessInterface displayProfileUserDataAccessObject,
            GoBackViewModel goBackViewModel
            // AcceptRequestsViewModel acceptRequestsViewModel,
            // AcceptRequestsUserDataAccessInterface acceptRequestsuserDataAccessObject
    ) {
        try {
            DisplayRequestsController displayRequestsController = createDisplayRequestsUseCase(viewManagerModel, displayRequestsViewModel, displayRequestsUserDataAccessObject);
            DisplayProfileController displayProfileController = createDisplayProfileUseCase(viewManagerModel, displayProfileViewModel, displayCommonProfileViewModel, displayFriendProfileViewModel, displayProfileUserDataAccessObject);
            GoBackController goBackController = createGoBackUseCase(viewManagerModel, goBackViewModel, loggedInViewModel);
            // AcceptRequestsController acceptRequestsController = createAcceptRequestsUseCase(viewManagerModel, acceptRequestsViewModel, acceptRequestsuserDataAccessObject);

            return new DisplayRequestsView(displayRequestsViewModel, displayRequestsController, displayProfileController, displayProfileViewModel, loggedInViewModel, goBackController, goBackViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static DisplayRequestsController createDisplayRequestsUseCase(ViewManagerModel viewManagerModel, DisplayRequestsViewModel displayRequestsViewModel, DisplayRequestsUserDataAccessInterface displayRequestsUserDataAccessObject) throws IOException {
        DisplayRequestsOutputBoundary displayRequestsOutputBoundary = new DisplayRequestsPresenter(viewManagerModel, displayRequestsViewModel);
        DisplayRequestsInputBoundary displayRequestsInteractor = new DisplayRequestsInteractor(displayRequestsUserDataAccessObject, displayRequestsOutputBoundary);

        return new DisplayRequestsController(displayRequestsInteractor);
    }

    private static DisplayProfileController createDisplayProfileUseCase(ViewManagerModel viewManagerModel, DisplayProfileViewModel displayProfileViewModel, DisplayCommonProfileViewModel displayCommonProfileViewModel, DisplayFriendProfileViewModel displayFriendProfileViewModel, DisplayProfileUserDataAccessInterface displayProfileUserDataAccessObject) {
        DisplayProfileOutputBoundary displayProfileOutputBoundary = new DisplayProfilePresenter(displayFriendProfileViewModel, displayCommonProfileViewModel, viewManagerModel);
        DisplayProfileInputBoundary displayProfileInteractor = new DisplayProfileInteractor(displayProfileUserDataAccessObject, displayProfileOutputBoundary, displayProfileViewModel);

        return new DisplayProfileController(displayProfileInteractor);
    }
    private static GoBackController createGoBackUseCase(ViewManagerModel viewManagerModel, GoBackViewModel goBackViewModel, LoggedInViewModel loggedInViewModel) {
        GoBackOutputBoundary goBackOutputBoundary = new GoBackPresenter(viewManagerModel, goBackViewModel, loggedInViewModel);
        GoBackInputBoundary goBackInteractor = new GoBackInteractor(goBackOutputBoundary);

        return new GoBackController(goBackInteractor);
    }

    // need to create an AcceptRequestController
}
