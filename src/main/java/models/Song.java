package models;

import java.util.ArrayList;

/**
 * CLass for Song type objects
 */
public class Song{

    private String title, kind, imagePath, mp3Path;
    // TODO : Find the type of link for the media (mp3, ...) (optional)
    // TODO : Define how to link an attribute of a song to an image (ex : String "path to the image" ?)
    private Artist artist;


    /**
     * Constructor
     * @param title = title of the song
     * Initialize the value of the attribute "type" at "Song" => Type of the media
     */
    public Song(String title, String kind, Artist artist){
        this.title = title;
        this.kind = kind;
        this.artist = artist;
    }

    public void setArtist(Artist artist){
        this.artist = artist;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTitle() {
        return title;
    }

    public String getKind() {
        return kind;
    }

    public Artist getArtist() {
        return artist;
    }
}
