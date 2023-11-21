package use_case.authorize;

public interface AuthorizeOutputBoundary {
    void prepareSuccessView(AuthorizeOutputData accessToken);

    void prepareFailView(String errorMessage);
}
