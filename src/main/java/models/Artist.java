package models;

/**
 * Class Artist that define the firstname, lastname and the artist name.
 */
public class Artist {
    private String firstName, lastName, artistName;

    public Artist (String firstName, String lastName, String artistName){
        this.firstName = firstName;
        this.lastName = lastName;
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
        return artistName;
    }
}
