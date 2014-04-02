package com.choonchernlim.testRxJava.example7;

import org.apache.log4j.Logger;
import rx.Observable;
import rx.Subscriber;

/**
 * Asynchronous call. Multi-thread processing.
 */
public class MyClient7 {

    private static Logger log = Logger.getLogger(MyClient7.class);

    public static void main(String[] args) {
        MyService7 myService = new MyService7();

        Observable<String> userList1 = myService.getAllUsers(1, 2, 3);
        Observable<String> userList2 = myService.getAllUsers(2, 3, 4);
        Observable<String> userList3 = myService.getAllUsers(3, 4, 5);

        Observable
                .merge(userList1, userList2, userList3)
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
