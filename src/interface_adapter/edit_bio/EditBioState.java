package interface_adapter.edit_bio;

public class EditBioState {
    private String bio;

    public EditBioState(EditBioState copy) {
        this.bio = copy.bio;
    }
    public EditBioState(){}
    public String getBio() {
        return bio;
    }
    public void setBIo(String bio) {
        this.bio = bio;
    }
}
