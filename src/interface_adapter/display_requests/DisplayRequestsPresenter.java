package interface_adapter.display_requests;

import interface_adapter.ViewManagerModel;
import use_case.display_requests.DisplayRequestsOutputBoundary;
import use_case.display_requests.DisplayRequestsOutputData;

public class DisplayRequestsPresenter implements DisplayRequestsOutputBoundary {

    private final DisplayRequestsViewModel displayRequestsViewModel;
    private ViewManagerModel viewManagerModel;

    public DisplayRequestsPresenter(ViewManagerModel viewManagerModel, DisplayRequestsViewModel displayRequestsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.displayRequestsViewModel = displayRequestsViewModel;
    }

    @Override
    public void prepareSuccessView(DisplayRequestsOutputData requests) {
        DisplayRequestsState displayRequestsState = displayRequestsViewModel.getState();
        displayRequestsState.setRequests(requests.getRequests());
        displayRequestsViewModel.setState(displayRequestsState);
        displayRequestsViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(displayRequestsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
