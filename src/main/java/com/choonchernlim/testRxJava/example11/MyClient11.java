package com.choonchernlim.testRxJava.example11;

import org.apache.log4j.Logger;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/**
 * Asynchronous call. Pairing items.
 */
public class MyClient11 {

    private static final Logger LOGGER = Logger.getLogger(MyClient11.class);

    public static void main(String[] args) {
        LOGGER.info("Started.");

        final MyService11 myService = new MyService11();

        final Observable<String> users = myService.getAllUsers(1, 2, 3, 4, 5);
        final Observable<Integer> points = myService.getAllPoints(1, 2, 3, 4, 5);

        // Pairing items with `zip(..)`
        Observable
                .zip(users, points, new Func2<String, Integer, String>() {
                    @Override
                    public String call(String user, Integer point) {
                        return String.format("User %s has %d points.", user, point);
                    }
                })
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
