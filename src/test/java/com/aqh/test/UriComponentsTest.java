package com.aqh.test;

import org.junit.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UriComponentsTest {

	@Test
	public void testURI() throws Exception {

	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	            .path("/{module}/{list}")
	            .queryParam("page", 3)
	            .queryParam("category", "QNA_TECH")
	            .build()
	            .expand("QnA","list")
	            .encode();

	    log.info("/QnA/list?page=3&category=QNA_TECH");
	    log.info(uriComponents.toString());

	}
}
