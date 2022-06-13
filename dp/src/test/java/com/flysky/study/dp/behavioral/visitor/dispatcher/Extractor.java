package com.flysky.study.dp.behavioral.visitor.dispatcher;

public class Extractor implements Visitor {
  @Override
  public void extract2txt(PPTFile pptFile) {
    //...
    System.out.println("Extract PPT.");
  }

  @Override
  public void extract2txt(PdfFile pdfFile) {
    //...
    System.out.println("Extract PDF.");
  }

  @Override
  public void extract2txt(WordFile wordFile) {
    //...
    System.out.println("Extract WORD.");
  }

  @Override
  public void extract2txt(ResourceFile resourceFile) {
    System.out.println("Extract ResourceFile.");
  }
}
