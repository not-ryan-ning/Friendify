package interface_adapter.accept_request;

import use_case.accept_request.AcceptRequestInputData;

public class MockAcceptRequestInputData extends AcceptRequestInputData {
    public MockAcceptRequestInputData(String currentUsername) {
        super(currentUsername);
    }
}
