package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class CustomError implements Filter{
	
	@Override
	public Response filter(FilterableRequestSpecification ReqSpec, FilterableResponseSpecification ResSpec, FilterContext ctx)
	{
		Response response = ctx.next(ReqSpec,ResSpec);
		
		
		if(response.statusCode()>=400)
		{
			throw new RuntimeException("Status code generated is "+response.getStatusCode());
		}
		return response;
	}
}
