package com.flysky.study.bytecode.bytebuddy.origin;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Secured {
  String user();
}
