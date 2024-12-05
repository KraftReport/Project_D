package com.a10d.kraft.service.helper;
 
import java.util.function.Supplier;
 
import org.springframework.stereotype.Service;

import ch.qos.logback.core.util.StringUtil; 

@Service
public class Helper {

	public boolean checkExceptionForRepositoryOperations(Supplier<Boolean> action) {
		try {
			return action.get();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} 
	}
	
 
	
	public <T> T exceptionHandlerForMappingEntity(ThrowableSupplier<T> action) {
	    try {
	        return action.get();
	    } catch (Exception ex) {
	        throw new RuntimeException("Error during entity mapping: " + ex.getMessage(), ex);
	    }
	}

	public <T, B> B mapDtoForEntityCreation(T source, B builder) {
	    return exceptionHandlerForMappingEntity(() -> {
	        var sourceClass = source.getClass();
	        var targetClass = builder.getClass();
	        var sourceFields = sourceClass.getDeclaredFields();

	        for (var field : sourceFields) {
	            field.setAccessible(true); 
	            var value = field.get(source);  
	            var methodName = changeFirstWordToCapitalLetter(field.getName());
	            var builderMethod = targetClass.getMethod("get"+methodName, field.getType());  
	            builderMethod.invoke(builder, value);  
	        }
	        return builder;
	    });
	}

	
	private String changeFirstWordToCapitalLetter(String word) {
		if(StringUtil.isNullOrEmpty(word)) {
			return word;
		}
		return word.substring(0,1).toUpperCase().concat(word.substring(1));
	}
}
