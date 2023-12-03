package use_case.accept_request;

public interface AcceptRequestOutputBoundary {
    void prepareSuccessView();
    void prepareFailView(String error);
}
