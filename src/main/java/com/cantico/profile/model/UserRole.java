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

@Entity(name="user_role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = -231283524302033553L;

	/** Primary key. */
    protected static final String PK = "idUserRole";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_user_role", unique=true, nullable=false, precision=19)
    private long idUserRole;
    @Column(name="id_user", nullable=false, precision=19)
    private long idUser;
    @Column(nullable=false, length=100)
    private String role;

    /** Default constructor. */
    public UserRole() {
        super();
    }

    /**
     * Access method for idUserRole.
     *
     * @return the current value of idUserRole
     */
    public long getIdUserRole() {
        return idUserRole;
    }

    /**
     * Setter method for idUserRole.
     *
     * @param aIdUserRole the new value for idUserRole
     */
    public void setIdUserRole(long aIdUserRole) {
        idUserRole = aIdUserRole;
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
     * Access method for role.
     *
     * @return the current value of role
     */
    public String getRole() {
        return role;
    }

    /**
     * Setter method for role.
     *
     * @param aRole the new value for role
     */
    public void setRole(String aRole) {
        role = aRole;
    }

    /**
     * Compares the key for this instance with another UserRole.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class UserRole and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof UserRole)) {
            return false;
        }
        UserRole that = (UserRole) other;
        if (this.getIdUserRole() != that.getIdUserRole()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another UserRole.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UserRole)) return false;
        return this.equalKeys(other) && ((UserRole)other).equalKeys(this);
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
        i = (int)(getIdUserRole() ^ (getIdUserRole()>>>32));
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
        StringBuffer sb = new StringBuffer("[UserRole |");
        sb.append(" idUserRole=").append(getIdUserRole());
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
        ret.put("idUserRole", Long.valueOf(getIdUserRole()));
        return ret;
    }

}
