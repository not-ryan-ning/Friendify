package interface_adapter.send_request;

import interface_adapter.ViewManagerModel;
import use_case.send_request.SendRequestOutputBoundary;
import use_case.send_request.SendRequestOutputData;

/**
 * Prepares and updates view for corresponding operation.
 */
public class SendRequestPresenter implements SendRequestOutputBoundary {

    private final SendRequestViewModel sendRequestViewModel;
    private final ViewManagerModel viewManagerModel;

    public SendRequestPresenter(SendRequestViewModel sendRequestViewModel,
                                ViewManagerModel viewManagerModel) {
        this.sendRequestViewModel = sendRequestViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(SendRequestOutputData response) {
        SendRequestState sendRequestState = sendRequestViewModel.getState();
        sendRequestState.setReceiverUsername(response.getReceiverUsername());
        this.sendRequestViewModel.setState(sendRequestState);
        sendRequestViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(sendRequestViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SendRequestState sendRequestState = sendRequestViewModel.getState();
        sendRequestState.setRequestError(error);
        sendRequestViewModel.firePropertyChanged();
    }
}