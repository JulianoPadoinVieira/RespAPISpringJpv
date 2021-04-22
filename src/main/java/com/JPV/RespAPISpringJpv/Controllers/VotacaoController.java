package com.JPV.RespAPISpringJpv.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.JPV.RespAPISpringJpv.Models.Populacao;
import com.JPV.RespAPISpringJpv.Models.Votacao;
import com.JPV.RespAPISpringJpv.Repositories.VotacaoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//Faça uma API que simule a votação em uma urna eletronica para a votação para prefeito. 
//A API recebe o numero do candidato e contabiliza os votos. Tambem deve listar o resultado parcial e o resultado por candidato.
@Api(value = "Swagger2RestController", description = "Rest APIs Urna Eletrônica")
@RestController
@RequestMapping("/urnaEletronica")
public class VotacaoController {
		
		@Autowired
		private VotacaoRepository votacaoRepository;
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		@ApiOperation(value = "1 - Inserção do candidato", response = Iterable.class, tags = "Urna")
		public Votacao add(@RequestBody Votacao votacao){
			return votacaoRepository.save(votacao);
		}		
		
		@GetMapping
		@ApiOperation(value = "2 - Retorna todos os votos", response = Iterable.class, tags = "Urna")
		public List<Votacao> getVotacao(){
			
			return votacaoRepository.findAll();
		}
		
		@GetMapping("/quantidade/{numero}")
		@ApiOperation(value = "3 - Contagem por candidato", response = Iterable.class, tags = "Urna")
		public Long getVotacaoCandidato(@PathVariable Long numero){
			
			    //Retornar um int ou Long
				return votacaoRepository.countByNumero(numero);
		}
		
		
		/*
		 * @GetMapping("/porCandidato/{numero}")
		 * 
		 * @ApiOperation(value = "4 - Contagem por candidato", response =
		 * Iterable.class, tags = "Urna") public Long
		 * getVotacaoPorCandidato(getVotacao(), @PathVariable Long numero){
		 * 
		 * return votacaoRepository.findByNumero(numero);
		 * 
		 * }
		 */
		
				
		/*
		 * public Optional<Votacao> findByNumero(Long numero);
		 * 
		 * //Para count retornar um int ou Long 
		 * public Long countByNumero(Long numero);
		 */
				 
}


