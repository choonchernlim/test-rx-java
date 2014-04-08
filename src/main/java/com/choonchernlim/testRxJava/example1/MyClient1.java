package com.choonchernlim.testRxJava.example1;

import org.apache.log4j.Logger;
import rx.Observable;
import rx.functions.Action1;

/**
 * Synchronous call.
 */
public class MyClient1 {

    private static final Logger LOGGER = Logger.getLogger(MyClient1.class);

    public static void main(String[] args) {
        LOGGER.info("Started.");

        final MyService1 myService = new MyService1();

        final Observable<String> users = myService.getAllUsers(1, 2, 3, 4, 5);

        users.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                LOGGER.info(Thread.currentThread() + "\tRESULT: " + s);
            }
        });

        LOGGER.info("Done.");
    }


}
