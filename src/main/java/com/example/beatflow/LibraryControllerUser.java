package com.example.beatflow;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import models.Artist;
import models.Playlist;
import models.Song;

import java.util.*;

public class LibraryControllerUser {
    @FXML
    private Label logo, dataTitle,dataNameArtist, dataKind , search;
    @FXML
    private Button buttonSearch, buttonAddToPlaylist, library, buttonNewPlaylist, actualizePlaylist, alphabeticalOrder;
    @FXML
    private TextField textEnter, nomPlaylist;
    @FXML
    private ListView<String> listViewLeft, playlists, listViewRight;
    private ArrayList<Song> selectedPlayList = new  ArrayList();
    private ArrayList<Song>  chargedPlaylist = new ArrayList<>();
    int indexOfSelectedPlaylist;
    @FXML
    private ArrayList<Artist> selectedMusic = new ArrayList() ;
    @FXML
    private Pane paneInformationMusic;
    @FXML
    protected void onTextFieldKeyPressed(){
       // creat a textField objet
       TextField textEnter = new TextField();
    }
    @FXML
    protected void onActualizePlaylist(){
        // actualize Playlist in listView
        playlists.getItems().clear();
        playlists.getItems().add("library");
        for (Playlist playlist : BeatFlow.library.getPlaylists()){
            playlists.getItems().add(playlist.getName());
        }
    }
   protected static void getSong(){
   }
    @FXML
    protected void showTitles() {
        // Display song in listview
        selectedPlayList.clear();
        listViewLeft.getItems().clear();
        String playlistName = playlists.getSelectionModel().getSelectedItem();
        //Display Library as default value
        if (playlistName.equals("library")) {
            selectedPlayList = (ArrayList<Song>) BeatFlow.library.getSongs().clone();
        } else {
            for (Playlist playlist : BeatFlow.library.getPlaylists()) {
                if (playlist.getName().equals(playlistName)) {
                    indexOfSelectedPlaylist = BeatFlow.library.getPlaylists().indexOf(playlist);
                    if (!playlist.getFix()){
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
        }
        //selection one itm
        for (Song song : selectedPlayList) {
            listViewLeft.getItems().add(song.getTitle());
        }
    }
    @FXML
    protected void showDataLeft(){
        int index = listViewLeft.getSelectionModel().getSelectedIndex();
        // show data title
        Song song = selectedPlayList.get(index);
        dataTitle.setText(song.getTitle());
        //Show data artis
        dataNameArtist.setText(song.getArtist().getArtistName());
        //Show data kind
        dataKind.setText(song.getKind());
    }
    @FXML
    protected void showDataRight(){
        int index = listViewRight.getSelectionModel().getSelectedIndex();
        // show data title
        Song song = selectedPlayList.get(index);
        dataTitle.setText(song.getTitle());
        //Show data artis
        dataNameArtist.setText(song.getArtist().getArtistName());
        //Show data kind
        dataKind.setText(song.getKind());
    }
    @FXML
    protected void search(){
        //clear listviews
        listViewLeft.getItems().clear();
        listViewRight.getItems().clear();

        String findedSong = textEnter.getText().toString();
        // searching song in listview
        if (BeatFlow.findSong(BeatFlow.library.getSongs(), findedSong) != null) {
            listViewLeft.getItems().add(listViewLeft.getItems().size(),textEnter.getText());
        }
        // code for empty textField
        else if (textEnter.getText().trim().isEmpty()){
            selectedPlayList.clear();
            selectedPlayList = (ArrayList<Song>) BeatFlow.library.getSongs().clone();
            for (Song song : selectedPlayList){
                listViewLeft.getItems().add(song.getTitle());
            }
        }
    }
    @FXML
    protected void CreatNewPlaylist(){
        BeatFlow.library.getPlaylists().add(new Playlist(nomPlaylist.getText()));
    }
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
}
