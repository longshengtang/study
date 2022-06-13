package com.flysky.study.dp.behavioral.visitor.dispatcher;

public abstract class ResourceFile {
  protected String filePath;
  public ResourceFile(String filePath) {
    this.filePath = filePath;
  }
}
