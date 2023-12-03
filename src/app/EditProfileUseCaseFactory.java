package app;

import entity.CommonPlaylistFactory;
import entity.PlaylistFactory;
import interface_adapter.authorize.AuthorizeController;
import interface_adapter.authorize.AuthorizePresenter;
import interface_adapter.authorize.AuthorizeViewModel;
import interface_adapter.choose_playlist.ChoosePlaylistController;
import interface_adapter.choose_playlist.ChoosePlaylistPresenter;
import interface_adapter.choose_playlist.ChoosePlaylistViewModel;
import interface_adapter.display_playlists.DisplayPlaylistsController;
import interface_adapter.display_playlists.DisplayPlaylistsPresenter;
import interface_adapter.display_playlists.DisplayPlaylistsViewModel;
import interface_adapter.edit_bio.EditBioController;
import interface_adapter.edit_bio.EditBioPresenter;
import interface_adapter.edit_bio.EditBioViewModel;
import interface_adapter.edit_profile.EditProfileController;
import interface_adapter.edit_profile.EditProfilePresenter;
import interface_adapter.edit_profile.EditProfileViewModel;
import interface_adapter.edit_spotify_handle.EditSpotifyHandleController;
import interface_adapter.edit_spotify_handle.EditSpotifyHandlePresenter;
import interface_adapter.edit_spotify_handle.EditSpotifyHandleViewModel;
import interface_adapter.go_back.GoBackController;
import interface_adapter.go_back.GoBackPresenter;
import interface_adapter.go_back.GoBackViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.authorize.AuthorizeInputBoundary;
import use_case.authorize.AuthorizeInteractor;
import use_case.authorize.AuthorizeOutputBoundary;
import use_case.authorize.AuthorizeSpotifyAuthenticationDataAccessInterface;
import use_case.choose_playlist.*;
import use_case.display_playlists.DisplayPlaylistsInputBoundary;
import use_case.display_playlists.DisplayPlaylistsInteractor;
import use_case.display_playlists.DisplayPlaylistsOutputBoundary;
import use_case.display_playlists.DisplayPlaylistsSpotifyAPIDataAccessInterface;
import use_case.edit_bio.EditBioInputBoundary;
import use_case.edit_bio.EditBioInteractor;
import use_case.edit_bio.EditBioOutputBoundary;
import use_case.edit_bio.EditBioUserDataAccessInterface;
import use_case.edit_profile.EditProfileInputBoundary;
import use_case.edit_profile.EditProfileInteractor;
import use_case.edit_profile.EditProfileOutputBoundary;
import use_case.edit_spotify_handle.EditSpotifyHandleInputBoundary;
import use_case.edit_spotify_handle.EditSpotifyHandleInteractor;
import use_case.edit_spotify_handle.EditSpotifyHandleOutputBoundary;
import use_case.edit_spotify_handle.EditSpotifyHandleUserDataAccessInterface;
import interface_adapter.*;
import use_case.go_back.GoBackInputBoundary;
import use_case.go_back.GoBackInteractor;
import use_case.go_back.GoBackOutputBoundary;
import view.EditProfileView;

import javax.swing.*;
import java.io.IOException;

public class EditProfileUseCaseFactory {

    /** Prevent instantiation. */
    private EditProfileUseCaseFactory() {}
    public static EditProfileView create(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            EditProfileViewModel editProfileViewModel,
            EditBioViewModel editBioViewModel,
            EditBioUserDataAccessInterface editBioUserDataAccessObject,
            DisplayPlaylistsViewModel displayPlaylistsViewModel,
            DisplayPlaylistsSpotifyAPIDataAccessInterface displayPlaylistsSpotifyAPIDataAccessObject,
            AuthorizeViewModel authorizeViewModel,
            AuthorizeSpotifyAuthenticationDataAccessInterface authorizeSpotifyAuthenticationDataAccessObject,
            ChoosePlaylistViewModel choosePlaylistViewModel,
            ChoosePlaylistUserDataAccessInterface choosePlaylistUserDataAccessObject,
            ChoosePlaylistPlaylistDataAccessInterface choosePlaylistPlaylistDataAccessObject,
            ChoosePlaylistSpotifyAPIDataAccessInterface choosePlaylistSpotifyAPIDataAccessObject,
            EditSpotifyHandleViewModel editSpotifyHandleViewModel,
            EditSpotifyHandleUserDataAccessInterface editSpotifyHandleUserDataAccessObject,
            GoBackViewModel goBackViewModel) {
        try {
            EditProfileController editProfileController = createEditProfileUseCase(viewManagerModel, editProfileViewModel);
            EditBioController editBioController = createEditBioUseCase(viewManagerModel, editBioViewModel, editBioUserDataAccessObject);
            DisplayPlaylistsController displayPlaylistsController = createDisplayPlaylistsUseCase(viewManagerModel, displayPlaylistsViewModel, displayPlaylistsSpotifyAPIDataAccessObject);
            AuthorizeController authorizeController = createAuthorizeUseCase(viewManagerModel, authorizeViewModel, authorizeSpotifyAuthenticationDataAccessObject);
            ChoosePlaylistController choosePlaylistController = createChoosePlaylistController(viewManagerModel, choosePlaylistViewModel, choosePlaylistUserDataAccessObject,
                    choosePlaylistPlaylistDataAccessObject, choosePlaylistSpotifyAPIDataAccessObject);
            EditSpotifyHandleController editSpotifyHandleController = createEditSpotifyHandleUseCase(viewManagerModel, editSpotifyHandleViewModel, editSpotifyHandleUserDataAccessObject);
            GoBackController goBackController = createGoBackUseCase(viewManagerModel, goBackViewModel, loggedInViewModel);

            return new EditProfileView(editProfileController, editProfileViewModel, editBioController, editBioViewModel,
                    displayPlaylistsController, displayPlaylistsViewModel, authorizeController, authorizeViewModel,
                    choosePlaylistController, choosePlaylistViewModel, editSpotifyHandleController, editSpotifyHandleViewModel,
                    goBackController, goBackViewModel, loggedInViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static EditProfileController createEditProfileUseCase(ViewManagerModel viewManagerModel, EditProfileViewModel editProfileViewModel) throws IOException {
        EditProfileOutputBoundary editProfileOutputBoundary = new EditProfilePresenter(viewManagerModel, editProfileViewModel);
        EditProfileInputBoundary editProfileInteractor = new EditProfileInteractor(editProfileOutputBoundary);

        return new EditProfileController(editProfileInteractor);
    }

    private static EditBioController createEditBioUseCase(ViewManagerModel viewManagerModel, EditBioViewModel editBioViewModel, EditBioUserDataAccessInterface editBioUserDataAccessObject) throws IOException {
        EditBioOutputBoundary editBioOutputBoundary = new EditBioPresenter(viewManagerModel, editBioViewModel);
        EditBioInputBoundary editBioInteractor = new EditBioInteractor(editBioUserDataAccessObject, editBioOutputBoundary);

        return new EditBioController(editBioInteractor);
    }

    private static DisplayPlaylistsController createDisplayPlaylistsUseCase(ViewManagerModel viewManagerModel, DisplayPlaylistsViewModel displayPlaylistsViewModel, DisplayPlaylistsSpotifyAPIDataAccessInterface displayPlaylistsSpotifyAPIDataAccessObject) {
        DisplayPlaylistsOutputBoundary displayPlaylistsOutputBoundary = new DisplayPlaylistsPresenter(viewManagerModel, displayPlaylistsViewModel);
        DisplayPlaylistsInputBoundary displayPlaylistsInteractor = new DisplayPlaylistsInteractor(displayPlaylistsSpotifyAPIDataAccessObject, displayPlaylistsOutputBoundary);

        return new DisplayPlaylistsController(displayPlaylistsInteractor);
    }

    private static AuthorizeController createAuthorizeUseCase(ViewManagerModel viewManagerModel, AuthorizeViewModel authorizeViewModel, AuthorizeSpotifyAuthenticationDataAccessInterface authorizeSpotifyAuthenticationDataAccessObject) {
        AuthorizeOutputBoundary authorizeOutputBoundary = new AuthorizePresenter(viewManagerModel, authorizeViewModel);
        AuthorizeInputBoundary authorizeInteractor = new AuthorizeInteractor(authorizeSpotifyAuthenticationDataAccessObject, authorizeOutputBoundary);

        return new AuthorizeController(authorizeInteractor);
    }

    private static ChoosePlaylistController createChoosePlaylistController(ViewManagerModel viewManagerModel, ChoosePlaylistViewModel choosePlaylistViewModel, ChoosePlaylistUserDataAccessInterface choosePlaylistUserDataAccessObject,
                                                                           ChoosePlaylistPlaylistDataAccessInterface choosePlaylistPlaylistDataAccessObject, ChoosePlaylistSpotifyAPIDataAccessInterface choosePlaylistSpotifyAPIDataAccessObject) {
        ChoosePlaylistOutputBoundary choosePlaylistOutputBoundary = new ChoosePlaylistPresenter(viewManagerModel, choosePlaylistViewModel);
        PlaylistFactory playlistFactory = new CommonPlaylistFactory();
        ChoosePlaylistInputBoundary choosePlaylistInteractor = new ChoosePlaylistInteractor(choosePlaylistUserDataAccessObject, choosePlaylistPlaylistDataAccessObject, choosePlaylistSpotifyAPIDataAccessObject, choosePlaylistOutputBoundary, playlistFactory);

        return new ChoosePlaylistController(choosePlaylistInteractor);
    }

    private static EditSpotifyHandleController createEditSpotifyHandleUseCase(ViewManagerModel viewManagerModel, EditSpotifyHandleViewModel editSpotifyHandleViewModel, EditSpotifyHandleUserDataAccessInterface editSpotifyHandleUserDataAccessObject) throws IOException {
        EditSpotifyHandleOutputBoundary editSpotifyHandleOutputBoundary = new EditSpotifyHandlePresenter(viewManagerModel, editSpotifyHandleViewModel);
        EditSpotifyHandleInputBoundary editSpotifyHandleInteractor = new EditSpotifyHandleInteractor(editSpotifyHandleUserDataAccessObject, editSpotifyHandleOutputBoundary);

        return new EditSpotifyHandleController(editSpotifyHandleInteractor);
    }

    private static GoBackController createGoBackUseCase(ViewManagerModel viewManagerModel, GoBackViewModel goBackViewModel, LoggedInViewModel loggedInViewModel) {
        GoBackOutputBoundary goBackOutputBoundary = new GoBackPresenter(viewManagerModel, goBackViewModel, loggedInViewModel);
        GoBackInputBoundary goBackInteractor = new GoBackInteractor(goBackOutputBoundary);

        return new GoBackController(goBackInteractor);
    }
}