package com.flysky.study.dp.behavioral.visitor.dispatcher;

public interface Visitor {
    void extract2txt(PPTFile pptFile);

    void extract2txt(PdfFile pdfFile);

    void extract2txt(WordFile wordFile);

    void extract2txt(ResourceFile resourceFile);
}
