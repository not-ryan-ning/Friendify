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
    @Override
    public void prepareSuccessView(SendRequestOutputData response) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
