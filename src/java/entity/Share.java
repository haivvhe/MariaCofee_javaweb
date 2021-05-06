/**
 * copy right by FPT
 * Share.java
 * author DuyDV
 */
package entity;
/**
 * share class<br>
 * <pre>
 * constructors default
 * constructor full parameter
 * getIcon
 * setIcon
 * getSocialNetwork
 * setSocialNetwork
 * getURL
 * setURL
 * </pre>
 * @author DuyDV
 */
public class Share {
    /**
     * store icon, socialNetwork, url
     */
    private String icon, socialNetwork, url;
/**
 * constructors default
 */
    public Share() {
    }
/**
 * constructor full parameter
 * @param icon
 * @param socialNetwork
 * @param url 
 */
    public Share(String icon, String socialNetwork, String url) {
        this.icon = icon;
        this.socialNetwork = socialNetwork;
        this.url = url;
    }
/**
 * getIcon
 * @return icon
 */
    public String getIcon() {
        return icon;
    }
/**
 * setIcon
 * @param icon 
 */
    public void setIcon(String icon) {
        this.icon = icon;
    }
/**
 * getSocialNetwork
 * @return socialNetwork
 */
    public String getSocialNetwork() {
        return socialNetwork;
    }
/**
 * setSocialNetwork
 * @param socialNetwork 
 */
    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }
/**
 * getURL
 * @return url
 */
    public String getURL() {
        return url;
    }
/**
 * setURL
 * @param URL 
 */
    public void setURL(String URL) {
        this.url = URL;
    }
    
}
