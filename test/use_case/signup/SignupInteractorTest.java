package use_case.signup;

import data_access.FileUserDataAccessObject;

import static org.junit.Assert.*;

import entity.*;
import interface_adapter.ViewManagerModel;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.match.MatchInteractor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SignupInteractorTest {
    private SignupInteractor signupInteractor;
    private ViewManagerModel viewManagerModel;

    @BeforeEach
    public void setUp() {
        // Initialize the objects before each test
        viewManagerModel = new ViewManagerModel();
        sendRequestInteractor = ...
    }
    @Test
    public void testExecute() {
        signupInteractor.execute(new SignupInputData("user", "p", "p"));
       // assertEquals("display matches", viewManagerModel.getActiveView());
    }
}