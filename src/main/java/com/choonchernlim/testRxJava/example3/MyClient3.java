package com.choonchernlim.testRxJava.example3;

import org.apache.log4j.Logger;
import rx.Observable;
import rx.functions.Action1;

/**
 * Asynchronous call. Basic error handling.
 */
public class MyClient3 {

    private static Logger log = Logger.getLogger(MyClient3.class);

    public static void main(String[] args) {
        MyService3 myService = new MyService3();

        // ## NEW ##
        /*! Person ID 10 is invalid. */
        Observable<String> users = myService.getAllUsers(1, 2, 3, 10, 5);

        users.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                log.info(Thread.currentThread() + "\tRESULT: " + s);
            }
        });

        log.info("Main: Done.");
    }


}
