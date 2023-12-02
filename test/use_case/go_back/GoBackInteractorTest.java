package use_case.go_back;

import interface_adapter.ViewManagerModel;
import org.junit.Test;
import use_case.match.MatchInteractor;

import static org.junit.Assert.*;

public class GoBackInteractorTest {
    private GoBackInteractor goBackInteractor;
    private ViewManagerModel viewManagerModel;

    @Test
    public void testExecute() {
        goBackInteractor.execute();
        assertEquals("logged in", viewManagerModel.getActiveView());
    }


}