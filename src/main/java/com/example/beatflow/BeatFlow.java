package com.example.beatflow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.*;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Main of the application, read the .csv files and create all Object and ArrayList<> useful for the application, call the InitView
 */
public class BeatFlow extends Application {
    public static Library library = new Library();
    public static Playlist rock = new Playlist("Rock", true);
    public static Playlist electro = new Playlist("Electro", true);
    public static ArrayList<Account> accounts = new ArrayList<>();

    static Scene initScene, userScene, adminScene;

    // Views size declaration
    int viewSizeX = 1100;
    int viewSizeY = 900;

    @Override
    public void start(Stage stage) throws IOException {
        // InitScene
        FXMLLoader fxmlLoaderInitScene = new FXMLLoader(BeatFlow.class.getResource("InitView.fxml"));
        initScene = new Scene(fxmlLoaderInitScene.load(), 750, 450);

        // AdminScene
        FXMLLoader fxmlLoaderAdminScene = new FXMLLoader(BeatFlow.class.getResource("LibraryViewAdmin.fxml"));
        adminScene = new Scene(fxmlLoaderAdminScene.load(), viewSizeX, viewSizeY);

        // UserScene
        FXMLLoader fxmlLoaderUserScene = new FXMLLoader(BeatFlow.class.getResource("LibraryViewUser.fxml"));
        userScene = new Scene(fxmlLoaderUserScene.load(), viewSizeX, viewSizeY);

        stage.setTitle("BeatFlow");
        stage.setScene(initScene);
        stage.show();

        String line;
        String splitBy = ";";

        // try-catch for reading "data/accounts.csv" and add them to the ArrayList<Artist>
        try {
            BufferedReader brAccounts = new BufferedReader(new FileReader("data/accounts.csv"));
            brAccounts.readLine();

            while ((line = brAccounts.readLine()) != null) {
                boolean admin;
                String[] buffedAccount = line.split(splitBy);
                if (buffedAccount[2].equals("true")){
                    admin = true;
                } else {
                    admin = false;
                }
                accounts.add(new Account(buffedAccount[0], buffedAccount[1], admin));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try-catch for reading "data/artists.csv" and create new Artist and add them to the ArrayList<Artist>
        try {
            BufferedReader brArtists = new BufferedReader(new FileReader("data/artists.csv"));
            brArtists.readLine();

            while ((line = brArtists.readLine()) != null) {
                String[] buffedArtist = line.split(splitBy);
                library.getArtists().add(new Artist(buffedArtist[0], buffedArtist[1], buffedArtist[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Same as before but for the Song.
        try {
            BufferedReader brSongs = new BufferedReader(new FileReader("data/songs.csv"));
            brSongs.readLine();

            while ((line = brSongs.readLine()) != null) {
                String[] buffedSong = line.split(splitBy);
                library.getSongs().add(new Song(buffedSong[0], buffedSong[1], findArtist(library.getArtists(), buffedSong[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Artist artist : library.getArtists()) {
            for (Song song : library.getSongs()) {
                if (song.getArtist().getArtistName().equals(artist.getArtistName())){
                    artist.getSongs().add(song);
                }
            }
        }

        for (Song song : library.getSongs()) {
            if (song.getKind().equals("Rock")){
                rock.getPlaylist().add(song);
            }
        }

        for (Song song : library.getSongs()) {
            if (song.getKind().equals("Electro")){
                electro.getPlaylist().add(song);
            }
        }

        library.getPlaylists().add(rock);
        library.getPlaylists().add(electro);

    }

    /**
     * Function to find if the artist is already existing in the database, if not create a new one with the constructor "Artist(String artistName)"
     * and add it to the ArrayList<Artist> artists.
     * @param artists ArrayList<Artist> in which we are searching
     * @param artistName String of the artist name that we need to find if he's existing
     * @return Artist with the corresponding artistName or a new one
     */
    public static Artist findArtist (ArrayList<Artist> artists, String artistName){
        Artist returnedArtist;
        ArrayList<String> namesList = new ArrayList<>();

        for (Artist artist : artists) {
            namesList.add(artist.getArtistName());
        }

        if (namesList.contains(artistName)){
            returnedArtist = artists.get(namesList.indexOf(artistName));
        } else {
            returnedArtist = new Artist(artistName);
            artists.add(returnedArtist);
        }

        return returnedArtist;
    }

    /**
     * Function to find if the song is existing in the database
     * @param songs : ArrayList<Song> in witch the song is searched
     * @param title : String of the title of the song searched
     * @return the searched song
     */
    public static Song findSong (ArrayList<Song> songs, String title) {
        Song returnedSong = null;
        ArrayList<String> titlesList = new ArrayList<>();

        for (Song song : songs) {
            titlesList.add(song.getTitle());
        }

        if (titlesList.contains(title)) {
            returnedSong = songs.get(titlesList.indexOf(title));
        }

        return returnedSong;
    }

    public static void main(String[] args) {
        launch();
    }
}