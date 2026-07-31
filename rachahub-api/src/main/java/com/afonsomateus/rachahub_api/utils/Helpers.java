package com.afonsomateus.rachahub_api.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Helpers {
	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		PropertyDescriptor[] properties = src.getPropertyDescriptors();
		
		Set<String> emptyNames = new HashSet<String>();
		
		for (PropertyDescriptor property: properties) {
			String name = property.getName();
			Object srcValue = src.getPropertyValue(name);
			if (srcValue == null) emptyNames.add(name);
		}
		
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}
}
