package models;

import java.util.ArrayList;

/**
 * CLass for Song type objects
 */
public class Song extends Media{
    private ArrayList<String> album;
    private Artist artist;
    // TODO : Find the type of link for the media (mp3, ...)

    /**
     * Constructor
     * @param title = title of the song
     * Initialize the value of the attribute "type" at "Song" => Type of the media
     */
    public Song(String title, String kind){
        super(title);
        this.type = "Song";
        this.kind = kind;
    }

    public void setAlbum(String album) {
        this.album.add(album);
    }
    // TODO : Think about the fact many songs can have the same artist ! So define precisely the setter of the artist attribute
    public void setArtist(String firstName, String lastName, String artistName){
        this.artist = new Artist(firstName, lastName, artistName);
    }

    public ArrayList<String> getAlbum() {
        return album;
    }

}