package models;

import java.util.ArrayList;

/**
 * Class that represent the Playlist existing, this can be instantiated by the user and the admin.
 */
public class Playlist {
    private String name;
    private Boolean fix = false;
    private ArrayList<Song> playlist = new ArrayList<>();

    public Playlist(String name){
        this.name = name;
    }
    public Playlist(String name, Boolean fix){
        this.name = name;
        this.fix = fix;
    }

    public ArrayList<Song> getPlaylist(){
        return this.playlist;
    }

    public String getName() {
        return name;
    }

    public Boolean getFix(){
        return this.fix;
    }
}
