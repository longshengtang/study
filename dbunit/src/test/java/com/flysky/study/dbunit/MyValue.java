package com.flysky.study.dbunit;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyValue {

	/**
	 * The actual value expression: for example {@code #{systemProperties.myProp}}.
	 */
	String value();

}