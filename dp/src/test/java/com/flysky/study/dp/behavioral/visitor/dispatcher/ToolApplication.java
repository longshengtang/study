package com.flysky.study.dp.behavioral.visitor.dispatcher;

import java.util.ArrayList;
import java.util.List;

public class ToolApplication {
    public static void main(String[] args) {
//        extract2txt(new Extractor());
        Visitor visitor = new Extractor();
        List<ResourceFile> resourceFiles = listAllResourceFiles();
        for (ResourceFile resourceFile : resourceFiles) {
            visitor.extract2txt(resourceFile);  // -----------
        }
    }

    private static void extract2txt(Visitor visitor){
        List<ResourceFile> resourceFiles = listAllResourceFiles();
        for (ResourceFile resourceFile : resourceFiles) {
            //extractor这个对象的实际类型可以运行时指定
            //extract2txt这个方法的签名已经编译时确定
            visitor.extract2txt(resourceFile);//如果支持又分派，就不会报错
        }
    }

    private static List<ResourceFile> listAllResourceFiles() {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        //...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PPTFile("c.ppt"));
        return resourceFiles;
    }
}
