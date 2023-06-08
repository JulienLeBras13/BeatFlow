package com.example.beatflow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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
    private TextField TextZone;


    @FXML
    protected void onTextFieldKeyPressed(){
        /**
         * when keyboard pressed display artist,song, kind
         */
        TextZone.getCharacters();
    }
    @FXML
    protected void CreatNewPlaylist(){
        /**
         * when click on button display songs
         */
        Button a = new Button("New Playlist");
    }

    @FXML
    protected void AddInPlaylist(){
        /**
         * Add new song in playlist
         */

        /**
         * when button selected text Song added
         */

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
