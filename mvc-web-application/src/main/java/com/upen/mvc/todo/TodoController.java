package com.upen.mvc.todo;
 
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService service;

	protected static Logger log = Logger.getLogger(TodoController.class);

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String listTodos(ModelMap model) {

		String user = (String) model.get("name");
		model.addAttribute("todos",service.retrieveTodos(user));
		log.warn ("[LOG] Model : " + model);
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showNewTodo(ModelMap model) {
		model.addAttribute("todo",new Todo());
		return "todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			log.info("[LOG] validation error : " + result);				
			return "todo";
		}
		service.addTodo((String) model.get("name"),todo.getDesc(),new Date(),false);

		log.warn("[LOG] Model : " + model);		
		return "redirect:list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showupdateTodo(ModelMap model, @RequestParam int id) {
		model.addAttribute("todo",service.retrieveTodo(id));
		log.warn("[LOG] Model : " + model);		
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		if (result.hasErrors()){
			log.info("[LOG] validation error : " + result);				
			return "todo";
		}

		log.info("[LOG] model + todo : " + model + todo);				
	
		todo.setUser((String)model.get("name"));
		service.updateTodo(todo);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(Todo todo) {
		service.deleteTodo(todo.getId());
		return "redirect:list-todos";
	}
	
}
