package com;


import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonTest{

    @Test
    public void playTest() {
        Person person = new Person("name", 15);
        Person person1 = Mockito.spy(person);

        Mockito.doReturn(true).when(person1).runInGround("ground");

        Assert.assertTrue(person1.isPlay());
    }
}
