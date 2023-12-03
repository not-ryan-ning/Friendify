package use_case.accept_request;

public class AcceptRequestInteractor {
    final AcceptRequestFileUserDataAccessInterface acceptRequestFileUserDAO;
    final AcceptRequestOutputBoundary acceptRequestPresenter;

    public AcceptRequestInteractor(AcceptRequestFileUserDataAccessInterface acceptRequestFileUserDataAccessInterface,
                                   AcceptRequestOutputBoundary acceptRequestOutputBoundary) {
        this.acceptRequestFileUserDAO = acceptRequestFileUserDataAccessInterface;
        this.acceptRequestPresenter = acceptRequestOutputBoundary;
    }
}
