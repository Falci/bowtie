package com.kenzan.bowtie.http.setter;

import java.lang.reflect.Method;
import java.util.function.Supplier;

import com.netflix.hystrix.HystrixCommand.Setter;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

public class SetterFromReflection implements Supplier<Setter> {

	private Method method;

	public SetterFromReflection(Method method) {

		this.method = method;
	}

	@Override
	public Setter get() {
		return Setter.withGroupKey(
				HystrixCommandGroupKey.Factory.asKey(method.getDeclaringClass()
						.getSimpleName())).andCommandKey(
				HystrixCommandKey.Factory.asKey(method.getName()));
	}

}
