package br.com.serasa.tarefa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.serasa.tarefa.domain.Tarefa;
import br.com.serasa.tarefa.service.TarefaService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired
	private TarefaService service;

	@PostMapping ("/salvar")
	public String salvarTarefa(@ModelAttribute("tarefa") @Validated Tarefa tarefa, BindingResult result) {
		
		service.novaTarefa(tarefa);
		return "tarefa-salva-ok";
	}
	
	@GetMapping ("/home")
	public String home() {
		return "tarefa-home";
	}
	
	@GetMapping ("form-cadastro")
	public String formCadastroTarefa(Model model) {
		model.addAttribute("tarefa", new Tarefa());
		return "tarefa-cadastro";
	}
}

