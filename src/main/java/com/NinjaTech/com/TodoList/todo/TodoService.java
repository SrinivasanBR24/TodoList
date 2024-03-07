package com.NinjaTech.com.TodoList.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
@SessionAttributes("name")
public class TodoService {

	private static int resource_count=0;
	
	TodoRepository todoRepository;
	
	private static List<Todo> todos =  new ArrayList<>();
	
	 
	 public List<Todo> findByUsername(String username)
	 {
		 Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		 
		 return todos.stream().filter(predicate).toList();
	 }
	 
	 public void addResource(String username,String description, LocalDate targetDate,boolean isDone)
	 {
		 
		 Todo todo = new Todo(++resource_count,username, description, targetDate, isDone);
		 todos.add(todo);
	 }
	 public void deleteResourcebyId(int id)
	 {
	      Predicate<? super Todo> predicate= todo -> todo.getId()==id;
		 todos.removeIf(predicate);
	 }
	 public Todo findbyId(int id)
	 {
		 Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		 
		 Todo todo = todos.stream().filter(predicate).findFirst().get();
		 return todo;
	 }

	public void updateTodo(Todo todo) {
		// TODO Auto-generated method stub
		
		deleteResourcebyId(todo.getId());
		todos.add(todo);
	}

}
