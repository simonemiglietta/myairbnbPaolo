// Generated with g9.

package it.unisalento.myairbnb.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="feedback")
public class Feedback implements Serializable {

    /** Primary key. */
    protected static final String PK = "idfeedback";

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
    private int idfeedback;
    @Column(length=1000)
    private String text;
    @ManyToOne
    @JoinColumn(name="idapartment")
    private Apartment apartment;
    @ManyToOne
    @JoinColumn(name="idcar")
    private Car car;
    @ManyToOne
    @JoinColumn(name="idexperience")
    private Experience experience;

    /** Default constructor. */
    public Feedback() {
        super();
    }

    /**
     * Access method for idfeedback.
     *
     * @return the current value of idfeedback
     */
    public int getIdfeedback() {
        return idfeedback;
    }

    /**
     * Setter method for idfeedback.
     *
     * @param aIdfeedback the new value for idfeedback
     */
    public void setIdfeedback(int aIdfeedback) {
        idfeedback = aIdfeedback;
    }

    /**
     * Access method for text.
     *
     * @return the current value of text
     */
    public String getText() {
        return text;
    }

    /**
     * Setter method for text.
     *
     * @param aText the new value for text
     */
    public void setText(String aText) {
        text = aText;
    }

    /**
     * Access method for apartment.
     *
     * @return the current value of apartment
     */
    public Apartment getApartment() {
        return apartment;
    }

    /**
     * Setter method for apartment.
     *
     * @param aApartment the new value for apartment
     */
    public void setApartment(Apartment aApartment) {
        apartment = aApartment;
    }

    /**
     * Access method for car.
     *
     * @return the current value of car
     */
    public Car getCar() {
        return car;
    }

    /**
     * Setter method for car.
     *
     * @param aCar the new value for car
     */
    public void setCar(Car aCar) {
        car = aCar;
    }

    /**
     * Access method for experience.
     *
     * @return the current value of experience
     */
    public Experience getExperience() {
        return experience;
    }

    /**
     * Setter method for experience.
     *
     * @param aExperience the new value for experience
     */
    public void setExperience(Experience aExperience) {
        experience = aExperience;
    }

    /**
     * Compares the key for this instance with another Feedback.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Feedback and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Feedback)) {
            return false;
        }
        Feedback that = (Feedback) other;
        if (this.getIdfeedback() != that.getIdfeedback()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Feedback.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Feedback)) return false;
        return this.equalKeys(other) && ((Feedback)other).equalKeys(this);
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
        i = getIdfeedback();
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
        StringBuffer sb = new StringBuffer("[Feedback |");
        sb.append(" idfeedback=").append(getIdfeedback());
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
        ret.put("idfeedback", Integer.valueOf(getIdfeedback()));
        return ret;
    }

}
