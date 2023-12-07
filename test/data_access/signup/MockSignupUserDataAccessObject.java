package data_access.signup;

import entity.User;
import use_case.signup.SignupUserDataAccessInterface;

public class MockSignupUserDataAccessObject implements SignupUserDataAccessInterface {
    @Override
    public boolean existsByName(String identifier) {
        return !identifier.isEmpty();
    }

    @Override
    public void save(User user) {

    }
}
