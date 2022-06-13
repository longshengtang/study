package com.flysky.study.spike.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Command {
    public Command() {
        this.addResolves(()->{});
    }

    public boolean invoke() throws RuntimeException {
        return false;
    }

    public void tryInit(boolean slientInit) throws Throwable {
        Iterator<Runnable> resolveIterator = resolves.iterator();
        while (resolveIterator.hasNext()) {
            try {
                resolveIterator.next().run();
                this.invoke();
            } catch (Throwable e) {
                if (e instanceof UnsatisfiedLinkError/**&& is attach error*/ && resolveIterator.hasNext()) {
                    continue;
                }
                if (!slientInit) {
                    throw e;
                }
            }
        }
    }

    public void addResolves(Runnable resolve) {
        resolves.add(resolve);
    }

    private List<Runnable> resolves = new ArrayList<>();
}
