package com.JPV.RespAPISpringJpv.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPV.RespAPISpringJpv.Models.Populacao;
import com.JPV.RespAPISpringJpv.Models.ProfessorAluno;


public interface ProfessorAlunoRepository extends JpaRepository<ProfessorAluno, Long>{
	
	public String findByTipo(String tipo);

}
