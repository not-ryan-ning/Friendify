package use_case.accept_request;

import entity.User;

public interface AcceptRequestInputBoundary {
    void execute(AcceptRequestInputData acceptRequestInputData);
}
