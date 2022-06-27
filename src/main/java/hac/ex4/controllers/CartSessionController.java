package hac.ex4.controllers;

import hac.ex4.beans.Cart;
import hac.ex4.repo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/cart")
public class CartSessionController {

    @Resource(name = "sessionBeanCart")
    private Cart sessionCart;

    /**
     * get /cart
     * @param model - to add data to response
     * @return view cart
     */
    @GetMapping("")
    public String process(Model model) {
        model.addAttribute("booksToRm", sessionCart.getMissingBooks());
        model.addAttribute("books", sessionCart.getCart());
        model.addAttribute("total", sessionCart.getAccount());
        model.addAttribute("totalSize", sessionCart.getSize());

        return "cart/cart";
    }

    /**
     * get cart/addToCart
     * @param book - to add to cart
     * @return view /
     */
    @PostMapping("/addToCart")
    public String persistMessage(@RequestParam("book")Book book) {
        sessionCart.add(book);
        return "redirect:/";
    }

    /**
     * post /delete/{id}
     * @param id - identify
     * @param model - to add data to response
     * @return view cart
     */
    @PostMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable("id") long id, Model model) {
        sessionCart.deleteById(id);
        return "redirect:/cart";
    }

    /**
     * /deleteAll
     * @param model - to add data to response
     * @return view cart
     */
    @PostMapping("/deleteAll")
    public String deleteCart(Model model) {
        sessionCart.deleteAll();
        return "redirect:/cart";
    }
}