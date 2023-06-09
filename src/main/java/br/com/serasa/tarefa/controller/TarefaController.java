package br.com.serasa.tarefa.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.serasa.tarefa.domain.Tarefa;
import br.com.serasa.tarefa.service.TarefaService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/tarefa")
public class TarefaController {

	List<Tarefa> tarefas = new ArrayList<>();
	
	@Autowired
	private TarefaService service;

	@PostMapping ("/salvar")
	public String salvarTarefa(Tarefa tarefa) {
		//service.novaTarefa(tarefa);
		tarefas.add(tarefa);
		System.out.println("Passou pelo endpoint salvar");
		
		return "redirect:/tarefa/lista";
	
	}
	
	@GetMapping ("/home")
	public String home() {
		System.out.println("Passou pelo endpoint home");
		return "redirect:/tarefa/lista";
	}
	
	@GetMapping ("/lista")
	public ModelAndView lista() {
		System.out.println("Passou pelo endpoint lista");
		//List<Tarefa> tarefas = service.getTarefas();
		ModelAndView md = new ModelAndView("lista");
		md.addObject("tarefas", tarefas);
		return md;
	}
	
	@GetMapping ("/criar")
	public String formCadastroTarefa(Model model) {
		System.out.println("Passou pelo endpoint criar");
		model.addAttribute("tarefa", new Tarefa());
		return "/tarefa-cadastro";
	}
	
	@GetMapping ("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		System.out.println("Passou pelo endpoint editar");
		ModelAndView model = new ModelAndView();
		
		Tarefa tarefa = service.buscarPorId(id);
		model.addObject("tarefa", tarefa);
		return model;
	}
	
	@DeleteMapping ("/excluir/{id}")
	public String deletar(@PathVariable Long id) {
		System.out.println("passou pelo endpoint delete");
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getId() == id) {
				tarefas.remove(id);
				break;
			}
		}
		return "redirect:/tarefa/lista";
		
	}
}

