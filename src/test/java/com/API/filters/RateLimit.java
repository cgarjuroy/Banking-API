	package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.SneakyThrows;


public class RateLimit implements Filter{
	
	private static final int MAX_COUNT = 3;
	private int count  = 0;
	
	
	@SneakyThrows
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		
		Response response =  ctx.next(requestSpec, responseSpec);
		
		while(response.getStatusCode()==429 && count<MAX_COUNT)
		{
			String retryHeader =  response.getHeader("Retry-After");
			
			long waitTime = (retryHeader!=null)?Long.parseLong(retryHeader):5;
			
			System.err.println("Rate limit hit! Backing off for " +waitTime+ " seconds... (Attempt "+(count + 1)+")");
			
			Thread.sleep(waitTime *1000);
			
			response = ctx.next(requestSpec, responseSpec);
			count++;
		}
		
		return response;
	}

}
