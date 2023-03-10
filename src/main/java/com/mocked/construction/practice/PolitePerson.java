package com.mocked.construction.practice;

import com.mocked.construction.practice.GreetingsUtil;

public class PolitePerson {

    public String startConversationWith(final String name) {
        return GreetingsUtil.getFormalHello(name) + "!";
    }

    public String finishConversation() {
        return GreetingsUtil.sayFormalGoodbye() + "!";
    }
}
