package com.edsonj.tangent.util;
import org.springframework.http.HttpHeaders;

public class AuthHelper {

	public static HttpHeaders createHttpHeaders(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization",String.format("Token %s", token));
		return headers;
	}
}
