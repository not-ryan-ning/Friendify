package use_case.authorize;

public class AuthorizeOutputData {
    private final String accessToken;

    public AuthorizeOutputData(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
