package use_case.go_back;

import interface_adapter.ViewManagerModel;
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
        goBackInteractor = ...
    }
    @Test
    public void testExecute() {
        goBackInteractor.execute();
        assertEquals("logged in", viewManagerModel.getActiveView());
    }


}