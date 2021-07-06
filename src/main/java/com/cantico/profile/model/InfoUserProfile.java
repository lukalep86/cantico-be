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
import javax.persistence.Version;

@Entity(name="info_user_profile")
public class InfoUserProfile implements Serializable {

    /** Primary key. */
    protected static final String PK = "idInfoUserProfile";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="LOCK_FLAG")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_info_user_profile", unique=true, nullable=false, precision=19)
    private long idInfoUserProfile;
    @Column(name="id_user_profile", nullable=false, precision=19)
    private long idUserProfile;
    @Column(name="id_event_frequency", nullable=false, precision=10)
    private int idEventFrequency;
    @Column(name="id_viewer", nullable=false, precision=10)
    private int idViewer;
    @Column(name="opera_type", length=1024)
    private String operaType;
    @Column(name="purhasing_opera_items", length=1024)
    private String purhasingOperaItems;
    @Column(name="id_meet_platform", nullable=false, precision=10)
    private int idMeetPlatform;
    @Column(length=1024)
    private String hobby;
    @Column(name="date_insert", nullable=false)
    private LocalDateTime dateInsert;
    @Column(name="date_modify")
    private LocalDateTime dateModify;

    /** Default constructor. */
    public InfoUserProfile() {
        super();
    }

    /**
     * Access method for idInfoUserProfile.
     *
     * @return the current value of idInfoUserProfile
     */
    public long getIdInfoUserProfile() {
        return idInfoUserProfile;
    }

    /**
     * Setter method for idInfoUserProfile.
     *
     * @param aIdInfoUserProfile the new value for idInfoUserProfile
     */
    public void setIdInfoUserProfile(long aIdInfoUserProfile) {
        idInfoUserProfile = aIdInfoUserProfile;
    }

    /**
     * Access method for idUserProfile.
     *
     * @return the current value of idUserProfile
     */
    public long getIdUserProfile() {
        return idUserProfile;
    }

    /**
     * Setter method for idUserProfile.
     *
     * @param aIdUserProfile the new value for idUserProfile
     */
    public void setIdUserProfile(long aIdUserProfile) {
        idUserProfile = aIdUserProfile;
    }

    /**
     * Access method for idEventFrequency.
     *
     * @return the current value of idEventFrequency
     */
    public int getIdEventFrequency() {
        return idEventFrequency;
    }

    /**
     * Setter method for idEventFrequency.
     *
     * @param aIdEventFrequency the new value for idEventFrequency
     */
    public void setIdEventFrequency(int aIdEventFrequency) {
        idEventFrequency = aIdEventFrequency;
    }

    /**
     * Access method for idViewer.
     *
     * @return the current value of idViewer
     */
    public int getIdViewer() {
        return idViewer;
    }

    /**
     * Setter method for idViewer.
     *
     * @param aIdViewer the new value for idViewer
     */
    public void setIdViewer(int aIdViewer) {
        idViewer = aIdViewer;
    }

    /**
     * Access method for operaType.
     *
     * @return the current value of operaType
     */
    public String getOperaType() {
        return operaType;
    }

    /**
     * Setter method for operaType.
     *
     * @param aOperaType the new value for operaType
     */
    public void setOperaType(String aOperaType) {
        operaType = aOperaType;
    }

    /**
     * Access method for purhasingOperaItems.
     *
     * @return the current value of purhasingOperaItems
     */
    public String getPurhasingOperaItems() {
        return purhasingOperaItems;
    }

    /**
     * Setter method for purhasingOperaItems.
     *
     * @param aPurhasingOperaItems the new value for purhasingOperaItems
     */
    public void setPurhasingOperaItems(String aPurhasingOperaItems) {
        purhasingOperaItems = aPurhasingOperaItems;
    }

    /**
     * Access method for idMeetPlatform.
     *
     * @return the current value of idMeetPlatform
     */
    public int getIdMeetPlatform() {
        return idMeetPlatform;
    }

    /**
     * Setter method for idMeetPlatform.
     *
     * @param aIdMeetPlatform the new value for idMeetPlatform
     */
    public void setIdMeetPlatform(int aIdMeetPlatform) {
        idMeetPlatform = aIdMeetPlatform;
    }

    /**
     * Access method for hobby.
     *
     * @return the current value of hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * Setter method for hobby.
     *
     * @param aHobby the new value for hobby
     */
    public void setHobby(String aHobby) {
        hobby = aHobby;
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
     * Compares the key for this instance with another InfoUserProfile.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class InfoUserProfile and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof InfoUserProfile)) {
            return false;
        }
        InfoUserProfile that = (InfoUserProfile) other;
        if (this.getIdInfoUserProfile() != that.getIdInfoUserProfile()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another InfoUserProfile.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof InfoUserProfile)) return false;
        return this.equalKeys(other) && ((InfoUserProfile)other).equalKeys(this);
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
        i = (int)(getIdInfoUserProfile() ^ (getIdInfoUserProfile()>>>32));
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
        StringBuffer sb = new StringBuffer("[InfoUserProfile |");
        sb.append(" idInfoUserProfile=").append(getIdInfoUserProfile());
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
        ret.put("idInfoUserProfile", Long.valueOf(getIdInfoUserProfile()));
        return ret;
    }

}
