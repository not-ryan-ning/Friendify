package interface_adapter.authorize;

import use_case.authorize.AuthorizeInputBoundary;

public class MockAuthorizeInteractor implements AuthorizeInputBoundary {

    private String currentState;

    public MockAuthorizeInteractor(){
        this.currentState = "";
    }
    @Override
    public void execute(String string) {
        this.currentState = "Success";
    }

    public String getState() {
        return currentState;
    }
}
