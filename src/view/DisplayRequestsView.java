package view;

import interface_adapter.display_requests.DisplayRequestsController;
import interface_adapter.display_requests.DisplayRequestsViewModel;

import javax.swing.*;
import java.awt.*;

public class DisplayRequestsView {
    public final String viewname = "Display Requests";
    private final DisplayRequestsViewModel displayRequestsViewModel;
    private final DisplayRequestsController displayRequestsController;

    //how are we going to map each view profile button to a user?
    public DisplayRequestsView(DisplayRequestsViewModel displayRequestsViewModel, DisplayRequestsController displayRequestsController) {
        this.displayRequestsViewModel = displayRequestsViewModel;
        this.displayRequestsController = displayRequestsController;

        JLabel title = new JLabel(DisplayRequestsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // buttons go here


    }

}
