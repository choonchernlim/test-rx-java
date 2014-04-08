package com.choonchernlim.testRxJava.example0;

import org.apache.log4j.Logger;

import java.util.Collection;

/**
 * Without using RxJava. A huge wait for the job to complete before the data is displayed.
 * `myService.getAllUsers(..)` becomes a blocking API.
 */
public class MyClient0 {

    private static final Logger LOGGER = Logger.getLogger(MyClient0.class);

    public static void main(String[] args) {
        LOGGER.info("Started.");

        final MyService0 myService = new MyService0();

        final Collection<String> users = myService.getAllUsers(1, 2, 3, 4, 5);

        for (String user : users) {
            LOGGER.info(Thread.currentThread() + "\tRESULT: " + user);
        }

        LOGGER.info("Done.");
    }


}
