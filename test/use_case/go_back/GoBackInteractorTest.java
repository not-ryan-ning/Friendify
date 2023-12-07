package use_case.go_back;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GoBackInteractorTest {

    private GoBackOutputBoundary mockGoBackPresenter;

    @Before
    public void init() {
        this.mockGoBackPresenter = new MockGoBackPresenter();
    }

    @Test
    public void testInitialization() {
        GoBackInteractor interactor = new GoBackInteractor(mockGoBackPresenter);

        assertNotNull(interactor);
    }

    @Test
    public void testExecuteSuccess() {
        GoBackInteractor interactor = new GoBackInteractor(mockGoBackPresenter);

        interactor.execute();

        assertEquals("Success", ((MockGoBackPresenter) mockGoBackPresenter).getState());
    }
}
