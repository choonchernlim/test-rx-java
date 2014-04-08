package com.choonchernlim.testRxJava.example9;

import org.apache.log4j.Logger;
import rx.Observable;
import rx.Subscriber;

/**
 * Asynchronous call. What happen when error occurs?
 */
public class MyClient9 {

    private static final Logger LOGGER = Logger.getLogger(MyClient9.class);

    public static void main(String[] args) {
        LOGGER.info("Started.");

        final MyService9 myService = new MyService9();

        // Person ID 10 is invalid
        final Observable<String> userList1 = myService.getAllUsers(1, 10, 2);
        final Observable<String> userList2 = myService.getAllUsers(3, 4, 5);

        Observable.merge(userList1, userList2)
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
