package org.bricks.framework.common.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;

@RestController
public class HttpLogController {

	private static final Logger logger = LoggerFactory.getLogger(HttpLogController.class);

	@RequestMapping("/log")
	public void log(HttpServletRequest httpServletRequest) throws IOException {
		BufferedReader bufferedReader = httpServletRequest.getReader();
		String str, wholeStr = "";
		while ((str = bufferedReader.readLine()) != null) {
			wholeStr += str+"\r\n";
		}
		logger.info(wholeStr);
	}

}
