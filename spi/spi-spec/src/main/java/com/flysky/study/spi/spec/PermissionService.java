package com.flysky.study.spi.spec;

import java.util.List;

public interface PermissionService {
    List<String> permissions(int userId);
}
