package use_case.send_request;

public interface SendRequestOutputBoundary {
    void prepareSuccessView(SendRequestOutputData user);
    void prepareFailView(String error);
}
