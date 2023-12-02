package interface_adapter.authorize;

import use_case.authorize.AuthorizeInputBoundary;

public class AuthorizeController {
    final AuthorizeInputBoundary authorizeInteractor;

    public AuthorizeController(AuthorizeInputBoundary authorizeInteractor) {
        this.authorizeInteractor = authorizeInteractor;
    }

    public void execute(String authorizationLink) {
        authorizeInteractor.execute(authorizationLink);
    }

}
