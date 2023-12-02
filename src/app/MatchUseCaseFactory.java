package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.match.MatchViewModel;
import interface_adapter.send_request.SendRequestController;
import interface_adapter.send_request.SendRequestPresenter;
import interface_adapter.send_request.SendRequestViewModel;
import use_case.send_request.*;
import view.MatchView;

import javax.swing.*;
import java.io.IOException;

public class MatchUseCaseFactory {

    private MatchUseCaseFactory(){}

    public static MatchView create(ViewManagerModel viewManagerModel,
                                   MatchViewModel matchViewModel,
                                   SendRequestViewModel sendRequestViewModel,
                                   SendRequestUserDataAccessInterface sendRequestUserDAO) {
        try {
            SendRequestController sendRequestController = createSendRequestUseCase(viewManagerModel, sendRequestViewModel, sendRequestUserDAO);
            return new MatchView(matchViewModel, sendRequestViewModel, sendRequestController);
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
}
