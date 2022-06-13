package com.flysky.study.bytecode.bytebuddy.origin;

class HardcodedFrameworkImpl implements Framework {
  @Override
  public <T> T secure(Class<T> type) {
    if(type == Service.class) {
      return (T) new SecuredService();
    } else {
      throw new IllegalArgumentException("Unknown: " + type);
    }
  }
}
