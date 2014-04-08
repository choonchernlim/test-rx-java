package com.choonchernlim.testRxJava.main;

import com.google.common.collect.ImmutableMap;
import static java.lang.Thread.sleep;

import java.util.Map;


public class MyDAO {
    private static final Map<Integer, String> USER_MAP = ImmutableMap.of(1, "(1) Mike",
                                                                         2, "(2) Tom",
                                                                         3, "(3) Jane",
                                                                         4, "(4) Paula",
                                                                         5, "(5) George");

    private static final Map<Integer, Integer> POINT_MAP = ImmutableMap.of(1, 100,
                                                                           2, 200,
                                                                           3, 300,
                                                                           4, 400,
                                                                           5, 500);

    public String getUser(int personId) {
        pause();
        return USER_MAP.get(personId);
    }

    public Integer getPoint(int pointId) {
        pause();
        return POINT_MAP.get(pointId);
    }

    /**
     * Simulating procedure call against DB, web services, etc.
     */
    private void pause() {
        try {
            sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
