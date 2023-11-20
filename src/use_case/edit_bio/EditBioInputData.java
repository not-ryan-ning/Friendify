package use_case.edit_bio;

public class EditBioInputData {
    private String newBio;

    public EditBioInputData(String newBio) {
        this.newBio = newBio;
    }
    String getNewBio() {
        return newBio;
    }
}