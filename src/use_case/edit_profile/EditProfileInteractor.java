package use_case.edit_profile;

public class EditProfileInteractor implements EditProfileInputBoundary {
    private final EditProfileOutputBoundary editProfilePresenter;

    public EditProfileInteractor(EditProfileOutputBoundary editProfileOutputBoundary) {
        this.editProfilePresenter = editProfileOutputBoundary;
    }

    /**
     * Calls the editProfile presenter's prepareSuccessView method to change views.
     */
    @Override
    public void execute() {
        editProfilePresenter.prepareSuccessView();
    }
}