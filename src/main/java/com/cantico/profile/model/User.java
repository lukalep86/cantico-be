// Generated with g9.

package com.cantico.profile.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = -1822040761622093370L;

	/** Primary key. */
    protected static final String PK = "idUser";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_user", unique=true, nullable=false, precision=19)
    private long idUser;
    @Column(nullable=false, length=255)
    private String name;
    @Column(nullable=false, length=255)
    private String surname;
    @Column(nullable=false, length=25)
    private String gender;
    @Column(name="fiscal_code", nullable=false, length=100)
    private String fiscalCode;
    @Column(nullable=false, length=255)
    private String address;
    @Column(nullable=false, length=255)
    private String city;
    @Column(nullable=false, length=255)
    private String province;
    @Column(nullable=false, length=100)
    private String country;
    @Column(name="postal_code", nullable=false, length=100)
    private String postalCode;
    @Column(nullable=false, length=100)
    private String email;
    @Column(nullable=false, length=100)
    private String telephone;
    @Column(name="date_insert", nullable=false)
    private LocalDateTime dateInsert;
    @Column(name="date_modify")
    private LocalDateTime dateModify;
    @Column(nullable=false, length=100)
    private String username;
    @Column(nullable=false, length=100)
    private String password;
    @Column(nullable=false, precision=3)
    private short enabled;

    /** Default constructor. */
    public User() {
        super();
    }

    /**
     * Access method for idUser.
     *
     * @return the current value of idUser
     */
    public long getIdUser() {
        return idUser;
    }

    /**
     * Setter method for idUser.
     *
     * @param aIdUser the new value for idUser
     */
    public void setIdUser(long aIdUser) {
        idUser = aIdUser;
    }

    /**
     * Access method for name.
     *
     * @return the current value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name.
     *
     * @param aName the new value for name
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * Access method for surname.
     *
     * @return the current value of surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Setter method for surname.
     *
     * @param aSurname the new value for surname
     */
    public void setSurname(String aSurname) {
        surname = aSurname;
    }

    /**
     * Access method for gender.
     *
     * @return the current value of gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Setter method for gender.
     *
     * @param aGender the new value for gender
     */
    public void setGender(String aGender) {
        gender = aGender;
    }

    /**
     * Access method for fiscalCode.
     *
     * @return the current value of fiscalCode
     */
    public String getFiscalCode() {
        return fiscalCode;
    }

    /**
     * Setter method for fiscalCode.
     *
     * @param aFiscalCode the new value for fiscalCode
     */
    public void setFiscalCode(String aFiscalCode) {
        fiscalCode = aFiscalCode;
    }

    /**
     * Access method for address.
     *
     * @return the current value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for address.
     *
     * @param aAddress the new value for address
     */
    public void setAddress(String aAddress) {
        address = aAddress;
    }

    /**
     * Access method for city.
     *
     * @return the current value of city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter method for city.
     *
     * @param aCity the new value for city
     */
    public void setCity(String aCity) {
        city = aCity;
    }

    /**
     * Access method for province.
     *
     * @return the current value of province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Setter method for province.
     *
     * @param aProvince the new value for province
     */
    public void setProvince(String aProvince) {
        province = aProvince;
    }

    /**
     * Access method for country.
     *
     * @return the current value of country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter method for country.
     *
     * @param aCountry the new value for country
     */
    public void setCountry(String aCountry) {
        country = aCountry;
    }

    /**
     * Access method for postalCode.
     *
     * @return the current value of postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Setter method for postalCode.
     *
     * @param aPostalCode the new value for postalCode
     */
    public void setPostalCode(String aPostalCode) {
        postalCode = aPostalCode;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for telephone.
     *
     * @return the current value of telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Setter method for telephone.
     *
     * @param aTelephone the new value for telephone
     */
    public void setTelephone(String aTelephone) {
        telephone = aTelephone;
    }

    /**
     * Access method for dateInsert.
     *
     * @return the current value of dateInsert
     */
    public LocalDateTime getDateInsert() {
        return dateInsert;
    }

    /**
     * Setter method for dateInsert.
     *
     * @param aDateInsert the new value for dateInsert
     */
    public void setDateInsert(LocalDateTime aDateInsert) {
        dateInsert = aDateInsert;
    }

    /**
     * Access method for dateModify.
     *
     * @return the current value of dateModify
     */
    public LocalDateTime getDateModify() {
        return dateModify;
    }

    /**
     * Setter method for dateModify.
     *
     * @param aDateModify the new value for dateModify
     */
    public void setDateModify(LocalDateTime aDateModify) {
        dateModify = aDateModify;
    }

    /**
     * Access method for username.
     *
     * @return the current value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for username.
     *
     * @param aUsername the new value for username
     */
    public void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * Access method for enabled.
     *
     * @return the current value of enabled
     */
    public short getEnabled() {
        return enabled;
    }

    /**
     * Setter method for enabled.
     *
     * @param aEnabled the new value for enabled
     */
    public void setEnabled(short aEnabled) {
        enabled = aEnabled;
    }

    /**
     * Compares the key for this instance with another User.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class User and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User that = (User) other;
        if (this.getIdUser() != that.getIdUser()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another User.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof User)) return false;
        return this.equalKeys(other) && ((User)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getIdUser() ^ (getIdUser()>>>32));
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[User |");
        sb.append(" idUser=").append(getIdUser());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("idUser", Long.valueOf(getIdUser()));
        return ret;
    }

}
