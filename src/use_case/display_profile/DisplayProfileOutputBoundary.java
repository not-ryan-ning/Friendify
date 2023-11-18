package use_case.display_profile;

public interface DisplayProfileOutputBoundary {
    void prepareSuccessViewFriends(DisplayProfileOutputData user);
    void prepareSuccessViewCommon(DisplayProfileOutputData user);
}
