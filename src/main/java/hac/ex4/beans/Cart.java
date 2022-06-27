package hac.ex4.beans;

import hac.ex4.repo.Book;
import hac.ex4.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Cart Component - Shopping list - Saves each customer's session
 */
@Component
public class Cart implements Serializable {
    private ArrayList<Book> cartBooks;

    @Autowired
    private BookService bookService;

    /**
     * Empty Contractor Cart
     */
    public Cart() {
        this.cartBooks = new ArrayList<>();
    }

    /**
     * get - nothing
     * @return Shopping list
     */
    public ArrayList<Book> getCart() {
        return cartBooks;
    }

    /**
     * set Shopping list
     * @param newCartList
     */
    public void setCart(ArrayList<Book> newCartList) {
        this.cartBooks = newCartList;
    }

    /**
     * get cart account
     * @return sum of all shopping cart
     */
    public double getAccount() {
        double s = 0;
        for (Book b : cartBooks)
            s += (b.getPrice() - b.getPrice() * b.getDiscount() / 100)*b.getQuantity();
        return s;
    }

    /**
     * get size of the cart
     * @return size
     */
    public int getSize() {
        int s = 0;
        for (Book b : cartBooks)
            s += b.getQuantity();
        return s;
    }

    /**
     * add new book to cart
     * @param b - to add to cart
     */
    public void add(Book b) {
        for (Book o : this.cartBooks) {
            if (o.getId() == b.getId()) {
                o.setQuantity(o.getQuantity() + 1);
                return;
            }
        }
        b.setQuantity(1);
        this.cartBooks.add(b);
    }

    /**
     * Checks which books are interfering with the purchase
     * @return names of all books that needs to be deleted
     */
    public ArrayList<String> getMissingBooks(){
        ArrayList<String> namesToDelete = new ArrayList<String>();
        for(Book b : cartBooks)
            if(bookService.getBook(b.getId()).get().getQuantity() - b.getQuantity() < 0)
                namesToDelete.add(b.getBookName());
        return namesToDelete;
    }

    /**
     * Delete all cart
     */
    public void deleteAll() {
        cartBooks.clear();
    }

    /**
     *  delete book by id
     * @param id of book
     */
    public void deleteById(long id) {
        this.cartBooks.removeIf(book -> book.getId() == id);
    }

    /* BEAN using ctor - session scope */

    /**
     * Session Scope
     * @return new Cart
     */
    @Bean
    @SessionScope
    public Cart sessionBeanCart() {
        return new Cart();
    }

}