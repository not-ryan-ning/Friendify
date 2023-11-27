package use_case.edit_profile;

public class EditProfileInteractor implements EditProfileInputBoundary {
    private final EditProfileOutputBoundary editProfilePresenter;

    public EditProfileInteractor(EditProfileOutputBoundary editProfileOutputBoundary) {
        this.editProfilePresenter = editProfileOutputBoundary;
    }
    @Override
    public void execute() {
        editProfilePresenter.prepareSuccessView();
    }
}