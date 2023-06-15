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
    private Label logo, labelOutp1,labelOutp2, labelOutp3, search, label1, label2, label3;
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
    String sorted = "unsorted";

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
    }
    @FXML
    protected void showDataLeft(){
        for (Song song : selectedPlayList){
            if (song.getTitle().equals(listViewLeft.getSelectionModel().getSelectedItem())){
                labelOutp1.setText(song.getTitle());
                labelOutp2.setText(song.getArtist().getArtistName());
                labelOutp3.setText(song.getKind());
            }
        }
    }
    protected void showDataSearch(){
        for(Song song : BeatFlow.library.getSongs()){

        }
    }
    @FXML
    protected void showDataRight(){
        int index = listViewRight.getSelectionModel().getSelectedIndex();
        // show data title
        Song song = selectedPlayList.get(index);
        labelOutp1.setText(song.getTitle());
        //Show data artis
        labelOutp2.setText(song.getArtist().getArtistName());
        //Show data kind
        labelOutp3.setText(song.getKind());
    }
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
                labelOutp2.setText(song.getArtist().getArtistName());
                labelOutp3.setText(song.getKind());
                break;
            } else if (song.getArtist().getArtistName().equals(textEnter.getText())) {
                listViewLeft.getItems().add(song.getTitle());
                labelOutp1.setText(song.getArtist().getFirstName());
                labelOutp2.setText(song.getArtist().getLastName());
                labelOutp3.setText(song.getKind());
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
}
