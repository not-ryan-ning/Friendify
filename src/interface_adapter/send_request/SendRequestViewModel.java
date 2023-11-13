package interface_adapter.send_request;

import interface_adapter.ViewModel;

public class SendRequestViewModel extends ViewModel {
    private SendRequestState sendRequestState = new SendRequestState();
    public SendRequestViewModel() {
        super("send request");
    }

}
