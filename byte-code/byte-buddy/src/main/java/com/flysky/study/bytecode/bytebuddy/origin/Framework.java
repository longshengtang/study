package com.flysky.study.bytecode.bytebuddy.origin;

interface Framework {
  <T> T secure(Class<T> type);
}
