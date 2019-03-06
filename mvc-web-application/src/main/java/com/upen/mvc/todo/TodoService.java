package com.upen.mvc.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	protected static Logger log = Logger.getLogger(TodoService.class);
	
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 9;

	static {
		todos.add(new Todo(1, "upen", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "upen", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "upen", "Learn Hibernate", new Date(), false));

		todos.add(new Todo(7, "archu", "Review Reports", new Date(), false));
		todos.add(new Todo(8, "archu", "Learn Technology", new Date(), false));
		todos.add(new Todo(9, "archu", "Revire Rohan's Study", new Date(), false));

		todos.add(new Todo(4, "rohan", "Learn Maths", new Date(), false));
		todos.add(new Todo(5, "rohan", "Learn Science", new Date(), false));
		todos.add(new Todo(6, "rohan", "Learn Computer", new Date(), false));
		
	}

	public List<Todo> retrieveTodos(String user) {

		log.info("[LOG] Objects for user " + user);
		
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}

	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {

		log.info("[LOG] Object " + desc );

		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}

	public Todo retrieveTodo(int id) {

		log.info("[LOG] Object " + id);

		for (Todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	public void updateTodo(Todo todo) {
 
		log.info("[LOG] Object " + todo);

		todos.remove(todo);
		todos.add(todo);
	}

	public void deleteTodo(int id) {
		
		log.info("[LOG] Object " + id);
		
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}
}