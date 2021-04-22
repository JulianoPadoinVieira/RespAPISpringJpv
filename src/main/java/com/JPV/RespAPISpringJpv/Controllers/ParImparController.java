package com.JPV.RespAPISpringJpv.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ParImpar")
public class ParImparController {
	
	@ApiOperation(value= "Par ou Ímpar", response = Iterable.class, tags = "ParImpar")
	@PostMapping
	public String parImpar(int numero) {
		
		if(numero % 2 == 0  ) {
			return "O " + numero + " é par";
		}
		else {
			return "O " + numero + " é Ímpar";
		}
		
	}

}
