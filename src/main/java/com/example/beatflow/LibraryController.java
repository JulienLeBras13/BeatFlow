package com.example.beatflow;

// Using CSV files
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Using graphical elements
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class LibraryController {
    // Graphical objects used
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtKind;
    @FXML
    private TextField txtArtist;
    @FXML
    private TextField txtAlbum;


    // List of music types
    String typesOfMusic [] = {"Rap", "Classical", "Electro"};
    // Conversion to arrayList
    //ArrayList<String> typesList = new ArrayList<>();

    // Tab of playlists declaration (where "Classical, Rap, ..." will be written)
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
        // Verification that title and .mp3 fields aren't empty
        if(txtTitle.getText() != "")
        {

        }
    }
}
