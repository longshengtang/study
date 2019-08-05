package com.flysky.study.dbunit.mapper;

import java.io.File;
import java.util.Arrays;

public class MavenClear {
    public static void main(String[] args) {
        delete(new File("/Users/longlong/tools/develop/common/maven/repository/"));
    }

    private static void delete(File file){
//        System.out.println(file);
        if(file.isFile()){
            if(file.getName().endsWith(".lastUpdated")){
                System.out.println("删除文件："+file.getAbsoluteFile().getName());
                file.delete();
            }
        }else if (file.isDirectory()){
            File[] files = file.listFiles();
            Arrays.stream(files).forEach(f->{
                delete(f);
            });
        }
    }
}
