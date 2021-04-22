package com.JPV.RespAPISpringJpv.Controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/DataHora")
public class DataHoraController {
	
		@ApiOperation(value= "Data e hora", response = Iterable.class, tags = "DataHora")
		@GetMapping
		public String dataHora() {
			
			LocalDateTime agora = LocalDateTime.now();

			DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			String dataFormatada = formatterData.format(agora);

			DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
			String horaFormatada = formatterHora.format(agora);
			
			return dataFormatada + " - " + horaFormatada;
		}

}
