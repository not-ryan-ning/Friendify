package use_case.logout;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LogoutInteractorTest {

    private LogoutOutputBoundary mockLogoutPresenter;

    @Before
    public void init() {
        this.mockLogoutPresenter = new MockLogoutPresenter();
    }

    @Test
    public void testInitialization() {
        LogoutInteractor interactor = new LogoutInteractor(mockLogoutPresenter);

        assertNotNull(interactor);
    }

    @Test
    public void testExecuteSuccess() {
        LogoutInteractor interactor = new LogoutInteractor(mockLogoutPresenter);

        interactor.execute();

        assertEquals("Success", ((MockLogoutPresenter) mockLogoutPresenter).getState());
    }
}
