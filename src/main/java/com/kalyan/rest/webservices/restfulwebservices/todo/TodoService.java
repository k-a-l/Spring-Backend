package com.kalyan.rest.webservices.restfulwebservices.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();

	private static int todosCount = 0;

	static {
		todos.add(new Todo(++todosCount, "kalyan", "Get AWS Certified", LocalDate.now().plusYears(10), false));
		todos.add(new Todo(++todosCount, "kalyan", "Learn DevOps", LocalDate.now().plusYears(11), false));
		todos.add(
				new Todo(++todosCount, "kalyan", "Learn Full Stack Development", LocalDate.now().plusYears(12), false));
		todos.add(new Todo(++todosCount, "ram", "Learn Full Stack Development", LocalDate.now().plusYears(12), false));
	}

	public List<Todo> findByUsername(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}

	public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
		return todo;
	}

	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;

	}

	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}

	public List<Todo> findAll() {
		return todos;
	}

//	public Todo findByUsernameID(String username, int id) {
//		Predicate<?super Todo> predicate =todo -> (todo.getId()==id || todo.getUsername()==username);
//		Todo todo=todos.stream().filter(predicate).findFirst().get();
//		
//		
//		return todo;
//	}
}