package com.flysky.study.bytecode.bytebuddy.origin;

class SecuredService extends Service {
  @Override
  void deleteEverything() {
    if(UserHolder.user.equals("ADMIN")) {
      super.deleteEverything();
    } else {
      throw new IllegalStateException("Not authorized");
    }
  }
}
