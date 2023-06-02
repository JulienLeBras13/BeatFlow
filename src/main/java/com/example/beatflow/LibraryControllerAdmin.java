package com.example.beatflow;

// Using CSV files
import java.io.FileWriter;
import java.io.File;

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
        String line = "";
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
            catch(Exception e)
            {

            }
        }
    }
}
