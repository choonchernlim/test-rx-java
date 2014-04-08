package com.choonchernlim.testRxJava.example6;

import org.apache.log4j.Logger;
import rx.Observable;
import rx.Subscriber;

/**
 * Asynchronous call. Leveraging iterator.
 */
public class MyClient6 {

    private static final Logger LOGGER = Logger.getLogger(MyClient6.class);

    public static void main(String[] args) {
        LOGGER.info("Started.");

        final MyService6 myService = new MyService6();

        final Observable<String> users = myService.getAllUsers(1, 2, 3, 4, 5);

        // A clean "pagination-like" way to traverse `Observable`
        users
                .skip(2)
                .take(2)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        LOGGER.info(Thread.currentThread() + "\tDone.");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        LOGGER.error(Thread.currentThread() + "\tERROR: " + throwable);
                    }

                    @Override
                    public void onNext(String s) {
                        LOGGER.info(Thread.currentThread() + "\tRESULT: " + s);
                    }
                });

        LOGGER.info("Done.");
    }


}
