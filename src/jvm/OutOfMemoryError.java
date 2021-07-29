package jvm;

/* Raj Kumar Boddupally created on 7/29/2021 inside the package - jvm */

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryError {


    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();

        int index = 1;
        while (true) {
            byte[] byteArr = new byte[1024 * 1024];
            list.add(byteArr);
            Runtime runtime = Runtime.getRuntime();
            System.out.println("index-" + index++ + " Free memory-" + runtime.freeMemory());
        }
    }
}

