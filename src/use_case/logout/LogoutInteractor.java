package use_case.logout;

public class LogoutInteractor implements LogoutInputBoundary {
    final LogoutUserDataAccessInterface userDataAccessObject;
    final LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                           LogoutOutputBoundary logoutOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.logoutPresenter = logoutOutputBoundary;
    }
    @Override
    public void execute() {
       // String loggedoutUser = userDataAccessObject.get(loginInputData.getUsername());
        LogoutOutputData logoutOutputData = new LogoutOutputData();
        logoutPresenter.prepareSuccessView(logoutOutputData);
    }
}

