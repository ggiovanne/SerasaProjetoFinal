package br.com.serasa.tarefa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.serasa.tarefa.domain.Tarefa;
import br.com.serasa.tarefa.enums.Status;
import br.com.serasa.tarefa.exceptions.ObjetoNaoEncontradoException;
import br.com.serasa.tarefa.repository.TarefaRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefaService {
	
	private TarefaRepo repo;
	
	public List<Tarefa> getTarefas() {
		List<Tarefa> tarefas = repo.findAll();
		
		return tarefas;
	}
	
	public List<Tarefa> getTarefasPorStatus(String status) {
		List<Tarefa> todasTarefas = repo.findAll();
		ArrayList<Tarefa> tarefasFiltradas = new ArrayList<>();
		
		for (Tarefa tarefa : todasTarefas) {
			if (tarefa.getStatus().equalsIgnoreCase(status)) {
				tarefasFiltradas.add(tarefa);
			}
		}
		return tarefasFiltradas;
	}
	
	public Tarefa novaTarefa(Tarefa tarefa) {
		return repo.save(tarefa);	
	}
	
	public Tarefa buscarPorId (Long id) {
		return repo.findById(id).orElseThrow(
				() -> new ObjetoNaoEncontradoException("Não foi encontrado a tarefa buscada!"));
		
	}

	public Tarefa alterarTarefa(Tarefa tarefa) {
		Optional<Tarefa> tarefaExistente = repo.findById(tarefa.getId());
		
		if (tarefaExistente.isPresent()) {
			return repo.save(tarefa);
		}
		throw new ObjetoNaoEncontradoException("Não foi possível alterar dados pois essa tarefa não existe");
		
	}
	
	public void deletar(Long id) {
		repo.deleteById(id);
	}
}
