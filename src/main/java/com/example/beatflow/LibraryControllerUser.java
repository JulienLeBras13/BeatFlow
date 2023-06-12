package com.example.beatflow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import models.Library;

import java.util.ArrayList;

public class LibraryControllerUser {
    @FXML
    private Label logo;
    @FXML
    private ImageView imageAlbum;
    @FXML
    private Button buttonSearch;
    @FXML
    private Button buttonNewPlaylist;
    @FXML
    private TextField textEnter;
    @FXML
    private Button buttonAddToPlaylist;
    @FXML
    private ListView<String> listViewTitle;
    @FXML
    private ArrayList<String> selectedPlayList = new  ArrayList();
    @FXML
    private Button library;
    @FXML
    private Pane paneInformationMusic;
    @FXML
    private Label search;


    @FXML
    protected void onTextFieldKeyPressed(){
        /**
         * creat e empty TextField object
         */
       TextField textEnter = new TextField();
        /**
         * if button search pressed display song, artist in list view,
         * buttons actions
         */
        Button ButtonSearch = new Button();
        ButtonSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /**
                 * code to execute when button search is pressed
                 * retrieving data
                 */

            }
        });
    }
    @FXML
    protected void showLibraryTitles(){
        /**
         * Display music on the list view
         */

        /**for (Song song:)
        /**
         * to select only one item
         */
        //listSongs.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //listSongs.getSelectionModel().getSelectedItems();
    }
    @FXML
    protected void CreatNewPlaylist(){
        /**
         * when click on button display songs
         */
        Button creatPlaylist = new Button("New Playlist");
        creatPlaylist.setOnAction(actionEvent -> {

        });
    }
    @FXML
    protected void AddInPlaylist(){
        /**
         * Add new song in playlist
         */

        /**
         * when button selected text Song added
         */
        Button ButtonAddToPlaylist = new Button();
        ButtonAddToPlaylist.setOnAction(actionEvent -> {

        });
    }
    protected void OnClickSort(){
        /**
         *Sort by artist, kind, album in alphabetical order etc.
         */
    }

    /**
     * protected void onBuyMusique(){
     *     allows you to buy
     * }
     */
}
