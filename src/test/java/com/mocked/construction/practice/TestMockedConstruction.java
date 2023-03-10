package com.mocked.construction.practice;

import com.mocked.construction.practice.GreetingsUtil;
import com.mocked.construction.practice.PolitePerson;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class TestMockedConstruction {
    @Test
    void shouldFinishConversation() {

        //given the object we want to test
        PolitePerson politePerson = new PolitePerson();

        // we use a try-with-resources block
        try (MockedStatic<GreetingsUtil> greetingsUtilMockedStatic = mockStatic(GreetingsUtil.class)) {

            //given part: pay attention that inside when we use a method reference
            greetingsUtilMockedStatic.when(GreetingsUtil::sayFormalGoodbye).thenReturn("Bye");

            //when part: we call the part of the real code which uses the static method
            final String goodbyeMessage = politePerson.finishConversation();

            //then part: we verify our mocked method is called and the class does its part (in this case, adding the "!")
            assertEquals("Bye!", goodbyeMessage);
        }
    }
    @Test
    void shouldStartConversation() {

        //given the object we want to test
        PolitePerson politePerson = new PolitePerson();

        // we use a try-with-resources block
        try (MockedStatic<GreetingsUtil> greetingsUtilMockedStatic = mockStatic(GreetingsUtil.class)) {

            //given part: pay attention that inside when we verify the given argument is equals to "John"
            greetingsUtilMockedStatic.when(() -> GreetingsUtil.getFormalHello(eq("John"))).thenReturn("Hello John");

            //when part: we call the part of the real code which uses the static method
            final String helloMessage = politePerson.startConversationWith("John");

            //then part: we verify our mocked method is called and the class does its part (in this case, adding the "!")
            assertEquals("Hello John!", helloMessage);
        }
    }
    @Test
    void shouldForceAnInformalPerson() {
        // we use a try-with-resources block
        try (MockedConstruction politePersonConstructionMocked = mockConstruction(PolitePerson.class)) {

            // given part: in our example, we create the new object, but this part could be inside a method call
            PolitePerson mockedPolitePerson = new PolitePerson();

            // given part: when the mock PolitePerson finish conversation is called, an informal goodbye is sent
            when(mockedPolitePerson.finishConversation()).thenReturn("Take it easy");

            // when part: call the method
            final String informalGoodbyeMessage = mockedPolitePerson.finishConversation();

            // then part: we verify our fake message is returned and we verify the mock is called only once
            assertEquals("Take it easy", informalGoodbyeMessage);
            verify(mockedPolitePerson, times(1)).finishConversation();
        }
    }



}
