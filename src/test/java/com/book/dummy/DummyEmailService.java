package com.book.dummy;

import com.book.dummy.EmailService;

public class DummyEmailService implements EmailService {
    @Override
    public void sendEmails(String message) {
        throw new AssertionError("Method not implemented");
    }
}
