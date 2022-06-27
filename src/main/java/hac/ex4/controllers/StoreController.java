package hac.ex4.controllers;
import hac.ex4.beans.Cart;
import hac.ex4.repo.Book;
import hac.ex4.repo.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import hac.ex4.services.BookService;
import hac.ex4.services.PaymentService;
import org.unbescape.html.HtmlEscape;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class StoreController {

    @Autowired
    private BookService bookService;
    @Autowired
    private PaymentService paymentServiceService;

    @Resource(name = "sessionBeanCart")
    private Cart sessionCart;

    /**
     * get /
     * @param model - to add data to response
     * @return view store
     */
    @GetMapping("/")
    public String main(Model model) {
        List<Book> b = bookService.get5SortedByDiscount();
        model.addAttribute("total", sessionCart.getSize());
        model.addAttribute("cart", sessionCart.getCart());
        model.addAttribute("books", b);
        return "store/store";
    }

    /**
     * get search
     * @param model - to add data to response
     * @return view store
     */
    @GetMapping("/search")
    public String sec(Model model) {
        List<Book> c = bookService.get5SortedByDiscount();
        model.addAttribute("cart", sessionCart.getCart());
        model.addAttribute("books", c);
        return "store/store";
    }

    /**
     * post search
     * @param bookName - name of books to search
     * @param model - to add data to response
     * @return view store
     */
    @PostMapping("/search")
    public String FindByNameOrPartName(@RequestParam(name = "bookName", required = false, defaultValue = "<missing name>") String bookName, Model model) {
        List<Book> c = bookService.get5SortedByDiscount();
        List<Book> b = bookService.getByNameContains(bookName);
        model.addAttribute("books", c);
        model.addAttribute("booksSearch", b);
        model.addAttribute("cart", sessionCart.getCart());

        return "store/store";
    }

    /**
     * get buy - protect pages
     * @param model - to add data to response
     * @return view cart
     */
    @GetMapping("/buy")
    public String getCartAgain(Model model) {
        return "redirect:cart";
    }

    /**
     * post buy - make buy
     * @param model - to add data to response
     * @param principal - connected user
     * @return view cart or endBuy
     */
    @PostMapping("/buy")
    public String makeBuy(Model model, Principal principal) {
        try {
            bookService.decAmount(sessionCart.getCart());
            Payment p = new Payment(sessionCart.getAccount(),principal.getName());
            paymentServiceService.savePayment(p);
        } catch (Exception e) {
            return "redirect:/cart";
        }
        model.addAttribute("sum", sessionCart.getAccount());
        model.addAttribute("books", sessionCart.getCart());
        model.addAttribute("total", 0);
        sessionCart.deleteAll();
        return "store/endBuy";
    }

    /**
     * Error page.
     */
    @RequestMapping("/error.html")
    public String error(HttpServletRequest request, Model model) {
        model.addAttribute("errorCode", "Error " + request.getAttribute("javax.servlet.error.status_code"));
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("<ul>");
        while (throwable != null) {
            errorMessage.append("<li>").append(HtmlEscape.escapeHtml5(throwable.getMessage())).append("</li>");
            throwable = throwable.getCause();
        }
        errorMessage.append("</ul>");
        model.addAttribute("errorMessage", errorMessage.toString());
        return "error";
    }

    /**
     * Error page.
     */
    @RequestMapping("/403")
    public String forbidden() {
        return "403";
    }
}