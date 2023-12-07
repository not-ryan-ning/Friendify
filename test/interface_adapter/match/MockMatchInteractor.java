package interface_adapter.match;

import use_case.match.MatchInputBoundary;

public class MockMatchInteractor implements MatchInputBoundary {
    private String currentState;

    public MockMatchInteractor() {
        this.currentState = "";
    }

    public String getState() {
        return this.currentState;
    }

    @Override
    public void execute(String string) {
        this.currentState = "Success";
    }
}
