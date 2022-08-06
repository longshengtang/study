package com.flysky.study.spi.invoker;

import com.flysky.study.spi.spec.PermissionService;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiInvokerMain {
    public static void main(String[] args) {
        ServiceLoader<PermissionService> load = ServiceLoader.load(PermissionService.class);
        Iterator<PermissionService> iterator = load.iterator();
        while (iterator.hasNext()) {
            PermissionService next = iterator.next();
            System.out.println("next = " + next);
            System.out.println("next.permissions(1) = " + next.permissions(1));
        }

        System.out.println("\"iterator\" = " + iterator);

    }
}
