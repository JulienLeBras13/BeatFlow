package models;

import java.util.ArrayList;

/**
 * Class that represent the Playlist existing, this can be instantiated by the user and the admin.
 */
public class Playlist {
    private String name;
    private ArrayList<Song> playlist = new ArrayList<>();

    public Playlist(String name){
        this.name = name;
    }

    public ArrayList<Song> getPlaylist(){
        return this.playlist;
    }
}
