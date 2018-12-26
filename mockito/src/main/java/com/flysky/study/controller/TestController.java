//package com.flysky.study.controller;
//
//import com.flysky.study.service.MessageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.io.File;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//@Controller
//public class TestController {
//
//    @Autowired
//    private MessageService messageService;
//
//    public static void main(String[] args) {
//        del(new File("/Users/longlong/tools/develop/common/maven/repository"));
//    }
//
//    private static void del(File f) {
//        if(!f.exists()){
//            System.out.println("文件不存在"+f.getAbsolutePath());
//            return;
//        }
//        if (f.isFile()) {
//            if (f.getName().endsWith(".lastUpdated")) {
//                f.delete();
//                System.out.println("删除的文件：" + f.getAbsolutePath());
//            }
//        } else if (f.isDirectory()) {
//            File[] files = f.listFiles();
//            for(File file:files){
//                del(file);
//            }
//        }
//
//    }
//
//    @ResponseBody
//    @GetMapping("test")
//    public Object test(Test test) {
//        es.execute(new Runnable() {
//            @Override
//            public void run() {
//                int i=0;
//                while (i++<3){
//                    try {
//                        System.out.println("开始休眠+"+i);
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        messageService.say("fdsaf;");
//        return test;
//    }
//
//    private ExecutorService es= Executors.newFixedThreadPool(10);
//
//
//    public class Test {
//        private Integer id;
//        private String username;
//        private String passward;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getPassward() {
//            return passward;
//        }
//
//        public void setPassward(String passward) {
//            this.passward = passward;
//        }
//
//        @Override
//        public String toString() {
//            return "Test{" +
//                    "id=" + id +
//                    ", username='" + username + '\'' +
//                    ", passward='" + passward + '\'' +
//                    '}';
//        }
//    }
//}
