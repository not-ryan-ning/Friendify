package interface_adapter.send_request;

import interface_adapter.ViewManagerModel;
import use_case.send_request.SendRequestOutputBoundary;
import use_case.send_request.SendRequestOutputData;

public class SendRequestPresenter implements SendRequestOutputBoundary {
    private final SendRequestViewModel sendRequestViewModel;
    private ViewManagerModel viewManagerModel;

    public SendRequestPresenter(SendRequestViewModel sendRequestViewModel, ViewManagerModel viewManagerModel) {
        this.sendRequestViewModel = sendRequestViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    // Want pop-up messages for success and fail
    @Override
    public void prepareSuccessView(SendRequestOutputData response) {
        SendRequestState sendRequestState = sendRequestViewModel.getState();
        sendRequestState.setRequestSent(response.requestSent());
        this.sendRequestViewModel.setState(sendRequestState);
        sendRequestViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(sendRequestViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SendRequestState sendRequestState = sendRequestViewModel.getState();
        sendRequestState.setFriendError(error);
        sendRequestViewModel.firePropertyChanged();
    }
}
