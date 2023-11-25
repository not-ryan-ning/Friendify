package use_case.match;

import entity.User;

import java.util.ArrayList;

public class MatchInteractor implements MatchInputBoundary {
    final MatchUserDataAccessInterface matchUserDAO;
    final MatchOutputBoundary matchPresenter;
    public MatchInteractor(MatchUserDataAccessInterface matchingUserDataAccessInterface,
                           MatchOutputBoundary matchingOutputBoundary) {
        this.matchUserDAO = matchingUserDataAccessInterface;
        this.matchPresenter = matchingOutputBoundary;
    }

    @Override
    public void execute(User currentUser) {
        ArrayList<String> matches = matchUserDAO.match(currentUser);

        MatchOutputData matchingOutputData = new MatchOutputData(matches);
        matchPresenter.prepareSuccessView(matchingOutputData);
    }
}