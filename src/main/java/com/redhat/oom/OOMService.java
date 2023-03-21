
package com.redhat.oom;

import java.util.LinkedList;
import java.util.List;

public class OOMService {

    String generateOOM(int loop, int objectSize) {
        generate(loop, objectSize);
        return "Started";
    }

    void generate(final int loop, final int objectSize) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                List<byte[]> list = new LinkedList();
                int index = 1;

                while (index < loop) {
                    byte[] b = new byte[objectSize * 1024 * 1024]; // 100MB byte object
                    list.add(b);

                    Runtime rt = Runtime.getRuntime();
                    System.out.printf("[%3s] Available heap memory: %s%n", index++, rt.freeMemory());
                }
            }
        });
        t.start();

    }

}
