package use_case.match;

import data_access.match.MockMatchUserDataAccessObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MatchInteractorTest {
    private MatchUserDataAccessInterface mockMatchUserDAO;
    private MatchOutputBoundary mockMatchPresenter;

    @Before
    public void init() {
        this.mockMatchUserDAO = new MockMatchUserDataAccessObject();
        this.mockMatchPresenter = new MockMatchPresenter();
    }

    @Test
    public void testInitialization() {
        MatchInteractor interactor = new MatchInteractor(mockMatchUserDAO,
                mockMatchPresenter);

        assertNotNull(interactor);
    }

    @Test
    public void testExecuteSuccess() {
        MatchInteractor interactor = new MatchInteractor(mockMatchUserDAO,
                mockMatchPresenter);

        interactor.execute("");

        assertEquals("Success", ((MockMatchPresenter) mockMatchPresenter).getState());
    }
}
