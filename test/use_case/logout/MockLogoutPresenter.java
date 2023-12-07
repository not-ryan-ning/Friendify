package use_case.logout;

public class MockLogoutPresenter implements LogoutOutputBoundary {
    private String currentState;

    public MockLogoutPresenter() {
        this.currentState = "";
    }
    @Override
    public void prepareSuccessView() {
        this.currentState = "Success";
    }

    public String getState() {
        return currentState;
    }
}
