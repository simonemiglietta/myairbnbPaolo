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

@Entity(name="car")
public class Car implements Serializable {

    /** Primary key. */
    protected static final String PK = "idcar";

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
    private int idcar;
    @Column(nullable=false, length=45)
    private String plate;
    @Column(length=200)
    private String description;
    @Column(nullable=false, length=12)
    private float price;
    private byte[] picture;
    @Column(nullable=false, precision=10)
    private int seats;
    @Column(nullable=false, precision=3)
    private short state;
    @OneToMany(mappedBy="car")
    private Set<Booking> booking;
    @ManyToOne(optional=false)
    @JoinColumn(name="idadmin", nullable=false)
    private Admin admin;
    @OneToMany(mappedBy="car")
    private Set<Feedback> feedback;
    @ManyToOne(optional=false)
    @JoinColumn(name="idseller", nullable=false)
    private Seller seller;

    /** Default constructor. */
    public Car() {
        super();
    }

    /**
     * Access method for idcar.
     *
     * @return the current value of idcar
     */
    public int getIdcar() {
        return idcar;
    }

    /**
     * Setter method for idcar.
     *
     * @param aIdcar the new value for idcar
     */
    public void setIdcar(int aIdcar) {
        idcar = aIdcar;
    }

    /**
     * Access method for plate.
     *
     * @return the current value of plate
     */
    public String getPlate() {
        return plate;
    }

    /**
     * Setter method for plate.
     *
     * @param aPlate the new value for plate
     */
    public void setPlate(String aPlate) {
        plate = aPlate;
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
     * Access method for seats.
     *
     * @return the current value of seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Setter method for seats.
     *
     * @param aSeats the new value for seats
     */
    public void setSeats(int aSeats) {
        seats = aSeats;
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
     * Compares the key for this instance with another Car.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Car and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Car)) {
            return false;
        }
        Car that = (Car) other;
        if (this.getIdcar() != that.getIdcar()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Car.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Car)) return false;
        return this.equalKeys(other) && ((Car)other).equalKeys(this);
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
        i = getIdcar();
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
        StringBuffer sb = new StringBuffer("[Car |");
        sb.append(" idcar=").append(getIdcar());
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
        ret.put("idcar", Integer.valueOf(getIdcar()));
        return ret;
    }

}
