package use_case.match;

import entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public class MatchInteractor implements MatchInputBoundary {
    final MatchUserDataAccessInterface matchUserDAO;
    final MatchOutputBoundary matchPresenter;
    public MatchInteractor(MatchUserDataAccessInterface matchingUserDataAccessInterface,
                           MatchOutputBoundary matchingOutputBoundary) {
        this.matchUserDAO = matchingUserDataAccessInterface;
        this.matchPresenter = matchingOutputBoundary;
    }

    @Override
    public void execute(String currentUsername) {
        User currentUser = matchUserDAO.get(currentUsername);
        HashMap<String, Double> matches = matchUserDAO.getMatches(currentUser);

        MatchOutputData matchingOutputData = new MatchOutputData(matches);
        matchPresenter.prepareSuccessView(matchingOutputData);
    }
}