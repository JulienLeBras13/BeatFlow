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
    private TextField textEnter;
    @FXML
    private ListView<String> listViewTitle, playlists;
    private ArrayList<Song> selectedPlayList = new  ArrayList();
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
        listViewTitle.getItems().clear();
        String playlistName = playlists.getSelectionModel().getSelectedItem();
        int index;

        if (playlistName.equals("library")) {
            selectedPlayList = (ArrayList<Song>) BeatFlow.library.getSongs().clone();
        } else {
            for (Playlist playlist : BeatFlow.library.getPlaylists()) {
                if (playlist.getName().equals(playlistName)) {
                    selectedPlayList = (ArrayList<Song>) BeatFlow.library.getPlaylists().get(BeatFlow.library.getPlaylists().indexOf(playlist)).getPlaylist().clone();
                    break;
                }
            }
        }

        //selection one itm
        for (Song song : selectedPlayList) {
            listViewTitle.getItems().add(song.getTitle());
        }
    }
    @FXML
    protected void showData(){
        int index; // = selectedPlayList.indexOf(listViewTitle.getSelectionModel());

        for (Song song : selectedPlayList){
            if (song.getTitle().equals(listViewTitle.getSelectionModel().getSelectedItem())){
                dataTitle.setText(song.getTitle());
                dataNameArtist.setText(song.getArtist().getArtistName());
                dataKind.setText(song.getKind());
            }
        }
        /*
        // show data title
        Song song = selectedPlayList.get(index);
        dataTitle.setText(song.getTitle());
        //Show data artis
        dataNameArtist.setText(song.getArtist().getArtistName());
        //Show data kind
        dataKind.setText(song.getKind());*/

    }
    @FXML
    protected void search(){
        // compare value inputUser to value in Playlist
        // Display song in listview
        selectedPlayList.clear();
        Song findedSong = BeatFlow.findSong(selectedPlayList, textEnter.getText());
    }
    @FXML
    protected void CreatNewPlaylist(){
    }
    @FXML
    protected void AddInPlaylist(){
    }

    @FXML
    protected void alphabeticalOrder(){
        switch (sorted){
            case "Sorted" :
                Collections.sort(listViewTitle.getItems(), Collections.reverseOrder());
                sorted = "ReverseOrder";
                break;
            default :
                Collections.sort(listViewTitle.getItems());
                sorted = "Sorted";
        }

    }
}
