package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class SLF4JExample {
    public static void main(String[] args) {
        //Creating the Logger object
        Logger logger = LoggerFactory.getLogger("SampleLogger");

        //Logging the information
        logger.info("Hi This is my first SLF4J program");
    }
}