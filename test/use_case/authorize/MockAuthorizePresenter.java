package use_case.authorize;

public class MockAuthorizePresenter implements AuthorizeOutputBoundary {
    private String currentState;

    public MockAuthorizePresenter() {
        this.currentState = "";
    }

    public String getState() {
        return this.currentState;
    }
    @Override
    public void prepareSuccessView(AuthorizeOutputData accessToken) {
        String check = accessToken.getAccessToken();
        this.currentState = check;

    }

    @Override
    public void prepareFailView(String errorMessage) {
        this.currentState = "Failure";
    }
}
