package use_case.matching;

import entity.MatchingStrategy;
import entity.Playlist;
import entity.User;

import java.util.ArrayList;

public class MatchingInteractor implements MatchingInputBoundary {
    final MatchingUserDataAccessInterface matchingUserDAO;
    final MatchingOutputBoundary matchingPresenter;
    public MatchingInteractor(MatchingUserDataAccessInterface matchingUserDataAccessInterface,
                                 MatchingOutputBoundary matchingOutputBoundary) {
        this.matchingUserDAO = matchingUserDataAccessInterface;
        this.matchingPresenter = matchingOutputBoundary;
    }

    @Override
    public void execute(MatchingInputData matchingInputData) {
        User currentUser = matchingUserDAO.get(matchingInputData.getCurrentUsername());
        ArrayList<String> matches = matchingUserDAO.match(currentUser);

        MatchingOutputData matchingOutputData = new MatchingOutputData(matches);
        matchingPresenter.prepareSuccessView(matchingOutputData);
    }
}