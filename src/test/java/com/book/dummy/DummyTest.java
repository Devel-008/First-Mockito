package com.book.dummy;


import org.mockito.Spy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;

public class DummyTest{
    SoftAssert softAssert = new SoftAssert();
    EmailService emailService = new DummyEmailService();
   BookRepository bookRepository = new DummyBookRepository();
    BookService bookService = new BookService(bookRepository, emailService);
    @Test
    public void testDummy(){
        bookService.addBook(new Book("1234","ABC",250, LocalDate.now()));
        bookService.addBook(new Book("5678","XYZ",300, LocalDate.now()));
        //System.out.println(bookService.findNumberOfBooks());
        softAssert.assertEquals(bookService.findNumberOfBooks(),33);
        softAssert.assertAll();
        //Assert.assertEquals(2,3);

    }
}
