package com.a10d.kraft.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;
 
import org.springframework.stereotype.Service;

import ch.qos.logback.core.util.StringUtil;
import io.micrometer.common.util.StringUtils;

@Service
public class Helper {

	public boolean checkExceptionForRepositoryOperations(Supplier<Boolean> action) {
		try {
			action.get();
		}catch (Exception e) {
			throw new RuntimeException("something went wrong in making repository operation");
		}
		return true;
	}
	
	public <T,B>B mapDtoForEntityCreation(T source,B builder)  {
		var sourceClass = source.getClass();
		var targetClass = builder.getClass();
		
		var sourceFields = sourceClass.getDeclaredFields();
		
		 for(var field : sourceFields) {
			 field.setAccessible(true);
			 try {
				var value = field.get(source);
				var methodName = changeFirstWordToCapitalLetter(field.getName());
				
				var builderMethod = targetClass.getMethod(methodName, field.getType());
				builderMethod.invoke(builder, value);
				
				return builder;
			} catch (IllegalArgumentException
					| IllegalAccessException
					| InvocationTargetException
					| NoSuchMethodException
					| SecurityException e) {
				e.printStackTrace();
			}
		 }
	}
	
	private String changeFirstWordToCapitalLetter(String word) {
		if(StringUtil.isNullOrEmpty(word)) {
			return word;
		}
		return word.substring(0,1).toUpperCase().concat(word.substring(2));
	}
}
