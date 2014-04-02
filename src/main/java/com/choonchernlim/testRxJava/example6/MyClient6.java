package com.choonchernlim.testRxJava.example6;

import org.apache.log4j.Logger;
import rx.Observable;
import rx.Subscriber;

/**
 * Asynchronous call. Leveraging iterator.
 */
public class MyClient6 {

    private static Logger log = Logger.getLogger(MyClient6.class);

    public static void main(String[] args) {
        MyService6 myService = new MyService6();

        Observable<String> users = myService.getAllUsers(1, 2, 3, 4, 5);

        // ## NEW ##
        users
                .skip(2)
                .take(2)
                .subscribe(new Subscriber<String>() {
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
