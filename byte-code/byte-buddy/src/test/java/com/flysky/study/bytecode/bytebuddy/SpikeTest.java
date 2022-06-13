package com.flysky.study.bytecode.bytebuddy;

import org.junit.Test;

public class SpikeTest {
    @Test
    public void test_System_mapLibraryName() {
        String attach = System.mapLibraryName("Name");
        System.out.println("attach = " + attach);


    }
}
