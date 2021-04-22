package com.JPV.RespAPISpringJpv.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPV.RespAPISpringJpv.Models.Populacao;

public interface PopulacaoRepository extends JpaRepository<Populacao, Long>{	
	
	public Optional<Populacao> findByAno(int ano);
	
	
}
