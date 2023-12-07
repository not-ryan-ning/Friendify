package use_case.edit_bio;

public class MockEditBioPresenter implements EditBioOutputBoundary {
    private String currentState;

    public MockEditBioPresenter() {
        this.currentState = "";
    }
    @Override
    public void prepareSuccessView(EditBioOutputData updatedBio) {
        this.currentState = "Success";
    }

    public String getState() {
        return this.currentState;
    }
}
