package com.example.beatflow;

// Using file chooser
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Window;

// Using model files
import models.Artist;
import models.Playlist;
import models.Song;
import models.Library;

// Using graphical elements
import javafx.fxml.FXML;

import java.io.File;
import java.util.ArrayList;

public class LibraryControllerAdmin {
    // To add a song
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtKind;
    @FXML
    private TextField txtArtist;
    @FXML
    private TextField txtSearch;
    @FXML
    private Label lblError;
    @FXML
    private Label lblFileChosen;

    // To show or modify songs data
    @FXML
    private Label lblNameTitle;
    @FXML
    private Label lblKindTitle;
    @FXML
    private Label lblArtistTitle;
    @FXML
    private TextField txtTitleModify;
    @FXML
    private TextField txtKindModify;
    @FXML
    private TextField txtArtistModify;
    @FXML
    private Button btnUpdate;

    // To delete a song
    @FXML
    private Button btnDelete;
    @FXML
    private Label lblDelete;

    // Showing songs and kinds of songs
    @FXML
    private ListView lvSongsList;

    // Elements to use the listview
        // ArrayList for types of music
    private ArrayList<Song> selTypeOfMusic = new  ArrayList();

    /**
     * Action on the "Add to library" button click
     * Function that creates a new Song object with user written features
     */
    @FXML
    protected void btnAdd_Click()
    {
        if(!txtTitle.getText().isEmpty() && !txtArtist.getText().isEmpty() && !txtKind.getText().isEmpty())
        {
            // Song features
            String songTitle = txtTitle.getText().toString();
            String songArtist = txtArtist.getText().toString();
            String songKind = txtKind.getText().toString();

            // Verifying if artist is in the list
            Artist thisArtist = BeatFlow.findArtist(BeatFlow.library.getArtists(), songArtist);

            // Song creation
            Song newSong = new Song(songTitle, songKind, thisArtist);
            BeatFlow.library.getSongs().add(newSong);

            // Song created
            lblError.setText("No error message\nSong added successfully");
            lblError.setTextFill((Paint.valueOf("green")));
            lblError.setVisible(true);
        }
        else
        {
            // If the title or artist field are empty
            lblError.setText("Error message : \n No title, no kind or\n no artist chosen");
            lblError.setTextFill((Paint.valueOf("red")));
            lblError.setVisible(true);
        }

        // Clearing the list
        lvSongsList.getItems().clear();
        // Updating songs list
        selTypeOfMusic.clear();
        selTypeOfMusic = (ArrayList<Song>) BeatFlow.library.getSongs().clone();
        for (Song song0 : selTypeOfMusic) {
            lvSongsList.getItems().add(song0.getTitle());
        }
        lblDelete.setText("...");
    }

    /**
     * Action on the "Choose MP3 file" button click
     * Function which open a file chooser to find the MP3 file to add to the database.
     */
    @FXML
    protected void btnChooseFile_Click()
    {
        // Opening file chooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a MP3 file");
        Window stage = null;

        // Sorting file extensions
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("MP3 Files", "*.mp3"));

        // MP3 File received
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile == null) {
            lblFileChosen.setText("No file selected");
        }
        else
        {
            lblFileChosen.setText(selectedFile.getName());
        }
        lblDelete.setText("...");
    }

    /**
     * Action on the "Search" button click
     * Function that searches into Song list to find the user nearest value
     */
    @FXML
    protected void btnSearch_Click()
    {
        // Getting user searched value
        String searchedValue = txtSearch.getText().toString();

        // Clearing the list
        lvSongsList.getItems().clear();

        // Activating delete function
        btnDelete.setVisible(true);
        lblDelete.setText("...");

        // Searching music title
        if(BeatFlow.findSong(BeatFlow.library.getSongs(), searchedValue) != null)
        {
            // If song is found
            lvSongsList.getItems().add(lvSongsList.getItems().size(), searchedValue);
        }

        // If the Textfield is empty
        else if(txtSearch.getText().trim().isEmpty())
        {
            // Display song in listview
            lvSongsList.getItems().clear();
            selTypeOfMusic.clear();
            selTypeOfMusic = (ArrayList<Song>) BeatFlow.library.getSongs().clone();
            // Selection one item
            for (Song song : selTypeOfMusic) {
                lvSongsList.getItems().add(song.getTitle());
            }
        }
        // if the song isn't found, try to search by artist
        else if(BeatFlow.findArtist(BeatFlow.library.getArtists(), searchedValue) != null)
        {
            for(Song song : BeatFlow.library.getSongs())
            {
                if(song.getArtist().getArtistName().equals(searchedValue))
                {
                    lvSongsList.getItems().add(song.getTitle());

                    // Modify the labels values
                    lblNameTitle.setText("First name :");
                    lblKindTitle.setText("Last name :");
                    lblArtistTitle.setText("Artist name :");

                    // Reactivating buttons
                    btnDelete.setVisible(false);
                    btnUpdate.setVisible(false);
                    lblDelete.setVisible(false);

                    // Modify the Textfields values
                    txtArtistModify.setText(song.getArtist().getArtistName());
                    txtKindModify.setText(song.getArtist().getLastName());
                    txtTitleModify.setText(song.getArtist().getFirstName());
                }
            }
        }
    }

    /**
     * Action on the click on a song into the songs list
     * Function that the goal is to show songs data into the Textfields on
     *  the right of the graphical view, then we can modify it
     */
    @FXML
    protected void lvSongsList_Click()
    {
        // Identifying song in the list
        for(Song song : selTypeOfMusic)
        {
            if (song.getTitle().equals(lvSongsList.getSelectionModel().getSelectedItem()))
            {
                // Modify the labels values
                lblNameTitle.setText("Title :");
                lblKindTitle.setText("Kind :");
                lblArtistTitle.setText("Artist :");

                // Reactivating buttons
                btnDelete.setVisible(true);
                btnUpdate.setVisible(true);
                lblDelete.setVisible(true);

                // Show data into Textfields
                txtTitleModify.setText(song.getTitle());
                txtArtistModify.setText(song.getArtist().getArtistName());
                txtKindModify.setText(song.getKind());
            }
        }
    }

    /**
     * Action on the "Delete song" button click
     * Function which is used to delete a song
     */
    @FXML
    protected void btnDelete_Click()
    {
        // Identifying the song then deleting
        int index = lvSongsList.getSelectionModel().getSelectedIndex();
        if(index >= 0)
        {
            Song song = selTypeOfMusic.get(index);
            BeatFlow.library.getSongs().remove(song);

            // Clearing the list
            lvSongsList.getItems().clear();
            // Updating songs list
            selTypeOfMusic.clear();
            selTypeOfMusic = (ArrayList<Song>) BeatFlow.library.getSongs().clone();
            for (Song song1 : selTypeOfMusic) {
                lvSongsList.getItems().add(song1.getTitle());
            }

            // Clearing the Textfields on the right
            txtTitleModify.setText("");
            txtArtistModify.setText("");
            txtKindModify.setText("");
            lblDelete.setText("Song deleted");
        }
    }

    /**
     * Action on the "Update data" button click
     * Function which the purpose is to update data songs from user inputs
     */
    @FXML
    protected void btnUpdate_Click()
    {
        // Verifying if any field isn't filled
        if(!txtTitleModify.getText().isEmpty() && !txtKindModify.getText().isEmpty() && !txtArtistModify.getText().isEmpty())
        {
            // Receiving data inputs
            String userTitle = txtTitleModify.getText();
            String userKind = txtKindModify.getText();
            Artist userArtist = BeatFlow.findArtist(BeatFlow.library.getArtists(), txtArtistModify.getText());

            // Update data into the library from user data
            for (Song song : BeatFlow.library.getSongs()){
                if (song.getTitle().equals(lvSongsList.getSelectionModel().getSelectedItem())){
                    song.setTitle(userTitle);
                    song.setKind(userKind);
                    song.setArtist(userArtist);
                }
            }

            // Clearing the list
            lvSongsList.getItems().clear();
            // Updating songs list
            selTypeOfMusic.clear();
            selTypeOfMusic = (ArrayList<Song>) BeatFlow.library.getSongs().clone();
            for (Song song2 : selTypeOfMusic)
            {
                lvSongsList.getItems().add(song2.getTitle());
            }

            // Clearing the Textfields on the left of the graphical view
            txtTitleModify.setText("");
            txtArtistModify.setText("");
            txtKindModify.setText("");
            lblDelete.setText("Song updated");
        }
    }
}
