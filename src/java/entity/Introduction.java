/**
 * copy right by FPT
 * Introduction.java
 * author DuyDV
 */
package entity;
/**
 * Introduction class<br>
 * <pre>
 * constructors default
 * constructor full parameter
 * getTitle
 * setTitle
 * getPicture
 * setPicture
 * getShortDescription
 * setShortDescription
 * getDetailDescription
 * setDetailDescription
 * </pre>
 * @author DuyDV
 */
public class Introduction {
    /**
     * store title, picture, shortDescription, detailDescription
     */
    private String title, picture, shortDescription, detailDescription;
/**
 * constructors default
 */
    public Introduction() {
    }
/**
 * constructor full parameter
 * @param title
 * @param picture
 * @param shortDescription
 * @param detailDescription 
 */
    public Introduction(String title, String picture, String shortDescription, String detailDescription) {
        this.title = title;
        this.picture = picture;
        this.shortDescription = shortDescription;
        this.detailDescription = detailDescription;
    }
/**
 * getTitle
 * @return title
 */
    public String getTitle() {
        return title;
    }
/**
 * setTitle
 * @param title 
 */
    public void setTitle(String title) {
        this.title = title;
    }
/**
 * getPicture
 * @return picture
 */
    public String getPicture() {
        return picture;
    }
/**
 * setPicture
 * @param picture 
 */
    public void setPicture(String picture) {
        this.picture = picture;
    }
/**
 * getShortDescription
 * @return shortDescription
 */
    public String getShortDescription() {
        return shortDescription;
    }
/**
 * setShortDescription
 * @param shortDescription 
 */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
/**
 * getDetailDescription
 * @return detailDescription
 */
    public String getDetailDescription() {
        return detailDescription;
    }
/**
 * setDetailDescription
 * @param detailDescription 
 */
    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }
    
}
