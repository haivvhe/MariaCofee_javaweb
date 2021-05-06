/**
 * copy right by FPT
 * Cake.java
 * author DuyDV
 */
package entity;
/**
 * Cake class<br>
 * <pre>
 * constructors default
 * constructor full parameter
 * getId
 * setId
 * getName
 * setName
 * getPicture
 * setPicture
 * getShortDescription
 * setShortDescription
 * getDetailDescription
 * setDetailDescription
 * getPrice
 * setPrice
 * </pre>
 * @author DuyDV
 */
public class Cake {
    /**
     * store id
     */
    private int id;
    /**
     * store name, picture, shortDescription, detailDescription
     */
    private String name, picture, shortDescription, detailDescription;
    /**
     * store price
     */
    private String price;
/**
 * constructors default
 */
    public Cake() {
    }
    /**
     * constructor full parameter
     * @param id
     * @param name
     * @param picture
     * @param shortDescription
     * @param detailDescription
     * @param price 
     */
    public Cake(int id, String name, String picture, String shortDescription, String detailDescription, String price) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.shortDescription = shortDescription;
        this.detailDescription = detailDescription;
        this.price = price;
    }
/**
 * getId
 * @return id
 */
    public int getId() {
        return id;
    }
/**
 * setId
 * @param id 
 */
    public void setId(int id) {
        this.id = id;
    }
/**
 * getName
 * @return name
 */
    public String getName() {
        return name;
    }
/**
 * setName
 * @param name 
 */
    public void setName(String name) {
        this.name = name;
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
/**
 * getPrice
 * @return price
 */
    public String getPrice() {
        return price;
    }
/**
 * setPrice
 * @param price 
 */
    public void setPrice(String price) {
        this.price = price;
    }

   
    
    
}
