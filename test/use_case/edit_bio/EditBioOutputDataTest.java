package use_case.edit_bio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditBioOutputDataTest {
    private EditBioOutputData outputData;

    @Before
    public void init() {
        this.outputData = new EditBioOutputData("bio");
    }

    @Test
    public void testGetNotBio() {
        assertEquals("bio", outputData.getNewBio());
    }
}
