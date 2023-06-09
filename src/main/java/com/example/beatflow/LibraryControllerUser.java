package com.example.beatflow;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import models.Library;

public class LibraryControllerUser {
    @FXML
    private Label Logo;
    @FXML
    private ImageView ImageAlbum;
    @FXML
    private Button ButtonSearch;
    @FXML
    private Button ButtonNewPlaylist;
    @FXML
    private TextField nameText;
    @FXML
    private Button ButtonAddToPlaylist;
    @FXML
    private ListView<Library> ListViewMusic;
    @FXML
    private Pane PaneInformationMusic;
    String UserInput;
    @FXML
    private Label Search;

    @FXML
    protected void ListViewSelectedMusic(){
        /**
         * Display music on the list view
         */
        ListView<Library> listSongs = new ListView<Library>();
        /**
         * to select only on item
         */
        listSongs.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listSongs.getSelectionModel().getSelectedItems();
    }
    @FXML
    protected void onTextFieldKeyPressed(){

        /**
         * when keyboard pressed display artist,song, kind
         */

        /**
         * if button search pressed display song, artist in list view, buttons actions
         */
        Button ButtonSearch = new Button();
        ButtonSearch.setOnAction(actionEvent -> {
        });

        /**
         * retrieving data
         */
        String UserInput = nameText.getText();
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
