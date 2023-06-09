package br.com.serasa.tarefa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.serasa.tarefa.domain.Tarefa;
import br.com.serasa.tarefa.service.TarefaService;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {
	
	@Autowired
	private TarefaService service;

	@PostMapping ("/salvar")
	public String salvarTarefa(Tarefa tarefa) {
		ModelAndView mv = new ModelAndView();
		service.novaTarefa(tarefa);
		return "redirect:/tarefa/lista";
	
	}
	
	@GetMapping ("/lista")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tarefa/index");
		mv.addObject("tarefa", service.getTarefas());
		return mv;
	}
	
	@GetMapping ("/criar")
	public ModelAndView formCadastroTarefa(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Tarefa/Create");
		mv.addObject("tarefa", new Tarefa());
		return mv;
	}
	
	@GetMapping ("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		System.out.println("Passou pelo endpoint editar");
		ModelAndView mv = new ModelAndView();
		
		Tarefa tarefa = service.buscarPorId(id);
		mv.addObject("tarefa", tarefa);
		return mv;
	}
	
	@PostMapping("tarefa/editar/salvar")
	public ModelAndView alterarSalvar(Tarefa tarefa) {
		ModelAndView mv = new ModelAndView();
		service.alterarTarefa(tarefa);
		mv.setViewName("redirect:/tarefa");
		return mv;
	}
	
	@GetMapping ("/excluir/{id}")
	public String deletar(@PathVariable("id") Long id) {
		System.out.println("passou pelo endpoint delete");
		service.deletar(id);
		return "redirect:/tarefa/lista";
		
	}
}

