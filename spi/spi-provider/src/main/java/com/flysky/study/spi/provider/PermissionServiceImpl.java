package com.flysky.study.spi.provider;

import com.flysky.study.spi.spec.PermissionService;

import java.util.Arrays;
import java.util.List;

public class PermissionServiceImpl  implements PermissionService {
    @Override
    public List<String> permissions(int userId) {
        return Arrays.asList("/user/add", "/user/delete");
    }
}
