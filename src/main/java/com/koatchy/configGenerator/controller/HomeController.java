/**
 * 
 */
package com.koatchy.configGenerator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.koatchy.configGenerator.model.KeyValue;
import com.koatchy.configGenerator.tools.EncryptUtil;

/**
 * @author alfredo.barrios
 *
 */
@Controller
public class HomeController implements PageController {

	@RequestMapping("home")
	public ModelAndView home(String clave, String cadena) 
	{
		ModelAndView model = new ModelAndView("home");
		
		List<KeyValue> arr = new ArrayList<>();
		arr.add(new KeyValue(clave, cadena));
		
		String sk = "20200420T060328";
		
		try {			
			String desencritptado = EncryptUtil.decode(clave, cadena);

			KeyValue kvRequest0 = new KeyValue();
			kvRequest0.setKey("cadena");
			kvRequest0.setValue(cadena);
			arr.add(kvRequest0);
			/*---*/
			KeyValue kvRequest1 = new KeyValue();
			kvRequest1.setKey("clave");
			kvRequest1.setValue(sk);
			arr.add(kvRequest1);
			/*---*/
			KeyValue kvRequest2 = new KeyValue();
			kvRequest2.setKey("Desencriptado");
			kvRequest2.setValue(desencritptado);
			arr.add(kvRequest2);
			System.out.println("cadena: " + cadena);
			System.out.println("clave: " + clave);
			System.out.println("Desencritptado: " + desencritptado);

			
			model.addObject("objs", arr);
		}catch(Exception err) {
			System.out.println(err.toString());			
		}
	  
	  
    return model;
	}

	@Override
	public ModelAndView Error(Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

}
