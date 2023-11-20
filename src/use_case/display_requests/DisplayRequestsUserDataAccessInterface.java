package use_case.display_requests;

import entity.User;
public interface DisplayRequestsUserDataAccessInterface {
    User get(String username);
}
