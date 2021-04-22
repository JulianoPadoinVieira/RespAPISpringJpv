package com.JPV.RespAPISpringJpv.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.JPV.RespAPISpringJpv.Models.Populacao;
import com.JPV.RespAPISpringJpv.Repositories.PopulacaoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "Rest APIs População")
@RestController
@RequestMapping("/populacao")
public class PopulacaoController {
	
	
	@Autowired
	private PopulacaoRepository populacaoRepository;	
	
	@ApiOperation(value = "Cadastra uma nova população e a recebe como retorno", response = Iterable.class, tags = "Populacao")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Populacao adicionar(@RequestBody Populacao populacao) {
		
		return populacaoRepository.save(populacao);
	}
	
	@GetMapping
	@ApiOperation(value = "Lista as populações cadastradas", response = Iterable.class, tags = "Populacao")
	public List<Populacao> getPopulacao(){		
		return populacaoRepository.findAll();
		
	}
	
	@GetMapping("/{ano}")
	@ApiOperation(value = "Lista a populacao por ano", response = Iterable.class, tags = "Populacao")
	public Optional<Populacao> getPopulacaoPorAno(@PathVariable int ano){
		
		return populacaoRepository.findByAno(ano);
		
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta o respectivo ID", response = Iterable.class, tags = "Populacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePopulacao(@PathVariable Long id) {
		populacaoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Populacao updatePopulacao(@RequestBody Populacao populacao, @PathVariable Long id) {
		
		Populacao p = populacaoRepository.getOne(id);
		
		if(p == null) {
			return null;
		}
		
		p.setPopulacao(populacao.getPopulacao());
		p.setAno(populacao.getAno());
		
		return populacaoRepository.save(p);
		
	}
	
	
	
}
