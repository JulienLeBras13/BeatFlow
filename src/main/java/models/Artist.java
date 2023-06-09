package models;

import java.util.ArrayList;

/**
 * Class Artist that define the firstname, lastname and the artist name.
 */
public class Artist {
    private String firstName, lastName, artistName;
    private ArrayList<Song> songs = new ArrayList<>();

    public Artist (String artistName, String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.artistName = artistName;
    }
    public Artist (String artistName){
        this.artistName = artistName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getArtistName() {
        return this.artistName;
    }
    public ArrayList<Song> getSongs(){
        return this.songs;
    }
}
