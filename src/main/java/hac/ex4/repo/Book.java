package hac.ex4.repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.io.Serial;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Name is mandatory")
    private String bookName;

    private String image;

    @Min(value = 0 , message = "Quantity should be greater than zero")
    private int quantity;

    @Positive(message = "Price should be greater than zero")
    private double price;

    @Min(value = 0 , message = "Discount should be greater than zero")
    @Max(value = 100 , message = "Discount should be lower than 100")
    private double discount;

    /**
     * Book Empty Constructor
     */
    public Book() {}

    /**
     * Constructor Book
     * @param bookName - String
     * @param image - String
     * @param quantity - int
     * @param price - double
     * @param discount - double
     */
    public Book(String bookName, String image, int quantity, double price, double discount) {
        this.bookName = bookName;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    /**
     * set Id
     * @param id - long
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * set Book Name
     * @param bookName - String
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * set Image
     * @param image - String
     */
    public void setImage(String image ) { this.image = image; }

    /**
     * set Quantity
     * @param quantity - int
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * set Price
     * @param price - double
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * set Discount
     * @param discount - double
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * get Id
     * @return long id
     */
    public long getId() {
        return id;
    }

    /**
     * get Book Name
     * @return String bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * get Image
     * @return String image
     */
    public String getImage() {
        return image;
    }

    /**
     * get Quantity
     * @return int quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * get Price
     * @return double price
     */
    public double getPrice() {
        return price;
    }

    /**
     * get Discount
     * @return double discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * book to String
     * @return String Book
     */
    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", bookName=" + bookName +
                ", image=" + image +
                ", quantity=" + quantity +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}

