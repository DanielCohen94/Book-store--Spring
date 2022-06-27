package hac.ex4.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/* default scope of this Bean is "singleton" */
public interface BookRepository extends JpaRepository<Book, Long> {
    /**
     * find By BookName Contains
     * @param bookName - String bookName
     * @return books that Contains bookName
     */
    List<Book> findByBookNameContains(String bookName);

    /**
     * find First 5 By Order By Discount Desc
     * @return 5 books With the biggest discount
     */
    List<Book> findFirst5ByOrderByDiscountDesc();

    /**
     * find Book By Id
     * @param id - long
     * @return book with the same id
     */
    Book findBookById(long id);
}
