package com.kalyan.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@CrossOrigin(origins = "http://spring")
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	
	@GetMapping(path = "/users")
	public List<Todo> retriveAll() {
		return todoService.findAll();
	}
	 
	 
	@GetMapping(path = "users/{username}/todos")
	public List<Todo> retriveUser(@PathVariable String username) {
		return todoService.findByUsername(username);
		
	}
	
//	@GetMapping(path = "users/{username}/todos/{id}")
//	public Todo retriveUserId(@PathVariable String username, @PathVariable int id){
//		return todoService.findByUsernameID(username,id);
//	}
//	
	@GetMapping(path = "users/{username}/todos/{id}")
	public Todo retriveUserId(@PathVariable String username, @PathVariable int id){
		return todoService.findById(id);
	}
	
	@DeleteMapping(path = "users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteUserId(@PathVariable String username, @PathVariable int id){
		todoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
		todoService.updateTodo(todo);
		return todo;
		
	}
	
	@PostMapping(path = "users/{username}/todos")
	public Todo updateTodo(@PathVariable String username, @RequestBody Todo todo) {
		Todo createdTodo = todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
		return createdTodo;
		
	}
	
}
