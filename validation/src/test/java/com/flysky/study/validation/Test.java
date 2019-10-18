package com.flysky.study.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<MyUser> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MyUser u = new MyUser();
            u.setId(1);
            u.setName("-" + i);
            list.add(u);
        }
        Map<Long, MyUser> map = list.stream().collect(Collectors.toMap(MyUser::getId, u->u,(o,n)->o));
        System.out.println(map);

    }

    private static class MyUser {
        private long id;
        private String name;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
