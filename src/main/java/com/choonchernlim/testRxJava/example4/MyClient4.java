package com.choonchernlim.testRxJava.example4;

import org.apache.log4j.Logger;
import rx.Observable;
import rx.Subscriber;

/**
 * Asynchronous call. Better error handling.
 */
public class MyClient4 {

    private static Logger log = Logger.getLogger(MyClient4.class);

    public static void main(String[] args) {
        MyService4 myService = new MyService4();

        /*! Person ID 10 is invalid. */
        Observable<String> users = myService.getAllUsers(1, 2, 3, 10, 5);

        // ## NEW ##
        users.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                log.info(Thread.currentThread() + "\tDone.");
            }

            @Override
            public void onError(Throwable throwable) {
                log.error(Thread.currentThread() + "\tERROR: " + throwable);
            }

            @Override
            public void onNext(String s) {
                log.info(Thread.currentThread() + "\tRESULT: " + s);
            }
        });

        log.info("Main: Done.");
    }


}
