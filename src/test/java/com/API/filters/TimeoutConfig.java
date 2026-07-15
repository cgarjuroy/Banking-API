package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class TimeoutConfig implements Filter {
	
	private final int connectionTimeoutMs;
	private final int socketTimeoutMs;
	
	public TimeoutConfig(int connectionTimeoutMs, int socketTimeoutMs)
	{
		this.connectionTimeoutMs = connectionTimeoutMs;
		this.socketTimeoutMs = socketTimeoutMs;
	}
	
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		
		requestSpec.getConfig().getHttpClientConfig()
		.setParam("http.connection.timeout", connectionTimeoutMs)
		.setParam("http.socket.timeout", socketTimeoutMs);
		
		return ctx.next(requestSpec, responseSpec);
		
	}
}
