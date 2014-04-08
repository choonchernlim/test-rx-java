package com.choonchernlim.testRxJava.example3;

import com.choonchernlim.testRxJava.main.MyDAO;
import com.choonchernlim.testRxJava.main.PersonNotFoundException;
import org.apache.commons.lang3.StringUtils;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyService3 {
    private final MyDAO myDao = new MyDAO();

    // Same as Example 2
    public Observable<String> getAllUsers(final int... personIds) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                final ExecutorService executorService = Executors.newFixedThreadPool(5);

                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        query(subscriber, personIds);
                    }
                });

                executorService.shutdown();
            }
        });
    }

    private void query(Subscriber<? super String> subscriber, int[] personIds) {

        for (Integer personId : personIds) {
            final String name = myDao.getUser(personId);

            // perform a rudimentary check to ensure name exists, otherwise throw an error
            if (!StringUtils.isBlank(name)) {
                subscriber.onNext(name);
            }
            else {
                subscriber.onError(new PersonNotFoundException(personId));
            }
        }

        subscriber.onCompleted();
    }
}
