package com.JPV.RespAPISpringJpv.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JPV.RespAPISpringJpv.Models.Votacao;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long>{
	
	//Para count retornar um int ou Long
	public Long countByNumero(Long numero);
	
	public Optional<Votacao> findByNumero(Long numero);
	
	//public Optional<Votacao> countByNumero(Long numero);
	
	//public Long findAllByNumero(Long numero);
	
	
	

}