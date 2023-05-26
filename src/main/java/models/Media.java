package models;

/**
 * Abstract class representing medias
 */
public abstract class Media {
    /* Attributes :
    title = name of the object
    kind = kind of the object (rock, rap, classic, pop, etc...)
     */
    public String title, type, kind;

    /**
     * Constructor
     * @param title = the title of the media
     */
    public Media (String title){
        this.title = title;
    }
}
