package com.flysky.study.validation.spring;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
public class MethodValidationController {

    @RequestMapping("/a")
    public Object test(@NotBlank String a, @Min(0) @NotNull Integer b) {
        Map<String, String> result = new HashMap<>();
        result.put("a",a);
        result.put("b",b+"");
        result.put("c","c");
        return result;
    }
}
