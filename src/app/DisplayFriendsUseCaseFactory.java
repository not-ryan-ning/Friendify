package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.display_friends.DisplayFriendsController;
import interface_adapter.display_friends.DisplayFriendsPresenter;
import interface_adapter.display_friends.DisplayFriendsViewModel;
import use_case.display_friends.DisplayFriendsInputBoundary;
import use_case.display_friends.DisplayFriendsInteractor;
import use_case.display_friends.DisplayFriendsOutputBoundary;
import use_case.display_friends.DisplayFriendsUserDataAccessInterface;
import view.DisplayFriendsView;

import javax.swing.*;
import java.io.IOException;

public class DisplayFriendsUseCaseFactory {
    private DisplayFriendsUseCaseFactory() {}

    public static DisplayFriendsView create(
            ViewManagerModel viewManagerModel,
            DisplayFriendsViewModel displayFriendsViewModel,
            DisplayFriendsUserDataAccessInterface displayFriendsUserDataAccessObject) {
        try {
            DisplayFriendsController displayFriendsController = createDisplayFriendsUseCase(viewManagerModel, displayFriendsViewModel, displayFriendsUserDataAccessObject);
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
}

