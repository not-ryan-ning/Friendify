package use_case.go_back;

public class MockGoBackPresenter implements GoBackOutputBoundary {

    private String currentState;

    public MockGoBackPresenter(){
        this.currentState = "";
    }
    @Override
    public void prepareSuccessView() {
        this.currentState = "Success";
    }

    public String getState() {
        return this.currentState;
    }
}
