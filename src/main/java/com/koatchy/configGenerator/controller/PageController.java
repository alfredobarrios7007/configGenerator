package com.koatchy.configGenerator.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public interface PageController {

	@ExceptionHandler
	ModelAndView Error(Exception e);

}
