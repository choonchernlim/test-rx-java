package com.choonchernlim.testRxJava.example2;

import org.apache.log4j.Logger;
import rx.Observable;
import rx.functions.Action1;

/**
 * Asynchronous call.
 */
public class MyClient2 {

    private static Logger log = Logger.getLogger(MyClient2.class);

    /*! No change from Example 1. */
    public static void main(String[] args) {
        MyService2 myService = new MyService2();

        Observable<String> users = myService.getAllUsers(1, 2, 3, 4, 5);

        users.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                log.info(Thread.currentThread() + "\tRESULT: " + s);
            }
        });

        log.info("Main: Done.");
    }


}
