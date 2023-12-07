package use_case.signup;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SignupOutputDataTest {
    private SignupOutputData outputData;

    @Before
    public void init() {
        this.outputData = new SignupOutputData("hello", false);
    }

    @Test
    public void testGetUsername() {
        assertEquals("hello", outputData.getUsername());
    }

    @Test
    public void testGetUseCaseSuccess() {
        assertEquals(false, outputData.getUseCaseSuccess());
    }


}
