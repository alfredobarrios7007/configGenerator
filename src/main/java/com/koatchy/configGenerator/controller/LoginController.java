package com.koatchy.configGenerator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.model.KeyValue;

@Controller
public class LoginController implements PageController {

	@Autowired
	private Environment env;

	
	@RequestMapping("login")
	public ModelAndView home(KeyValue request) 
	{
		ModelAndView model = new ModelAndView("login");
		
		List<KeyValue> arr = new ArrayList<>();
		arr.add(request);
		
		KeyValue kvRequest = new KeyValue();
		kvRequest.setKey("XXX");
		kvRequest.setValue("chale, chale, chale!!!");
		arr.add(kvRequest);
		
		model.addObject("objs", arr);
		
		System.out.println("home method: " + request.toString());
		
		
		return model;
	}	
	
	@Override
	public ModelAndView Error(Exception e) {
		ModelAndView model = new ModelAndView("Error");
		model.addObject("ErrorMessage", new GeneralResponse(-200, "En Login", e.toString()));
		return model;
	}
	
}
