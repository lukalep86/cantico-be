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

@Entity(name="event_frequency")
public class EventFrequency implements Serializable {

    /** Primary key. */
    protected static final String PK = "idEventFrequency";

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
    @Column(name="id_event_frequency", unique=true, nullable=false, precision=10)
    private int idEventFrequency;
    @Column(nullable=false, length=100)
    private String name;
    @Column(nullable=false, length=255)
    private String description;

    /** Default constructor. */
    public EventFrequency() {
        super();
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
     * Compares the key for this instance with another EventFrequency.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class EventFrequency and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof EventFrequency)) {
            return false;
        }
        EventFrequency that = (EventFrequency) other;
        if (this.getIdEventFrequency() != that.getIdEventFrequency()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another EventFrequency.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof EventFrequency)) return false;
        return this.equalKeys(other) && ((EventFrequency)other).equalKeys(this);
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
        i = getIdEventFrequency();
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
        StringBuffer sb = new StringBuffer("[EventFrequency |");
        sb.append(" idEventFrequency=").append(getIdEventFrequency());
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
        ret.put("idEventFrequency", Integer.valueOf(getIdEventFrequency()));
        return ret;
    }

}
