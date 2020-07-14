package com.koatchy.configGenerator.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public interface IPageController {

	@ExceptionHandler
	ModelAndView Error(Exception e);

}
