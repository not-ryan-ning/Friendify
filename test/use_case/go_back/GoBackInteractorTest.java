package use_case.go_back;

import interface_adapter.ViewManagerModel;
import interface_adapter.go_back.GoBackPresenter;
import interface_adapter.go_back.GoBackViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.match.MatchInteractor;

import static org.junit.Assert.*;

public class GoBackInteractorTest {
    private GoBackInteractor goBackInteractor;
    private ViewManagerModel viewManagerModel;

    @BeforeEach
    public void setUp() {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        goBackInteractor = new GoBackInteractor(new GoBackPresenter(viewManagerModel, new GoBackViewModel(), new LoggedInViewModel()));
    }
    @Test
    public void testExecute() {
        goBackInteractor.execute();
        assertEquals("logged in", viewManagerModel.getActiveView());
    }


}