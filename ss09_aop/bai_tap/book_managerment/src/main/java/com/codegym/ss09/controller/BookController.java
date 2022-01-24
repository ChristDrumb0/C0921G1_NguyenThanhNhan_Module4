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

    @GetMapping("/borrow/{idBook}")
    public ModelAndView borrowForm(@PathVariable Integer idBook) {
//        //tạo code random
//        Code codeObj = new Code();
//        //set code --> hiển thị mã cho client
//        codeObj.setCode((long) (Math.random() * (99999 - 10000) + 10000));
        Book bookObj = iBookService.findById(idBook);
//        //Set book cho table code
//        codeObj.setBook(bookObj);

        return new ModelAndView("borrow", "bookObj", bookObj);
    }

    @PostMapping("/borrow")
    public String borrow(@ModelAttribute Book bookObj,
                         RedirectAttributes redirectAttributes) throws BookQuantityZero {

        if (bookObj.getQuantity() == 0) {
            throw new BookQuantityZero();
        } else {
            //lưu code (tạo mới):
//            iCodeService.save(codeObj);
            //giam SL đi 1:
//            Book bookObj = codeObj.getBook();
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
        Book bookObj = new Book();
        return new ModelAndView("give_back", "bookObj", bookObj);
    }

}
