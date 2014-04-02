package com.choonchernlim.testRxJava.example5;

import org.apache.log4j.Logger;
import rx.Observable;
import rx.Subscriber;

/**
 * Asynchronous call. Ability for subscriber to unsubscribe at anytime.
 */
public class MyClient5 {

    private static Logger log = Logger.getLogger(MyClient5.class);

    public static void main(String[] args) {
        MyService5 myService = new MyService5();

        Observable<String> users = myService.getAllUsers(1, 2, 3, 4, 5);

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

                // ## NEW ##
                if ("(2) Tom".equals(s)) {
                    unsubscribe();
                }
            }
        });

        log.info("Main: Done.");
    }


}
