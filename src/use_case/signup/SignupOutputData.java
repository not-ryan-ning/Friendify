package use_case.signup;

public class SignupOutputData {

    private final String username;
    private boolean useCaseSuccess;

    public SignupOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseSuccess = useCaseSuccess;
    }

    public String getUsername() {
        return username;
    }

    public boolean getUseCaseSuccess(){
        return useCaseSuccess;
    }

}
