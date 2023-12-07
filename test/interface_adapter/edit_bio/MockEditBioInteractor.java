package interface_adapter.edit_bio;

import use_case.edit_bio.EditBioInputBoundary;
import use_case.edit_bio.EditBioInputData;

public class MockEditBioInteractor implements EditBioInputBoundary {
    private String currentState;

    public MockEditBioInteractor() {
        this.currentState = "";
    }

    public String getState() {
        return this.currentState;
    }

    @Override
    public void execute(String string, EditBioInputData inputData) {
        this.currentState = "Success";
    }
}