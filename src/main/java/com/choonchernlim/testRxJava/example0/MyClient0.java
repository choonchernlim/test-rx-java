package com.choonchernlim.testRxJava.example0;

import org.apache.log4j.Logger;

import java.util.Collection;

/**
 * Without using RxJava. A huge wait for the job to complete before the data is displayed.
 */
public class MyClient0 {

    private static Logger log = Logger.getLogger(MyClient0.class);

    public static void main(String[] args) {
        final MyService0 myService = new MyService0();

        final Collection<String> users = myService.getAllUsers(1, 2, 3, 4, 5);

        for (String user : users) {
            log.info(Thread.currentThread() + "\tRESULT: " + user);
        }

        log.info("Done.");
    }


}
