package com.framework.redis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class PropertyCopier {
	private static Logger logger = LoggerFactory.getLogger(PropertyCopier.class);

	/**
	 * 生成新的对象并拷贝属性值
	 * 
	 * @param from
	 * @param toCls
	 * @return
	 */
	public static <T, F> T copy(F from, Class<T> toCls) {
		if (from == null) {
			return null;
		}
		try {
			T to = toCls.newInstance();
			BeanUtils.copyProperties(to, from);
			return to;
		} catch (Exception e) {
			logger.error("copy property failed", e);
			;
		}
		return null;
	}

	/**
	 * 生成新的对象并拷贝属性值
	 * 
	 * @param from
	 * @param toCls
	 * @return
	 */
	public static <T, F> List<T> copy(List<F> from, Class<T> toCls) {
		if (from == null) {
			return null;
		}
		return from.stream().map(e -> copy(e, toCls)).collect(Collectors.toList());
	}
}
