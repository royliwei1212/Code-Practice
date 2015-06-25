package com.codeashobby.leetcode.jdk;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by hzhou on 2015/6/18.
 * Email: i@hzhou.me
 */
public class StringTest {

    private static final Logger log = Logger.getLogger(StringTest.class);

    @Test
    public void splitTest() {
        String[] result = ".453".split("\\.");
        int i = Integer.valueOf(result[0]);
    }
}
