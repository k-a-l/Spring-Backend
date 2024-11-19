package com.kalyan.rest.webservices.restfulwebservices.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kalyan.rest.webservices.restfulwebservices.todo.repository.TodoRepository;

@RestController
public class TodoJpaController {
	@Autowired
	private TodoService todoService;
	private TodoRepository todoRepository;
	
	//Constructor Autowiring
	public TodoJpaController(TodoRepository todoRepository) {
		this.todoRepository =todoRepository;
	}
	
	
	@GetMapping(path = "/users")
	public List<Todo> retriveAll() {
		return todoService.findAll();
	}
	 
	 
	@GetMapping(path = "users/{username}/todos")
	public List<Todo> retriveUser(@PathVariable String username) {
		//return todoService.findByUsername(username);
		return todoRepository.findByUsername(username);
	}
	
//	@GetMapping(path = "users/{username}/todos/{id}")
//	public Todo retriveUserId(@PathVariable String username, @PathVariable int id){
//		return todoService.findByUsernameID(username,id);
//	}
//	
	@GetMapping(path = "users/{username}/todos/{id}")
	public Optional<Todo> retriveUserId(@PathVariable String username, @PathVariable int id){
		//return todoService.findById(id);
		return todoRepository.findById(id);
	}
	
	@DeleteMapping(path = "users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteUserId(@PathVariable String username, @PathVariable int id){
		//todoService.deleteById(id);
		todoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
		//todoService.updateTodo(todo);
		todoRepository.save(todo);
		return todo;
		
	}
	
	@PostMapping(path = "users/{username}/todos")
	public Todo updateTodo(@PathVariable String username, @RequestBody Todo todo) {
		todo.setUsername(username);
		todo.setId(null);
		return todoRepository.save(todo);
//		Todo createdTodo = todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
//		return createdTodo;
		
	}
	
}
