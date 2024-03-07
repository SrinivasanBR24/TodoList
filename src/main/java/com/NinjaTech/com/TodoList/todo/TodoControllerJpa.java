package com.NinjaTech.com.TodoList.todo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

	
	private TodoRepository todoRepository;
	
	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@GetMapping("/list-todos")
	public String listAllTodos(ModelMap model)
	{
		String username = getLoggedUsername(model);
		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos",todos);
		return "todo";
	}

	
	@RequestMapping (value="create-todo",method=RequestMethod.GET)
	public String showNewTodo( ModelMap model)
	{
		String username = getLoggedUsername(model);
		Todo todo=new Todo(0,username," ",LocalDate.now().plusWeeks(12), false);
		model.put("todo",todo);
		return "new-todo";
	}
	
	@RequestMapping(value="create-todo",method = RequestMethod.POST)
	public String createNewTodo( ModelMap model,@Valid Todo todo ,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "new-todo";
		}
		String username = getLoggedUsername(model); 	
		todo.setusername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping ("delete-todo")
	public String deleteTodo(@RequestParam int id)
	{
		//todoservice.deleteResourcebyId(id);
		
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}

	
	@RequestMapping(value="update-todo",method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id,ModelMap model)
	{
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		
		return "new-todo";
	}
	
	
	@RequestMapping(value="update-todo",method = RequestMethod.POST)
	public String UpdateTodoPage(ModelMap model,@Valid Todo todo,BindingResult result)
	{
		if(result.hasErrors())
			{
	           return "new-todo";
	           
			}
		String username = getLoggedUsername(model);
			todo.setusername(username);
			todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedUsername(ModelMap model) {
		
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
}
