package interface_adapter.authorize;

import use_case.authorize.AuthorizeInputBoundary;

/**
 * Initiates authorization-related operations
 */
public class AuthorizeController {
    final AuthorizeInputBoundary authorizeInteractor;
    public AuthorizeController(AuthorizeInputBoundary authorizeInteractor) {
        this.authorizeInteractor = authorizeInteractor;
    }

    public void execute() {
        authorizeInteractor.execute();
    }
}
