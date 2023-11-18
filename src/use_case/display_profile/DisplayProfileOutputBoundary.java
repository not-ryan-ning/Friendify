package use_case.display_profile;

public interface DisplayProfileOutputBoundary {
    void prepareSuccessView(DisplayProfileOutputData user);
    void prepareFailView(String error);
}
