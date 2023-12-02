package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.go_back.GoBackController;
import interface_adapter.go_back.GoBackPresenter;
import interface_adapter.go_back.GoBackViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.match.MatchViewModel;
import interface_adapter.send_request.SendRequestController;
import interface_adapter.send_request.SendRequestPresenter;
import interface_adapter.send_request.SendRequestViewModel;
import use_case.go_back.GoBackInputBoundary;
import use_case.go_back.GoBackInteractor;
import use_case.go_back.GoBackOutputBoundary;
import use_case.send_request.*;
import view.MatchView;

import javax.swing.*;
import java.io.IOException;

public class MatchUseCaseFactory {

    private MatchUseCaseFactory(){}

    public static MatchView create(ViewManagerModel viewManagerModel,
                                   MatchViewModel matchViewModel,
                                   SendRequestViewModel sendRequestViewModel,
                                   SendRequestUserDataAccessInterface sendRequestUserDAO,
                                   GoBackViewModel goBackViewModel,
                                   LoggedInViewModel loggedInViewModel) {
        try {
            SendRequestController sendRequestController = createSendRequestUseCase(viewManagerModel, sendRequestViewModel, sendRequestUserDAO);
            GoBackController goBackController = createGoBackUseCase(viewManagerModel, goBackViewModel, loggedInViewModel);
            return new MatchView(matchViewModel, sendRequestViewModel, sendRequestController, goBackViewModel, goBackController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SendRequestController createSendRequestUseCase(ViewManagerModel viewManagerModel,
                                                                  SendRequestViewModel sendRequestViewModel,
                                                                  SendRequestUserDataAccessInterface sendRequestUserDAO) throws IOException {
        SendRequestOutputBoundary sendRequestOutputBoundary = new SendRequestPresenter(sendRequestViewModel,viewManagerModel);

        SendRequestInputBoundary sendRequestInteractor = new SendRequestInteractor(
                sendRequestUserDAO, sendRequestOutputBoundary);

        return new SendRequestController(sendRequestInteractor);
    }

    private static GoBackController createGoBackUseCase(ViewManagerModel viewManagerModel,
                                                        GoBackViewModel goBackViewModel,
                                                        LoggedInViewModel loggedInViewModel) throws IOException {
        GoBackOutputBoundary goBackOutputBoundary = new GoBackPresenter(viewManagerModel, goBackViewModel, loggedInViewModel);

        GoBackInputBoundary goBackInteractor = new GoBackInteractor(goBackOutputBoundary);
        return new GoBackController(goBackInteractor);
    }
}
