package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.display_requests.DisplayRequestsController;
import interface_adapter.display_requests.DisplayRequestsPresenter;
import interface_adapter.display_requests.DisplayRequestsViewModel;
import use_case.display_requests.DisplayRequestsInputBoundary;
import use_case.display_requests.DisplayRequestsInteractor;
import use_case.display_requests.DisplayRequestsOutputBoundary;
import use_case.display_requests.DisplayRequestsUserDataAccessInterface;
import view.DisplayRequestsView;

import javax.swing.*;
import java.io.IOException;

public class DisplayRequestsUseCaseFactory {
    private DisplayRequestsUseCaseFactory() {}

    public static DisplayRequestsView create(
        ViewManagerModel viewManagerModel,
        DisplayRequestsViewModel displayRequestsViewModel,
        DisplayRequestsUserDataAccessInterface displayRequestsUserDataAccessObject
        // AcceptRequestsViewModel acceptRequestsViewModel,
        // AcceptRequestsUserDataAccessInterface acceptRequestsuserDataAccessObject
        ) {
        try {
            DisplayRequestsController displayRequestsController = createDisplayRequestsUseCase(viewManagerModel, displayRequestsViewModel, displayRequestsUserDataAccessObject);
            // AcceptRequestsController acceptRequestsController = createAcceptRequestsUseCase(viewManagerModel, acceptRequestsViewModel, acceptRequestsuserDataAccessObject);
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

    // need to create an AcceptRequestController
}
