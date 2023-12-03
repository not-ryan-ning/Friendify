package interface_adapter.authorize;

import interface_adapter.ViewManagerModel;
import use_case.authorize.AuthorizeOutputBoundary;
import use_case.authorize.AuthorizeOutputData;

/**
 * Handles authorization-related outputs and updating the corresponding view models.
 */
public class AuthorizePresenter implements AuthorizeOutputBoundary {

    private final AuthorizeViewModel authorizeViewModel;
    private ViewManagerModel viewManagerModel;

    public AuthorizePresenter(ViewManagerModel viewManagerModel,
                              AuthorizeViewModel authorizeViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.authorizeViewModel = authorizeViewModel;
    }

    /**
     * Prepares and updates the success view based on the authorization output data.
     *
     * @param response The authorization output data containing the access token.
     */
    @Override
    public void prepareSuccessView(AuthorizeOutputData response) {
        AuthorizeState authorizeState = authorizeViewModel.getState();
        authorizeState.setAccessToken(response.getAccessToken());
        this.authorizeViewModel.setState(authorizeState);
        this.authorizeViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(authorizeViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares and handles the view in case of a failed authorization attempt.
     *
     * @param error The error message indicating the reason for the authorization failure.
     */
    @Override
    public void prepareFailView(String error) {
        System.out.println(error); // still need more implementation
    }
}
