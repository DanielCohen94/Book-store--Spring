package hac.ex4.controllers;

import hac.ex4.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import hac.ex4.repo.Book;
import hac.ex4.services.BookService;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BookService bookService;
    @Autowired
    private PaymentService paymentService;

    /**
     * get /admin
     * @param model - to add data to response
     * @return view
     */
    @GetMapping("")
    public String main(Model model) {
        model.addAttribute("books", bookService.getBooks());
        model.addAttribute("payments", paymentService.getPayments());
        try {
            model.addAttribute("sumPayments", paymentService.sumAllPayments());
        } catch (Exception ignored) {
        }
        return "admin/index";
    }

    /**
     * get /admin/newBook
     * @param book - to add
     * @param model - to add data to response
     * @return view add-book
     */
    @GetMapping("/newBook")
    public String showSignUpForm(Book book, Model model) {
        return "admin/add-book";
    }

    /**
     * get /admin/addbook
     * @param iName - If empty Enter a default value
     * @param book -to add
     * @param result - BindingResult
     * @param model - to add data to response
     * @return view add-book or /
     */
    @PostMapping("/addbook")
    public String addUser(@RequestParam(name = "image", required = false, defaultValue = "${demo.defaultImage}")
                                  String iName, @Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/add-book";
        }

        book.setImage(iName);
        try {
            bookService.saveBook(book);
        }catch(Exception e){
            return "admin/add-book";
        }
        model.addAttribute("books", bookService.getBooks());
        model.addAttribute("payments", paymentService.getPayments());
        return "redirect:/admin";
    }

    /**
     * get /admin/edit
     * @param id - identify
     * @param model - to add data to response
     * @return view update-book
     */
    @PostMapping("/edit")
    public String editBook(@RequestParam("id") long id, Model model) {
        Book book = bookService.getBook(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("book", book);
        return "admin/update-book";
    }

    /**
     * post /admin/update/{id}
     * @param id - identify
     * @param book - to update
     * @param result - BindingResult
     * @param model - to add data to response
     * @return view update-book or admin
     */
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/update-book";
        }
        book.setId(id);
        try {
            bookService.saveBook(book);
        }catch(Exception e){
            return "admin/update-book";
        }
        return "redirect:/admin";
    }

    /**
     * post /admin/delete/{id}
     * @param id - identify
     * @param model - to add data to response
     * @return view admin
     */
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {

        Book book = bookService
                .getBook(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Invalid book Id:" + id)
                );
        bookService.deleteBook(book);
        return "redirect:/admin";
    }
}

