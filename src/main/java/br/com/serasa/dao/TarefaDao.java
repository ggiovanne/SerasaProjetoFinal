package br.com.serasa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import br.com.serasa.model.Tarefa;

public interface TarefaDao extends JpaRepository<Tarefa, Long> {
	Tarefa getOne (Long id);
	Optional<Tarefa> findById (Long id);
	 
}
