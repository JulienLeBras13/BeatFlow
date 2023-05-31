package com.example.beatflow;

import javafx.fxml.FXML;
import java.util.ArrayList;
import javafx.scene.control.TabPane;

public class LibraryController {
    // List of music types
    String typesOfMusic [] = {"Rap", "Classical", "Electro"};
    // Conversion to arrayList
    ArrayList<String> typesList = new ArrayList<>();

    // Tab of playlists declaration (where "Classical, Rap, ..." will be written)
    @FXML
    private TabPane tpListOfPlaylists;

    // Filling of the tab
    /*for(int iTabFilling = 0; iTabFilling < typesList.size(); iTabFilling++)
    {

    }*/
}
