package br.com.serasa.controller;

import br.com.serasa.dao.TarefaDao;
import br.com.serasa.model.Tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TarefaController {

	@Autowired
	private TarefaDao tarefaDao;

	@GetMapping("tarefa")
	public ModelAndView Lista() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tarefa/index");
		mv.addObject("tarefa", tarefaDao.findAll());
		return mv;
	}

	@GetMapping("/tarefa/cadastrar")
	public ModelAndView cadastrar(Tarefa tarefa) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Tarefa/Create");
		mv.addObject("tarefa", new Tarefa());
		return mv;
	}

	@PostMapping("tarefa/salvar")
	public String salvar(Tarefa tarefa) {
		ModelAndView mv = new ModelAndView();
		tarefaDao.save(tarefa);
		return "redirect:/tarefa";
	}

	@GetMapping("tarefa/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		Tarefa tarefa = tarefaDao.getOne(id);
		mv.setViewName("Tarefa/Alterar");
		mv.addObject("tarefa", tarefa);
		return mv;
	}

	@PostMapping("tarefa/alterar/salvar")
	public ModelAndView alterarSalvar(Tarefa tarefa) {
		ModelAndView mv = new ModelAndView();
		tarefaDao.save(tarefa);
		mv.setViewName("redirect:/tarefa");
		return mv;
	}

	@GetMapping("tarefa/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		tarefaDao.deleteById(id);
		return "redirect:/tarefa";
	}

}
