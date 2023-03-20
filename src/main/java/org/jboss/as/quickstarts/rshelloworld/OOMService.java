
package org.jboss.as.quickstarts.rshelloworld;

import java.util.LinkedList;
import java.util.List;

public class OOMService {

    String generateOOM(int loop) {
        generate(loop);
        return "Started";
    }

    void generate(final int loop) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                List<byte[]> list = new LinkedList();
                int index = 1;

                while (index < loop) {
                    byte[] b = new byte[10 * 1024 * 1024]; // 10MB byte object
                    list.add(b);
                    Runtime rt = Runtime.getRuntime();
                    System.out.printf("[%3s] Available heap memory: %s%n", index++, rt.freeMemory());
                }
            }
        });
        t.start();

    }

}
