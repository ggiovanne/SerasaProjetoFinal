package br.com.serasa.tarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serasa.tarefa.domain.Tarefa;

public interface TarefaRepo extends JpaRepository<Tarefa, Integer> {

}
