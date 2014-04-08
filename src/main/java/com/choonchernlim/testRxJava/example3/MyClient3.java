package com.choonchernlim.testRxJava.example3;

import org.apache.log4j.Logger;
import rx.Observable;
import rx.functions.Action1;

/**
 * Asynchronous call. Basic error handling.
 */
public class MyClient3 {

    private static final Logger LOGGER = Logger.getLogger(MyClient3.class);

    public static void main(String[] args) {
        LOGGER.info("Started.");

        final MyService3 myService = new MyService3();

        // Person ID 10 is invalid
        final Observable<String> users = myService.getAllUsers(1, 2, 3, 10, 5);

        users.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                LOGGER.info(Thread.currentThread() + "\tRESULT: " + s);
            }
        });

        LOGGER.info("Done.");
    }


}
