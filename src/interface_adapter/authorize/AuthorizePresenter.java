package interface_adapter.authorize;

import interface_adapter.ViewManagerModel;
import use_case.authorize.AuthorizeOutputBoundary;
import use_case.authorize.AuthorizeOutputData;

public class AuthorizePresenter implements AuthorizeOutputBoundary {

    private final AuthorizeViewModel authorizeViewModel;
    private ViewManagerModel viewManagerModel;

    public AuthorizePresenter(ViewManagerModel viewManagerModel,
                              AuthorizeViewModel authorizeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.authorizeViewModel = authorizeViewModel;
    }

    @Override
    public void prepareSuccessView(AuthorizeOutputData response) {
        AuthorizeState authorizeState = authorizeViewModel.getState();
        authorizeState.setAccessToken(response.getAccessToken());
        this.authorizeViewModel.setState(authorizeState);
        this.authorizeViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(authorizeViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        System.out.println(error); // still need more implementation
    }
}
