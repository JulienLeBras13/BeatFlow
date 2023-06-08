package com.example.beatflow;

// Using file chooser
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

public class LibraryControllerAdmin {
    // Graphical objects used
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtKind;
    @FXML
    private TextField txtArtist;
    @FXML
    private TextField txtAlbum;

    @FXML
    private TabPane tpListOfPlaylists;

    // Filling of the tab
    /*for(int iTabFilling = 0; iTabFilling < typesList.size(); iTabFilling++)
    {

    }*/

    /*
     * Function name : btnAdd_Click
     * Creation date : 31.05.2023
     * Function goal : Adding a music on the CSV file with the user written values
     * */
    @FXML
    protected void btnAdd_Click()
    {
        if(txtTitle.getText() != "" || txtArtist.getText() != "")
        {
            // Song features
            String songTitle = txtTitle.getText();
            String songArtist = txtArtist.getText();
            String songKind = txtKind.getText();

            // Verifying if artist is in the list
            Artist thisArtist = BeatFlow.findArtist(BeatFlow.library.getArtists(), songArtist);

            // Song creation
            Song newSong = new Song(songTitle, songKind, thisArtist);
            BeatFlow.library.getSongs().add(newSong);

        }
        else
        {
            // If the title or artist field are empty

        }
        /*String line = "";
        String splitBy = ",";
        try {
            File csvFile = new File("/data/songs.csv");
            if(csvFile.isFile())
            {
                // Opening CSV file
                FileWriter csvWriter = new FileWriter("/data/songs.csv");

                // Adding to csvWriter the content
                csvWriter.append(String.join(txtTitle.getText(), ",", txtKind.getText(), ",", txtAlbum.getText()));

                // Verification that title and .mp3 fields aren't empty
                if (txtTitle.getText() != "")
                {

                }
            }
        }*/
    }

    //
    @FXML
    protected void btnChooseFile_Click()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Window stage = null;
        fileChooser.showOpenDialog(stage);
    }
}
