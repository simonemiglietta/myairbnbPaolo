// Generated with g9.

package it.unisalento.myairbnb.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="experience")
public class Experience implements Serializable {

    /** Primary key. */
    protected static final String PK = "idexperience";

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
    @Column(unique=true, nullable=false, precision=10)
    private int idexperience;
    @Column(nullable=false, length=100)
    private String title;
    @Column(length=250)
    private String description;
    private byte[] picture;
    @Column(nullable=false, length=12)
    private float price;
    @Column(length=12)
    private float lat;
    @Column(length=12)
    private float lon;
    @Column(nullable=false, precision=3)
    private short state;
    @OneToMany(mappedBy="experience")
    private Set<Booking> booking;
    @ManyToOne(optional=false)
    @JoinColumn(name="idadmin", nullable=false)
    private Admin admin;
    @OneToMany(mappedBy="experience")
    private Set<Feedback> feedback;
    @ManyToOne(optional=false)
    @JoinColumn(name="idseller", nullable=false)
    private Seller seller;

    /** Default constructor. */
    public Experience() {
        super();
    }

    /**
     * Access method for idexperience.
     *
     * @return the current value of idexperience
     */
    public int getIdexperience() {
        return idexperience;
    }

    /**
     * Setter method for idexperience.
     *
     * @param aIdexperience the new value for idexperience
     */
    public void setIdexperience(int aIdexperience) {
        idexperience = aIdexperience;
    }

    /**
     * Access method for title.
     *
     * @return the current value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for title.
     *
     * @param aTitle the new value for title
     */
    public void setTitle(String aTitle) {
        title = aTitle;
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
     * Access method for picture.
     *
     * @return the current value of picture
     */
    public byte[] getPicture() {
        return picture;
    }

    /**
     * Setter method for picture.
     *
     * @param aPicture the new value for picture
     */
    public void setPicture(byte[] aPicture) {
        picture = aPicture;
    }

    /**
     * Access method for price.
     *
     * @return the current value of price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Setter method for price.
     *
     * @param aPrice the new value for price
     */
    public void setPrice(float aPrice) {
        price = aPrice;
    }

    /**
     * Access method for lat.
     *
     * @return the current value of lat
     */
    public float getLat() {
        return lat;
    }

    /**
     * Setter method for lat.
     *
     * @param aLat the new value for lat
     */
    public void setLat(float aLat) {
        lat = aLat;
    }

    /**
     * Access method for lon.
     *
     * @return the current value of lon
     */
    public float getLon() {
        return lon;
    }

    /**
     * Setter method for lon.
     *
     * @param aLon the new value for lon
     */
    public void setLon(float aLon) {
        lon = aLon;
    }

    /**
     * Access method for state.
     *
     * @return the current value of state
     */
    public short getState() {
        return state;
    }

    /**
     * Setter method for state.
     *
     * @param aState the new value for state
     */
    public void setState(short aState) {
        state = aState;
    }

    /**
     * Access method for booking.
     *
     * @return the current value of booking
     */
    public Set<Booking> getBooking() {
        return booking;
    }

    /**
     * Setter method for booking.
     *
     * @param aBooking the new value for booking
     */
    public void setBooking(Set<Booking> aBooking) {
        booking = aBooking;
    }

    /**
     * Access method for admin.
     *
     * @return the current value of admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * Setter method for admin.
     *
     * @param aAdmin the new value for admin
     */
    public void setAdmin(Admin aAdmin) {
        admin = aAdmin;
    }

    /**
     * Access method for feedback.
     *
     * @return the current value of feedback
     */
    public Set<Feedback> getFeedback() {
        return feedback;
    }

    /**
     * Setter method for feedback.
     *
     * @param aFeedback the new value for feedback
     */
    public void setFeedback(Set<Feedback> aFeedback) {
        feedback = aFeedback;
    }

    /**
     * Access method for seller.
     *
     * @return the current value of seller
     */
    public Seller getSeller() {
        return seller;
    }

    /**
     * Setter method for seller.
     *
     * @param aSeller the new value for seller
     */
    public void setSeller(Seller aSeller) {
        seller = aSeller;
    }

    /**
     * Compares the key for this instance with another Experience.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Experience and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Experience)) {
            return false;
        }
        Experience that = (Experience) other;
        if (this.getIdexperience() != that.getIdexperience()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Experience.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Experience)) return false;
        return this.equalKeys(other) && ((Experience)other).equalKeys(this);
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
        i = getIdexperience();
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
        StringBuffer sb = new StringBuffer("[Experience |");
        sb.append(" idexperience=").append(getIdexperience());
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
        ret.put("idexperience", Integer.valueOf(getIdexperience()));
        return ret;
    }

}
