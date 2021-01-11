package com.zj;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;


/**
 * Hello world!
 */
public class App {


    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        App app = null;
        System.out.println(app.add(10, 20));

        Log log = LogFactory.getLog("jcl");
        log.info("hello");
    }
}
