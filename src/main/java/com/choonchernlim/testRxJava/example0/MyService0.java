package com.choonchernlim.testRxJava.example0;

import com.choonchernlim.testRxJava.main.MyDAO;
import com.google.common.collect.ImmutableList;

import java.util.Collection;

public class MyService0 {
    private final MyDAO myDao = new MyDAO();

    public Collection<String> getAllUsers(final int... personIds) {
        final ImmutableList.Builder<String> builder = ImmutableList.builder();

        for (Integer personId : personIds) {
            final String name = myDao.getUser(personId);
            builder.add(name);
        }

        return builder.build();
    }
}
