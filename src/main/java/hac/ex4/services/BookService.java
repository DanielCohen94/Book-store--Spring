package hac.ex4.services;

import hac.ex4.repo.Book;
import hac.ex4.repo.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Transactional
    public void addBooks(ArrayList<Book> books) {
        repository.saveAll(books);
    }

    /**
     * save Book
     * @param book - to save
     */
    public void saveBook(Book book) {
        book.setImage(book.getImage().trim());
        book.setBookName(book.getBookName().trim());
        repository.save(book);
    }

    /**
     * delete Book by id
     * @param id - of book to delete
     */
    public void deleteBook(long id) {
        repository.deleteById(id);
    }

    /**
     * delete Book by book
     * @param b - book to delete
     */
    public void deleteBook(Book b) {
        repository.delete(b);
    }

    /**
     * get Book by id
     * @param id of book
     * @return Optional<Book>
     */
    public Optional<Book> getBook(long id) {
        return repository.findById(id);
    }

    /**
     * get first 5 Sorted By Discount
      * @return books with the most discount
     */
    public List<Book> get5SortedByDiscount() {
        return repository.findFirst5ByOrderByDiscountDesc();
    }

    /**
     * get By Name Contains
     * @param bookName - to search
     * @return books that their name contains bookName
     */
    public List<Book> getByNameContains(String bookName) {
        return repository.findByBookNameContains(bookName);
    }

    /**
     * decrement Amount of booksToDec :
     * If during the process you encounter a problem,
     * undo the rest of the actions that happened until the error
     * @param booksToDec - ArrayList<Book> to decrement from db
     */
    @Transactional
    public void decAmount(ArrayList<Book> booksToDec) {
        for(Book b:booksToDec){
            Book bookOrj = repository.findBookById(b.getId());
            int i = bookOrj.getQuantity() - b.getQuantity();
            bookOrj.setQuantity(i);
            this.saveBook(bookOrj);
        }
    }

    /**
     * get all Books
     * @return List<Book> all
     */
    public List<Book> getBooks() {
        return repository.findAll();
    }
}
