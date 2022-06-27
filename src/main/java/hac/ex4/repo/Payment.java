package hac.ex4.repo;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Positive
    private double amount;

    @NotNull
    @NotEmpty
    private String user;

    @CreationTimestamp
    private Date date;

    /**
     * Payment Empty Constructor
     */
    public Payment() {}

    /**
     * Payment Constructor
     * @param amount - double
     * @param user - String
     */
    public Payment(double amount, String user) {
        this.amount = amount;
        this.user = user;
    }

    /**
     * set Id
     * @param id - long
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * set Amount
     * @param amount - double
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * set Date
     * @param date - Date java object
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * set User
     * @param user - String
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * get User
     * @return String user
     */
    public String getUser() {
        return user;
    }

    /**
     * get Id
     * @return - long
     */
    public long getId() {
        return id;
    }

    /**
     * get Date
     * @return Date java object
     */
    public Date getDate() {
        return date;
    }

    /**
     * get Amount
     * @return double
     */
    public double getAmount() {
        return amount;
    }

    /**
     * payment to String
     * @return Payment Book
     */
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}

