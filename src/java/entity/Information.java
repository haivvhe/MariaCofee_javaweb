/**
 * copy right by FPT
 * Information.java
 * author DuyDV
 */
package entity;

/**
 * Information class<br>
 * <pre>
 * constructors default
 * constructor full parameter
 * getShortDescription
 * getShortDescription
 * getAddress
 * setAddress
 * getTel
 * setTel
 * getEmail
 * setEmail
 * getOpeningHours
 * setOpeningHours
 * getSignature
 * setSignature
 * </pre>
 * @author DuyDV
 */
public class Information {
    /**
     * store shortDescription, address, tel, email, openingHours, signature
     */
    private String shortDescription, address, tel, email, openingHours, signature;
/**
 * constructors default
 */
    public Information() {
    }
/**
 * constructor full parameter
 * @param shortDescription
 * @param address
 * @param tel
 * @param email
 * @param openingHours
 * @param signature 
 */
    public Information(String shortDescription, String address, String tel, String email, String openingHours, String signature) {
        this.shortDescription = shortDescription;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.openingHours = openingHours;
        this.signature = signature;
    }
/**
 * getShortDescription
 * @return shortDescription
 */
    public String getShortDescription() {
        return shortDescription;
    }
/**
 * getShortDescription
 * @param shortDescription 
 */
    public void getShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
/**
 * getAddress
 * @return address
 */
    public String getAddress() {
        return address;
    }
/**
 * setAddress
 * @param address 
 */
    public void setAddress(String address) {
        this.address = address;
    }
/**
 * getTel
 * @return tel
 */
    public String getTel() {
        return tel;
    }
/**
 * setTel
 * @param tel 
 */
    public void setTel(String tel) {
        this.tel = tel;
    }
/**
 * getEmail
 * @return email
 */
    public String getEmail() {
        return email;
    }
/**
 * setEmail
 * @param email 
 */
    public void setEmail(String email) {
        this.email = email;
    }
/**
 * getOpeningHours
 * @return openingHours
 */
    public String getOpeningHours() {
        return openingHours;
    }
/**
 * setOpeningHours
 * @param openingHours 
 */
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }
/**
 * getSignature
 * @return signature
 */
    public String getSignature() {
        return signature;
    }
/**
 * setSignature
 * @param signature 
 */
    public void setSignature(String signature) {
        this.signature = signature;
    }
    
}
