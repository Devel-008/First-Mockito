package com;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestList {

    @Test
    public void testList_ReturnsSingle_value() {

        List mocklist = mock(List.class);
        when(mocklist.size()).thenReturn(2);

        Assert.assertEquals(2, mocklist.size());
        Assert.assertEquals(2, mocklist.size());

        System.out.println( mocklist.size());
        System.out.println(mocklist);
    }
}