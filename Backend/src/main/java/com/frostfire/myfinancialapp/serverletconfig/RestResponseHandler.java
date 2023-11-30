package com.frostfire.myfinancialapp.serverletconfig;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class RestResponseHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		// TODO Add Logger
		System.out.println("RestResponseHandler (hasError): " + response.getStatusCode());
		return false;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		// TODO Add Logger
		System.out.println("RestResponseHandler (handleError): " + response.getStatusCode());

	}

}
