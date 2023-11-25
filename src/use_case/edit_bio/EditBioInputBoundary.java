package use_case.edit_bio;

public interface EditBioInputBoundary {
    void execute(String currentUsername, EditBioInputData editBioInputData);
}