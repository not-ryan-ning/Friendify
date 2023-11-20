package use_case.matching;

public class MatchingInputData {
    final private String currentUsername;

    public MatchingInputData(String currentUsername) {
        this.currentUsername = currentUsername;
    }
    String getCurrentUsername() {
        return currentUsername;
    }
}