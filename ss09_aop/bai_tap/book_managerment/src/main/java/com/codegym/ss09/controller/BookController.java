package com.codegym.ss09.controller;

import com.codegym.ss09.entity.Book;
import com.codegym.ss09.exception.BookQuantityZero;
import com.codegym.ss09.service.IBookSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private IBookSer iBookService;

    //show List book
    @GetMapping("")
    public ModelAndView showList() {
        return new ModelAndView("index", "bookList", iBookService.findAll());
    }

    //borrow
    @GetMapping("/borrow/{idBook}")
    public ModelAndView borrowForm(@PathVariable Integer idBook) {
        Book bookObj = iBookService.findById(idBook);
        return new ModelAndView("borrow", "bookObj", bookObj);
    }

    @PostMapping("/borrow")
    public String borrow(@ModelAttribute Book bookObj,
                         RedirectAttributes redirectAttributes) throws BookQuantityZero {

        if (bookObj.getQuantity() == 0) {
            throw new BookQuantityZero();
        } else {
            //giam SL đi 1:
            bookObj.setQuantity(bookObj.getQuantity() - 1);
            //lưu book lại
            iBookService.save(bookObj);
            //response
            redirectAttributes.addFlashAttribute("message", "Bạn đã mượn sách: " + bookObj.getBookName());
            return "redirect:";
        }
    }
    //handle: TH SL = 0
    @ExceptionHandler(BookQuantityZero.class)
    public String handleBookQtyZero() {
        return "error_qty_zero";
    }

    //trả sách
    @GetMapping("/give_back/{idBook}")
    public ModelAndView giveBackForm(@PathVariable Integer idBook) {
        Book bookObj = iBookService.findById(idBook);
        return new ModelAndView("give_back", "bookObj", bookObj);
    }
    @PostMapping("/give_back")
    public String giveBack(@ModelAttribute Book bookObj,
                           RedirectAttributes redirectAttributes) {
            //tăng SL đi 1:
            bookObj.setQuantity(bookObj.getQuantity() + 1);
            //lưu sách lại
            iBookService.save(bookObj);

            //response
            redirectAttributes.addFlashAttribute("message", "Bạn đã trả sách: " + bookObj.getBookName());
            return "redirect:";
//        }
    }

}
