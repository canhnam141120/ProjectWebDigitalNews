
package entity;

import java.sql.Timestamp;


public class News {

    private int id;
    private String title;
    private String content;
    private String description;
    private String image;
    private Timestamp time;
    private String author;
    

    /**
     * Return Id of Article
     * @return Article's id.. It is a <code>int</code> data.
     */
    public int getId() {
        return id;
    }

    /**
     * Set Id for Article
     * @param id.. It is a <code>int</code> data.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return Article's title
     * @return Article's id.. It is a <code>String</code> object.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title for article
     * @param title.. It is a <code>String</code> object.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Return Article's title
     * @return Article's content.. It is a <code>String</code> object.
     */
    public String getContent() {
        return String.join("<br/>", content.split("\n"));
    }

    /**
     * Set content for article
     * @param content.. It is a <code>String</code> object.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Return Article's description
     * @return Article's description.. It is a <code>String</code> object.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description for article
     * @param description.. It is a <code>String</code> object.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Return Article's image
     * @return Article's image.. It is a <code>String</code> object.
     */
    public String getImage() {
        return image;
    }

    /**
     * Set image for article
     * @param image.. It is a <code>String</code> object.
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Return Article's time
     * @return Article's time.. It is a <code>java.sql.Timestamp</code> object.
     */
    public Timestamp getTime() {
        return time;
    }

    /**
     * Set time for article
     * @param time.. It is a <code>java.sql.Timestamp</code> object.
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * Return Article's Author
     * @return Article's author.. It is a <code>String</code> object.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set author for article
     * @param author.. It is a <code>String</code> object.
     */
    public void setAuthor(String author) {
        this.author = author;
    }
}
