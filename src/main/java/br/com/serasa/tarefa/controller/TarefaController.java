package br.com.serasa.tarefa.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		System.out.println("Eu sou gostoso");
		return "redirect:/tarefa/lista";
	
	}
	
	@GetMapping ("/home")
	public String home() {
		return "redirect:/tarefa/lista";
	}
	
	@GetMapping ("/lista")
	public ModelAndView lista() {
		//List<Tarefa> tarefas = service.getTarefas();
		ModelAndView md = new ModelAndView("lista");
		md.addObject("tarefas", tarefas);
		return md;
	}
	
	@GetMapping ("/criar")
	public String formCadastroTarefa(Model model) {
		System.out.println("sou gostoso");
		model.addAttribute("tarefa", new Tarefa());
		return "/tarefa-cadastro";
	}
}

