package interface_adapter.accept_request;

import use_case.accept_request.AcceptRequestOutputBoundary;
import use_case.accept_request.AcceptRequestOutputData;

public class AcceptRequestPresenter implements AcceptRequestOutputBoundary {
    private AcceptRequestViewModel viewModel;
    public AcceptRequestPresenter(AcceptRequestViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(AcceptRequestOutputData acceptRequestOutputData) {
        AcceptRequestState newState = new AcceptRequestState();
        newState.setRequests(acceptRequestOutputData.getRequests());
        viewModel.firePropertyChanged();
    }

}
