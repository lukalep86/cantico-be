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

@Entity(name="notification")
public class Notification implements Serializable {

    /** Primary key. */
    protected static final String PK = "idNotification";

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
    @Column(name="id_notification", unique=true, nullable=false, precision=19)
    private long idNotification;
    @Column(name="id_user_profile", nullable=false, precision=19)
    private long idUserProfile;
    @Column(name="id_notification_type", nullable=false, precision=10)
    private int idNotificationType;
    @Column(name="date_insert", nullable=false)
    private LocalDateTime dateInsert;
    @Column(name="date_modify")
    private LocalDateTime dateModify;
    @Column(nullable=false, precision=3)
    private short enable;

    /** Default constructor. */
    public Notification() {
        super();
    }

    /**
     * Access method for idNotification.
     *
     * @return the current value of idNotification
     */
    public long getIdNotification() {
        return idNotification;
    }

    /**
     * Setter method for idNotification.
     *
     * @param aIdNotification the new value for idNotification
     */
    public void setIdNotification(long aIdNotification) {
        idNotification = aIdNotification;
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
     * Access method for idNotificationType.
     *
     * @return the current value of idNotificationType
     */
    public int getIdNotificationType() {
        return idNotificationType;
    }

    /**
     * Setter method for idNotificationType.
     *
     * @param aIdNotificationType the new value for idNotificationType
     */
    public void setIdNotificationType(int aIdNotificationType) {
        idNotificationType = aIdNotificationType;
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
     * Access method for enable.
     *
     * @return the current value of enable
     */
    public short getEnable() {
        return enable;
    }

    /**
     * Setter method for enable.
     *
     * @param aEnable the new value for enable
     */
    public void setEnable(short aEnable) {
        enable = aEnable;
    }

    /**
     * Compares the key for this instance with another Notification.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Notification and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Notification)) {
            return false;
        }
        Notification that = (Notification) other;
        if (this.getIdNotification() != that.getIdNotification()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Notification.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Notification)) return false;
        return this.equalKeys(other) && ((Notification)other).equalKeys(this);
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
        i = (int)(getIdNotification() ^ (getIdNotification()>>>32));
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
        StringBuffer sb = new StringBuffer("[Notification |");
        sb.append(" idNotification=").append(getIdNotification());
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
        ret.put("idNotification", Long.valueOf(getIdNotification()));
        return ret;
    }

}
