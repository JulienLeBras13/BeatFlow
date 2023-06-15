package com.example.beatflow;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Artist;
import models.Playlist;
import models.Song;

import java.util.*;

/**
 * Class that controls the view and allows you to perform actions for example to search for music
 */
public class LibraryControllerUser {
    @FXML
    private Label  labelOutp1,labelOutp2, labelOutp3, label1, label2, label3;
    @FXML
    private Button buttonSearch, buttonAddToPlaylist, buttonNewPlaylist, actualizePlaylist, alphabeticalOrder, initView, adminView;
    @FXML
    private TextField textEnter, nomPlaylist;
    @FXML
    private ListView<String> listViewLeft, playlists, listViewRight;
    private ArrayList<Song> selectedPlayList = new  ArrayList();
    private ArrayList<Song>  chargedPlaylist = new ArrayList<>();
    int indexOfSelectedPlaylist;
    String sorted = "unsorted";

    /**
     * Action actualize fix Playlist (rock, Librery and electro)
     */
    @FXML
    protected void onActualizePlaylist(){
        // actualize Playlist in listView
        playlists.getItems().clear();
        playlists.getItems().add("library");
        for (Playlist playlist : BeatFlow.library.getPlaylists()){
            playlists.getItems().add(playlist.getName());
        }
    }

    /**
     * This methode display the title in a playlist
     * Library is a default view
     */
    @FXML
    protected void showTitles() {
            // Display song in listview
            selectedPlayList.clear();
            listViewLeft.getItems().clear();
            String playlistName = playlists.getSelectionModel().getSelectedItem();
            //Display Library as default value
            if (playlistName.equals("library")) {
                selectedPlayList = (ArrayList<Song>) BeatFlow.library.getSongs().clone();
                chargedPlaylist.clear();
            } else {
                for (Playlist playlist : BeatFlow.library.getPlaylists()) {
                    if (playlist.getName().equals(playlistName)) {
                        indexOfSelectedPlaylist = BeatFlow.library.getPlaylists().indexOf(playlist);
                        if (!playlist.getFix()) {
                            selectedPlayList = (ArrayList<Song>) BeatFlow.library.getSongs().clone();
                            chargedPlaylist = (ArrayList<Song>) BeatFlow.library.getPlaylists().get(indexOfSelectedPlaylist).getPlaylist().clone();
                        } else {
                            selectedPlayList = (ArrayList<Song>) BeatFlow.library.getPlaylists().get(indexOfSelectedPlaylist).getPlaylist().clone();
                        }
                        break;
                    }
                }
            }
            // Display result in listView
            listViewRight.getItems().clear();
            if (!BeatFlow.library.getPlaylists().get(indexOfSelectedPlaylist).getFix()) {
                for (Song song : chargedPlaylist) {
                    listViewRight.getItems().add(song.getTitle());
                }
            }//selected one item
            for (Song song : selectedPlayList) {
                listViewLeft.getItems().add(song.getTitle());
            }
    }

    /**
     * Display de data of the selected playlist
     */
    @FXML
    protected void showDataLeft(){
        for (Song song : selectedPlayList){
            if (song.getTitle().equals(listViewLeft.getSelectionModel().getSelectedItem())){
                labelOutp1.setText(song.getTitle());
                label1.setText("Title");
                labelOutp2.setText(song.getArtist().getArtistName());
                label2.setText("Artist");
                labelOutp3.setText(song.getKind());
                label3.setText("Kind");
            }
        }
    }

    /**
     * Display the data of the user playlist
     */
    @FXML
    protected void showDataRight(){
        for (Song song : selectedPlayList){
            if (song.getTitle().equals(listViewRight.getSelectionModel().getSelectedItem())){
                labelOutp1.setText(song.getTitle());
                label1.setText("Title");
                labelOutp2.setText(song.getArtist().getArtistName());
                label2.setText("Artist");
                labelOutp3.setText(song.getKind());
                label3.setText("Kind");
            }
        }
    }

    /**
     * Action button search pressed
     * That search into Playlist the input of the user (Song or artist)
     */
    @FXML
    protected void search(){
        //clear listviews
        listViewLeft.getItems().clear();
        listViewRight.getItems().clear();
        // searching song and artist
        for (Song song: BeatFlow.library.getSongs()){
            if (song.getTitle().equals(textEnter.getText())){
                listViewLeft.getItems().add(song.getTitle());
                labelOutp1.setText(song.getTitle());
                label1.setText("Title");
                labelOutp2.setText(song.getArtist().getArtistName());
                label2.setText("Artist");
                labelOutp3.setText(song.getKind());
                label3.setText("Kind");
                break;
            } else if (song.getArtist().getArtistName().equals(textEnter.getText())) {
                listViewLeft.getItems().add(song.getTitle());
                labelOutp1.setText(song.getArtist().getFirstName());
                label1.setText("First Name");
                labelOutp2.setText(song.getArtist().getLastName());
                label2.setText("Last Name");
                labelOutp3.setText(song.getArtist().getArtistName());
                label3.setText(" Artist");
            }
        }
    }

    /**
     * Action button new playlist pressed
     * Allows to create a playlist
     */
    @FXML
    protected void CreatNewPlaylist() {
        if (!nomPlaylist.getText().isEmpty()){
            BeatFlow.library.getPlaylists().add(new Playlist(nomPlaylist.getText()));
            onActualizePlaylist();
        }
    }

    /**
     * Actions button Add to playlist pressed
     * Allows user to add a song in his playlist
     */
    @FXML
    protected void AddInPlaylist(){
        // control if playlist is not Fix
        if (!BeatFlow.library.getPlaylists().get(indexOfSelectedPlaylist).getFix()) {
            listViewRight.getItems().clear();
            // add song in new Playlist
            for (Song song : selectedPlayList) {
                if (song.getTitle().equals(listViewLeft.getSelectionModel().getSelectedItem())) {
                    BeatFlow.library.getPlaylists().get(indexOfSelectedPlaylist).getPlaylist().add(song);
                    chargedPlaylist = BeatFlow.library.getPlaylists().get(indexOfSelectedPlaylist).getPlaylist();
                }
            }
            // display the song in the listView
            for (Song song : chargedPlaylist) {
                listViewRight.getItems().add(song.getTitle());
            }
        }
    }

    /**
     * Action button Alphabetic sort pressed
     * sorted the son on alphabetic order
     */
    @FXML
    protected void alphabeticalOrder(){
        switch (sorted){
            case "Sorted" :
                Collections.sort(listViewLeft.getItems(), Collections.reverseOrder());
                sorted = "ReverseOrder";
                break;
            default :
                Collections.sort(listViewLeft.getItems());
                sorted = "Sorted";
        }
    }

    /**
     * Load the adminView
     */
    @FXML
    protected void goToAdminView(){
        Stage window = (Stage) adminView.getScene().getWindow();
        window.setScene(BeatFlow.adminScene);
    }

    /**
     * Load the initView
     */
    @FXML
    protected void goToInitView(){
        Stage window = (Stage) initView.getScene().getWindow();
        window.setScene(BeatFlow.initScene);
    }
}
