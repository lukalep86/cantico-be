// Generated with g9.

package com.cantico.profile.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name="notification_type")
public class NotificationType implements Serializable {

    /** Primary key. */
    protected static final String PK = "idNotificationType";

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
    @Column(name="id_notification_type", unique=true, nullable=false, precision=10)
    private int idNotificationType;
    @Column(nullable=false, length=100)
    private String name;
    @Column(nullable=false, length=255)
    private String description;

    /** Default constructor. */
    public NotificationType() {
        super();
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
     * Access method for description.
     *
     * @return the current value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for description.
     *
     * @param aDescription the new value for description
     */
    public void setDescription(String aDescription) {
        description = aDescription;
    }

    /**
     * Compares the key for this instance with another NotificationType.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class NotificationType and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof NotificationType)) {
            return false;
        }
        NotificationType that = (NotificationType) other;
        if (this.getIdNotificationType() != that.getIdNotificationType()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another NotificationType.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof NotificationType)) return false;
        return this.equalKeys(other) && ((NotificationType)other).equalKeys(this);
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
        i = getIdNotificationType();
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
        StringBuffer sb = new StringBuffer("[NotificationType |");
        sb.append(" idNotificationType=").append(getIdNotificationType());
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
        ret.put("idNotificationType", Integer.valueOf(getIdNotificationType()));
        return ret;
    }

}
