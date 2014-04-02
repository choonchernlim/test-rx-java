package com.choonchernlim.testRxJava.example10;

import org.apache.log4j.Logger;
import rx.Observable;
import rx.Subscriber;

/**
 * Asynchronous call. Pushing error to the end.
 */
public class MyClient10 {

    private static Logger log = Logger.getLogger(MyClient10.class);

    public static void main(String[] args) {
        MyService10 myService = new MyService10();

        /*! Person ID 10 is invalid. */
        Observable<String> userList1 = myService.getAllUsers(1, 10, 2);
        Observable<String> userList2 = myService.getAllUsers(3, 4, 5);

        Observable.mergeDelayError(userList1, userList2)
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
