package use_case.edit_bio;

public class EditBioOutputData {
    private String newBio;

    public EditBioOutputData(String newBio) {
        this.newBio = newBio;
    }
    public String getNewBio() {
        return newBio;
    }
}
