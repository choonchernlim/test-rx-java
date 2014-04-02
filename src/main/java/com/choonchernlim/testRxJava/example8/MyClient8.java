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

    private static Logger log = Logger.getLogger(MyClient8.class);

    public static void main(String[] args) {
        MyService8 myService = new MyService8();

        Observable<String> userList1 = myService.getAllUsers(1, 2, 3);
        Observable<String> userList2 = myService.getAllUsers(4, 5);

        @SuppressWarnings("unchecked")
        List<Observable<String>> users = Arrays.asList(userList1, userList2);

        Observable.merge(users, 1)
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
