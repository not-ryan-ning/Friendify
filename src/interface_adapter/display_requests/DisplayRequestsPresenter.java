package interface_adapter.display_requests;

import use_case.display_requests.DisplayRequestsOutputBoundary;
import use_case.display_requests.DisplayRequestsOutputData;

public class DisplayRequestsPresenter implements DisplayRequestsOutputBoundary {

    private final DisplayRequestsViewModel displayRequestsViewModel;
    private ViewManagerModel viewManagerModel;

    public DisplayRequestsPresenter(DisplayRequestsViewModel displayRequestsViewModel, ViewManagerModel viewManagerModel) {
        this.displayRequestsViewModel = displayRequestsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DisplayRequestsOutputData requests) {
        // On success, switch to requests of users view
        DisplayRequestsState displayRequestsState = displayRequestsViewModel.getState();
        displayRequestsViewModel.setState(displayRequestsState);
        displayRequestsViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(displayRequestsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
