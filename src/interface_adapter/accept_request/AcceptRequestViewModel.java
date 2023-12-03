package interface_adapter.accept_request;

public class AcceptRequestViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Display Requests View";
    public static final String VIEW_BUTTON_LABEL = "View Profile";
    public static final String ACCEPT_BUTTON_LABEL = "Accept Request";
    private AcceptRequestState state = new AcceptRequestState();
    public AcceptRequestViewModel() {
        super("show requests");
    }
}
