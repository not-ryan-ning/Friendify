package interface_adapter.authorize;

import use_case.authorize.AuthorizeInputBoundary;

public class AuthorizeController {
    final AuthorizeInputBoundary authorizeInteractor;

    /**
     * The AuthorizeController class is responsible for handling authorization-related operations.
     *
     * @param authorizeInteractor
     */
    public AuthorizeController(AuthorizeInputBoundary authorizeInteractor) {
        this.authorizeInteractor = authorizeInteractor;
    }

    public void execute() {
        authorizeInteractor.execute();
    }

}
