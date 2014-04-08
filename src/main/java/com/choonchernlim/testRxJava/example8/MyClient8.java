package com.choonchernlim.testRxJava.example8;

import org.apache.log4j.Logger;
import rx.Observable;
import rx.Subscriber;

import java.util.Arrays;
import java.util.List;

/**
 * Asynchronous call. Control concurrent threads.
 */
public class MyClient8 {

    private static final Logger LOGGER = Logger.getLogger(MyClient8.class);

    public static void main(String[] args) {
        LOGGER.info("Started.");

        final MyService8 myService = new MyService8();

        final Observable<String> userList1 = myService.getAllUsers(1, 2, 3);
        final Observable<String> userList2 = myService.getAllUsers(4, 5);

        @SuppressWarnings("unchecked")
        final List<Observable<String>> users = Arrays.asList(userList1, userList2);

        Observable.merge(users, 1)
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
