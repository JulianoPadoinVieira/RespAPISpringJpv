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

import com.JPV.RespAPISpringJpv.Models.ProfessorAluno;
import com.JPV.RespAPISpringJpv.Repositories.ProfessorAlunoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController", description = "Rest APIs População")
@RestController
@RequestMapping("/ProfessorAluno")
public class ProfessorAlunoController {
		
		
		@Autowired
		private ProfessorAlunoRepository professorAlunoRepository;	
		
		//Cadastra
		@ApiOperation(value = "Cadastrar um novo professor ou aluno", response = Iterable.class, tags = "ProfessorAluno")
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public ProfessorAluno adicionar(@RequestBody ProfessorAluno professorAluno) {
			
			return professorAlunoRepository.save(professorAluno);
		}
		
		//Lista todos
		@GetMapping
		@ApiOperation(value = "Lista todos cadastrados.", response = Iterable.class, tags = "ProfessorAluno")
		public List<ProfessorAluno> getProfessorAluno(){
			
			return professorAlunoRepository.findAll();
			
		}
		
		//Lista por tipo
		@GetMapping("/{tipo}")
		@ApiOperation(value = "Lista por tipo", response = Iterable.class, tags = "ProfessorAluno")
		public String getProfessorAluno(@PathVariable String tipo){
			
			return professorAlunoRepository.findByTipo(tipo);
			
		}
		
		//Deletar
		@DeleteMapping("/{delete}")
		@ApiOperation(value = "Deleta o respectivo ID", response = Iterable.class, tags = "ProfessorAluno")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deleteProfessorAluno(@PathVariable Long id) {
			professorAlunoRepository.deleteById(id);
		}
		
		//Alterar
		@PutMapping("/{update}")
		public ProfessorAluno updateProfesorAluno(@RequestBody ProfessorAluno professorAluno, @PathVariable Long id) {
			
			ProfessorAluno pa = professorAlunoRepository.getOne(id);
			
			if(pa == null) {
				return null;
			}
			
			pa.setTipo(professorAluno.getTipo());
			pa.setNome(professorAluno.getNome());
			
			return professorAlunoRepository.save(pa);
			
		}
		
		

}
