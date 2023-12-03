package interface_adapter.accept_request;

import interface_adapter.ViewManagerModel;
import use_case.accept_request.AcceptRequestOutputBoundary;

public class AcceptRequestPresenter implements AcceptRequestOutputBoundary {
    private AcceptRequestViewModel acceptRequestViewModel;
    private ViewManagerModel viewManagerModel;
    public AcceptRequestPresenter(ViewManagerModel viewManagerModel,
                                  AcceptRequestViewModel acceptRequestViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.acceptRequestViewModel = acceptRequestViewModel;
    }

    @Override
    public void prepareSuccessView() {
        acceptRequestViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(acceptRequestViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        AcceptRequestState acceptRequestState = acceptRequestViewModel.getState();
        acceptRequestState.setAcceptError(error);
        acceptRequestViewModel.firePropertyChanged();
    }
}
