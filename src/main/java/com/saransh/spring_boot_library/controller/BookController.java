package com.saransh.spring_boot_library.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.saransh.spring_boot_library.entity.Book;
import com.saransh.spring_boot_library.service.BookService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;



@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {
    
    private BookService bookService;
    // @Autowired
    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @PutMapping("/secure/checkout")
    public Book checkoutBook(@RequestParam Long bookId) throws Exception{
        String userEmail="test@gmail.com";
        return bookService.checkoutBook(userEmail,bookId);

    }
    @GetMapping("/secure/ischeckedoutbyuser")
    public Boolean checkedOutBookByUser(@RequestParam Long bookId) {
        String userEmail="test@gmail.com";
        return bookService.checkoutBookByUser(userEmail, bookId);
    }
    @GetMapping("/secure/currentloans/count")
    public int currentLoansCount() {
        String userEmail="test@gmail.com";
        return bookService.currentLoansCount(userEmail);
    }
    
    
}

