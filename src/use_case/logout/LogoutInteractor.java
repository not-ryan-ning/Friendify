package use_case.logout;

public class LogoutInteractor implements LogoutInputBoundary {
    final LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutOutputBoundary logoutOutputBoundary) {
        this.logoutPresenter = logoutOutputBoundary;
    }

    /**
     * Calls the logout presenter's prepareSuccessView method to change views.
     */
    @Override
    public void execute() {
        logoutPresenter.prepareSuccessView();
    }
}

