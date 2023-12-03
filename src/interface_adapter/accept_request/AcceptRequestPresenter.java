package interface_adapter.accept_request;

import interface_adapter.ViewManagerModel;
import use_case.accept_request.AcceptRequestOutputBoundary;
import use_case.accept_request.AcceptRequestOutputData;

public class AcceptRequestPresenter implements AcceptRequestOutputBoundary {
    private AcceptRequestViewModel acceptRequestViewModel;
    private ViewManagerModel viewManagerModel;
    public AcceptRequestPresenter(ViewManagerModel viewManagerModel,
                                  AcceptRequestViewModel acceptRequestViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.acceptRequestViewModel = acceptRequestViewModel;
    }

    /**
     * Updates a new state with the updated requests stored in acceptRequestOutputData
     * @param acceptRequestOutputData The OutputData object containing the updated requests for the current user.
     */
    @Override
    public void prepareSuccessView(AcceptRequestOutputData acceptRequestOutputData) {
        AcceptRequestState acceptRequestState = acceptRequestViewModel.getState();
        acceptRequestState.setRequests(acceptRequestOutputData.getRequests());
        acceptRequestState.setAcceptedUsername(acceptRequestOutputData.);
        acceptRequestViewModel.setState(acceptRequestState);
        acceptRequestViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(acceptRequestViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
