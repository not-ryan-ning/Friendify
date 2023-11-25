package interface_adapters.matching;

import use_case.matching.MatchingOutputBoundary;
import use_case.matching.MatchingOutputData;

public class MatchingPresenter implements MatchingOutputBoundary {

    private final MatchingViewModel matchingViewModel;
    private ViewManagerModel viewManagerModel;

    public MatchingPresenter(MatchingViewModel matchingViewModel, ViewManagerModel viewManagerModel) {
        this.matchingViewModel = matchingViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(MatchingOutputData matches) {
        MatchingState matchingState = matchingViewModel.getState();
        matchingState.setMatches(matches);
        this.matchingViewModel.setState(matchingState);
        matchingViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(matchingViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
