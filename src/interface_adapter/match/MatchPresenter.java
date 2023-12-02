package interface_adapter.match;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.match.MatchOutputBoundary;
import use_case.match.MatchOutputData;

public class MatchPresenter implements MatchOutputBoundary {
    private final MatchViewModel matchViewModel;
    private ViewManagerModel viewManagerModel;

    public MatchPresenter(LoggedInViewModel loggedInViewModel,
                          ViewManagerModel viewManagerModel,
                          MatchViewModel matchViewModel) {

        this.viewManagerModel = viewManagerModel;
        this.matchViewModel = matchViewModel;
    }

    @Override
    public void prepareSuccessView(MatchOutputData response) {
        MatchState matchState = matchViewModel.getState();
        matchState.setTopSimilarUsers(response.getTopSimilarUsers());
        matchViewModel.setState(matchState);
        matchViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(matchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
