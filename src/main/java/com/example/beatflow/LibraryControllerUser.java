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
    private ListView<String> listViewTitle, playlists, listViewRight;
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
        listViewTitle.getItems().clear();
        String playlistName = playlists.getSelectionModel().getSelectedItem();

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

        listViewRight.getItems().clear();
        if (!BeatFlow.library.getPlaylists().get(indexOfSelectedPlaylist).getFix()) {
            for (Song song : chargedPlaylist) {
                listViewRight.getItems().add(song.getTitle());
            }
        }
        //selection one itm
        for (Song song : selectedPlayList) {
            listViewTitle.getItems().add(song.getTitle());
        }
    }
    @FXML
    protected void showDataLeft(){
        int index = listViewTitle.getSelectionModel().getSelectedIndex();
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
        // compare value inputUser to value in Playlist
        // Display song in listview
        selectedPlayList.clear();
        Song findedSong = BeatFlow.findSong(selectedPlayList, textEnter.getText());
    }
    @FXML
    protected void CreatNewPlaylist(){
        BeatFlow.library.getPlaylists().add(new Playlist(nomPlaylist.getText()));
    }
    @FXML
    protected void AddInPlaylist(){
        if (!BeatFlow.library.getPlaylists().get(indexOfSelectedPlaylist).getFix()) {
            listViewRight.getItems().clear();
            for (Song song : selectedPlayList) {
                if (song.getTitle().equals(listViewTitle.getSelectionModel().getSelectedItem())) {
                    BeatFlow.library.getPlaylists().get(indexOfSelectedPlaylist).getPlaylist().add(song);
                    chargedPlaylist = BeatFlow.library.getPlaylists().get(indexOfSelectedPlaylist).getPlaylist();
                }
            }
            for (Song song : chargedPlaylist) {
                listViewRight.getItems().add(song.getTitle());
            }
        }
    }

}
