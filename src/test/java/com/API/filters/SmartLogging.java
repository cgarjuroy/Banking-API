package com.api.filters;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.filter.log.LogDetail;
import io.restassured.internal.print.RequestPrinter;
import io.restassured.internal.print.ResponsePrinter;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class SmartLogging implements Filter{

	private static final Logger logger = LogManager.getLogger(SmartLogging.class);
	
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		
		Response response = ctx.next(requestSpec, responseSpec);
		
		if(response.statusCode() >=400)
		{
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PrintStream printStream = new PrintStream(outputStream);
			
			printStream.println("\n=========================== API FAILURE TELEMETRY==========================");
			
			RequestPrinter.print(requestSpec, requestSpec.getMethod(), requestSpec.getURI(),
					LogDetail.ALL, null, printStream, true);
			
			printStream.print("-------------------------------------------------------------------------------");
			
			ResponsePrinter.print(response, response, printStream, LogDetail.ALL, true, null);

			printStream.print("-------------------------------------------------------------------------------");
			
			logger.error(outputStream.toString());
		}
		
		return response;
	}

}
