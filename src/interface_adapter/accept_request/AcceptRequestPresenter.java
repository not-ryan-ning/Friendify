package interface_adapter.accept_request;

import use_case.accept_request.AcceptRequestOutputBoundary;
import use_case.accept_request.AcceptRequestOutputData;

public class AcceptRequestPresenter implements AcceptRequestOutputBoundary {
    private AcceptRequestViewModel viewModel;
    public AcceptRequestPresenter(AcceptRequestViewModel viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Updates a new state with the updated requests stored in acceptRequestOutputData
     * @param acceptRequestOutputData The OutputData object containing the updated requests for the current user.
     */
    @Override
    public void prepareSuccessView(AcceptRequestOutputData acceptRequestOutputData) {
        AcceptRequestState newState = new AcceptRequestState();
        newState.setRequests(acceptRequestOutputData.getRequests());
        viewModel.firePropertyChanged();
    }

}
