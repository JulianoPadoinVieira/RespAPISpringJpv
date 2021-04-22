package com.JPV.RespAPISpringJpv.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/FahrenheitCelcius")
public class FahrenheitCelciusController {
		
			@ApiOperation(value= "Fahrenheit para Celcius", response = Iterable.class, tags = "FahrenheitCelcius")
			@PostMapping
			public float conversaoFahrenheitCelcius(float temperatura) {	
				
				return  (temperatura - 32) * 5 / 9;
			}

}
