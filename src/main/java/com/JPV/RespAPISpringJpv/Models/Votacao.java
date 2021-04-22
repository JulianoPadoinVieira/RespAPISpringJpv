package com.JPV.RespAPISpringJpv.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jdk.jfr.Name;

//Faça uma API que simule a votação em uma urna eletronica para a votação para prefeito. 
//A API recebe o numero do candidato e contabiliza os votos.Tambem deve listar o resultado parcial e o resultado por candidato.


@Entity
public class Votacao {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	
		@Column(nullable = false)
		@Name("numero")
		private Long numero;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getNumero() {
			return numero;
		}

		public void setNumero(Long numero) {
			this.numero = numero;
		}
		
		
}



