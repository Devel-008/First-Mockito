package com.book.fake;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;


public class FakeTest {
    @Test
    public void testFake(){
        SoftAssert softAssert = new SoftAssert();
        BookRepository bookRepository = new FakeBookRepository();
        BookService bookService = new BookService(bookRepository);
        bookService.addBook(new Book("1234","ABC",250, LocalDate.now()));
        bookService.addBook(new Book("5678","XYZ",300, LocalDate.now()));
        //System.out.println(bookService.findNumberOfBooks());
        softAssert.assertEquals(bookService.findNumberOfBooks(),33);
        softAssert.assertAll();
        //Assert.assertEquals(2,3);

    }
}
