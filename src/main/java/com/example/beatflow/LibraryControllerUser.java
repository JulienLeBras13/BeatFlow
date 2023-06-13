package com.example.beatflow;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import models.Artist;
import models.Library;
import models.Song;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryControllerUser {
    @FXML
    private Label logo, dataTitle,dataNameArtist, search;
    @FXML
    private Button buttonSearch, buttonAddToPlaylist, library, buttonNewPlaylist;
    @FXML
    private TextField textEnter;
    @FXML
    private ListView<String> listViewTitle;
    @FXML
    public static ListView<String> Playlists;
    private ArrayList<Song> selectedPlayList;
    @FXML
    private ArrayList<Artist> selectedMusic = new ArrayList() ;
    @FXML
    private Pane paneInformationMusic;
    @FXML
    protected void onTextFieldKeyPressed(){
       // creat a textField objet
       TextField textEnter = new TextField();
    }
   protected static void getSong(){
   }
    @FXML
    protected void showLibraryTitles() {
       // Display song in listview
        selectedPlayList.clear();
        selectedPlayList = (ArrayList<Song>) BeatFlow.library.getSongs().clone();
        //selection one itm
        for (Song song : selectedPlayList) {
            listViewTitle.getItems().add(song.getTitle());
        }
    }

    @FXML
    protected void showData(){
        int index = listViewTitle.getSelectionModel().getSelectedIndex();
        // show data title
        Song song = selectedPlayList.get(index);
        dataTitle.setText(song.getTitle());
        //Show data artis
        Artist artist = selectedMusic.get(index);
        dataNameArtist.setText(artist.getArtistName());
    }
    /*@FXML
    protected void search(){
        // compare value inputUser to value in Playlist
    for(String item : Playlists.getItems()){
        if(item.toLowerCase().contains((CharSequence) textEnter)){
            listViewTitle.getItems().add(item);
        }
    }
    }*/
    @FXML
    protected void CreatNewPlaylist(){
    }
    @FXML
    protected void AddInPlaylist(){
    }
    /*protected void OnClickSort(){
        // get the reference of the listView
        ObservableList<String> items = FXCollections.observableArrayList();
        // Sort the items
        FXCollections.sort(items, Comparator.naturalOrder());
        // set the sorted items to the listView
        listViewTitle.setItems(items);
    }*/
}
