package com.flysky.study.mybatis.controller;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 验证对象属性合法性工具。以一种更优雅的方式来验证对象的属性值
 *
 * @author longshengtang
 *
 */
public class MyValidatorUtil {

	/**
	 * 验证对象obj是否具有不合法属性值。由于Validator的实现是线程安全，故此方法无须使用同步。<br>
	 * 接口{@link Validator} 描述说其实现者必须线程安全<br>
	 * 但我并没有去考证Hibernate提供的实现
	 * {@link org.hibernate.validator.internal.engine.ValidatorImpl}是否线程安全
	 *
	 * @param obj
	 *            待验证的对象
	 * @return 如果具有不合法属性，返回错误信息字符串；否则返回null
	 */
	public static String validate(Object obj) {
		StringBuilder sb = new StringBuilder();
		Set<ConstraintViolation<Object>> validate = validator.validate(obj);
		for (ConstraintViolation<Object> constraintViolation : validate) {
			sb.append("属性" + constraintViolation.getPropertyPath() + "," + constraintViolation.getMessage() + ";");
		}
		return sb.length() > 0 ? sb.toString() : null;
	}

	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
}