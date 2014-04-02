package com.choonchernlim.testRxJava.main;

import static java.lang.Thread.sleep;

import java.util.HashMap;
import java.util.Map;

public class MyDAO {
    private static final int SLEEP_IN_SECOND = 2000;

    private static final Map<Integer, String> userMap = new HashMap<Integer, String>();
    private static final Map<Integer, Integer> pointMap = new HashMap<Integer, Integer>();

    static {
        userMap.put(1, "(1) Mike");
        userMap.put(2, "(2) Tom");
        userMap.put(3, "(3) Jane");
        userMap.put(4, "(4) Paula");
        userMap.put(5, "(5) George");

        pointMap.put(1, 100);
        pointMap.put(2, 200);
        pointMap.put(3, 300);
        pointMap.put(4, 400);
        pointMap.put(5, 500);
    }

    public String getUser(int personId) {
        try {
            sleep(SLEEP_IN_SECOND);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return userMap.get(personId);
    }

    public Integer getPoint(int pointId) {
        try {
            sleep(SLEEP_IN_SECOND);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return pointMap.get(pointId);
    }
}
