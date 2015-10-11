package com.kenzan.bowtie.http.setter;

import java.util.function.Function;

import com.kenzan.bowtie.annotation.HystrixGroup;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommand.Setter;

public class SetterFromHystrexGroup implements Function<HystrixGroup, Setter> {

	@Override
	public Setter apply(HystrixGroup hystrix) {
		return Setter.withGroupKey(
		        HystrixCommandGroupKey.Factory.asKey(hystrix.groupKey()))
		        .andCommandKey(
		                HystrixCommandKey.Factory.asKey(hystrix.commandKey()));
	}

}
