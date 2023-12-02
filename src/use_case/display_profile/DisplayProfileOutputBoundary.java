package use_case.display_profile;

public interface DisplayProfileOutputBoundary {
    void prepareSuccessViewFriends(DisplayProfileOutputData friendUserInfo);
    void prepareSuccessViewCommon(DisplayProfileOutputData commonUserInfo);
}
