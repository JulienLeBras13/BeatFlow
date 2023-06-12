package models;

import java.util.ArrayList;

/**
 * Class that represent the database of all the songs and artists present on the corresponding .csv files.
 */
public class Library {
    private ArrayList<Song> songs = new ArrayList<>();
    private ArrayList<Artist> artists = new ArrayList<>();
    private ArrayList<Playlist> playlists = new ArrayList<>();

    public ArrayList<Artist> getArtists(){
        return this.artists;
    }
    public ArrayList<Song> getSongs(){
        return this.songs;
    }

    public ArrayList<Playlist> getPlaylists(){
        return this.playlists;
    }
}
