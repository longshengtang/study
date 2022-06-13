package p;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

// -XX:+UseSerialGC -XX:-UseCompressedOops -Xms10m -Xmx10m
class Father {

}

class Son extends Father {
    private static final String COUNTRY = "China";
}

public class Main {
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println("Hello CLHSDB!!!");
        System.out.println(getProcessID());
        while (true) ;
    }


    public static final int getProcessID() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
        return Integer.valueOf(runtimeMXBean.getName().split("@")[0])
                .intValue();
    }
}


