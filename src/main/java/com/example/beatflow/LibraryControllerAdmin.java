package com.example.beatflow;

// Using file chooser
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

import java.io.File;

public class LibraryControllerAdmin {
    // Graphical objects used
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

    @FXML
    private ListView lvSongsList;

    @FXML
    private TabPane tpListOfPlaylists;

    // Filling of the tab
    /*for(int iTabFilling = 0; iTabFilling < typesList.size(); iTabFilling++)
    {

    }*/

    /**
     * Function that creates a new Song object with user written features
     * @return void
     */
    @FXML
    protected void btnAdd_Click()
    {
        if(!txtTitle.getText().isEmpty() && !txtArtist.getText().isEmpty())
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
            lblError.setText("No error message");
            lblError.setTextFill((Paint.valueOf("green")));
            lblError.setVisible(true);
        }
        else
        {
            // If the title or artist field are empty
            lblError.setText("Error message : \n No title or no artist \n chosen");
            lblError.setTextFill((Paint.valueOf("red")));
            lblError.setVisible(true);
        }
    }

    /**
     * Function which open a file chooser to find the MP3 file to add to the database.
     * @return void
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
            // TODO : Stock the mp3 files
        }
    }

    /**
     * Function that search into Song list to find the user nearest value
     * @return void
     */
    @FXML
    protected void btnSearch_Click()
    {
        // Getting user searched value
        String searchedValue = txtSearch.getText().toString();

        // Searching music title
        if(BeatFlow.findSong(BeatFlow.library.getSongs(), searchedValue) != null)
        {
            // If song is found
            lvSongsList.getItems().add(lvSongsList.getItems().size(), searchedValue);

        }
        if(searchedValue == "")
        {

        }
    }


}
