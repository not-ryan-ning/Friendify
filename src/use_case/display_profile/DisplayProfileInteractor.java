package use_case.display_profile;

public class DisplayProfileInteractor implements DisplayProfileInputBoundary {
    final DisplayProfileUserDataAccessInterface displayProfileUserDataAccessObject;
    final DisplayProfileOutputBoundary displayProfilePresenter;

    public DisplayProfileInteractor(DisplayProfileUserDataAccessInterface displayProfileUserDataAccessInterface, DisplayProfileOutputBoundary displayProfileOutputBoundary) {
        this.displayProfileUserDataAccessObject = displayProfileUserDataAccessInterface;
        this.displayProfilePresenter = displayProfileOutputBoundary;
    }

    @Override
    public void execute() {
        DisplayProfileOutputData displayProfileOutputData = new DisplayProfileOutputData();
        displayProfilePresenter.prepareSuccessView(displayProfileOutputData);
    }
}
