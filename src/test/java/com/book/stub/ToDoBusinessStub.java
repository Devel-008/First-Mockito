package com.book.stub;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ToDoBusinessStub {

    @Test
    public void test() {

        ToDoService doServiceStub = new ToDoServiceStub();

        ToDoBusiness business = new ToDoBusiness(doServiceStub);

        List<String> retrievedtodos = business.getTodosforSpring(" Dummy ");

        Assert.assertEquals(3, retrievedtodos.size());
        System.out.println(" Stub is working correctly...!!");
    }
}
