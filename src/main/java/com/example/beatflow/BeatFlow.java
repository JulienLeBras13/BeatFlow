package com.example.beatflow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Artist;
import models.Playlist;
import models.Song;
import models.Library;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;

public class BeatFlow extends Application {
    public static Library library = new Library();
    public static Playlist rock = new Playlist("Rock");
    public static Playlist electro = new Playlist("Electro");
    // TODO : generate the two playlist by reading "songs.csv"

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BeatFlow.class.getResource("InitView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1300, 900);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        String line;
        String splitBy = ";";

        // try-catch for reading "data/artists.csv" and create new Artist and add them to the ArrayList<Artist>
        try { //parsing a CSV file into BufferedReader class constructor
            BufferedReader brArtists = new BufferedReader(new FileReader("data/artists.csv"));
            brArtists.readLine();

            while ((line = brArtists.readLine()) != null) { //returns a Boolean value
                String[] buffedArtist = line.split(splitBy);    // use comma as separator
                library.getArtists().add(new Artist(buffedArtist[0], buffedArtist[1], buffedArtist[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Same as before but for the Song.
        try { //parsing a CSV file into BufferedReader class constructor
            BufferedReader brSongs = new BufferedReader(new FileReader("data/songs.csv"));
            brSongs.readLine();

            while ((line = brSongs.readLine()) != null) { //returns a Boolean value
                String[] buffedSong = line.split(splitBy);    // use comma as separator
                library.getSongs().add(new Song(buffedSong[0], buffedSong[1], findArtist(library.getArtists(), buffedSong[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test temp TODO : DELETE THIS TEST WHEN NO LONGER NEEDED !
        System.out.println("Test of the generation of the Library object.");
        System.out.println("");
        System.out.println("Title of the first song : " + library.getSongs().get(0).getTitle());
        System.out.println("Artist name of the first song : " + library.getSongs().get(0).getArtist().getArtistName());
        System.out.println("Kind of the 4th song : " + library.getSongs().get(3).getKind());
        System.out.println("Artist name of the 1st artist : " + library.getArtists().get(0).getArtistName());
        System.out.println("First name of the 2nd artist : " + library.getArtists().get(2).getFirstName());
    }

    /**
     * Function to find if the artist is already existing in the database, if not create a new one with the constructor "Artist(String artistName)"
     * and add it to the ArrayList<Artist> artists.
     * @param artists ArrayList<Artist> in which we are searching
     * @param artistName String of the artiste name that we need to find if he's existing
     * @return Artist with the corresponding artistName
     */
    private Artist findArtist (ArrayList<Artist> artists, String artistName){
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

    public static void main(String[] args) {
        launch();
    }
}