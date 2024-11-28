package com.a10d.kraft.service.helper;

@FunctionalInterface
public interface ThrowableSupplier<T> {
	T get() throws Exception;
}
