package use_case.edit_bio;

import data_access.edit_bio.MockEditBioUserDataAccessObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EditBioInteractorTest {
    private EditBioUserDataAccessInterface mockEditBioUserDAO;
    private EditBioOutputBoundary mockEditBioPresenter;

    @Before
    public void init() {
        this.mockEditBioUserDAO = new MockEditBioUserDataAccessObject();
        this.mockEditBioPresenter = new MockEditBioPresenter();
    }

    @Test
    public void testInitialization() {
        EditBioInteractor interactor = new EditBioInteractor(mockEditBioUserDAO,
                mockEditBioPresenter);

        assertNotNull(interactor);
    }

    @Test
    public void testExecuteSuccess() {
        EditBioInteractor interactor = new EditBioInteractor(mockEditBioUserDAO,
                mockEditBioPresenter);
        EditBioInputData inputData = new MockEditBioInputData("");

        interactor.execute("", inputData);

        assertEquals("Success", ((MockEditBioPresenter) mockEditBioPresenter).getState());
    }
}
