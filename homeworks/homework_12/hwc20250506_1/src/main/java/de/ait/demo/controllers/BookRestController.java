package de.ait.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookRestController {

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBook(){
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Harry Potter und der Stein der Weisen", "Joanne K. Rowling.", 1997 ));
                bookList.add(new Book("Harry Potter und die Kammer des Schreckens", "Joanne K. Rowling.", 1998 ));
                bookList.add(new Book("Harry Potter und der Gefangene von Askaban", "Joanne K. Rowling.", 1999 ));

                return bookList;
    }
}
