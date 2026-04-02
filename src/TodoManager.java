import java.util.ArrayList;
import java.util.List;

public class TodoManager {
    private List<TodoItem> todos;

    public TodoManager() {
        this.todos = new ArrayList<>();
    }

    public void addTodo(String description) {
        todos.add(new TodoItem(description));
    }

    public void markTodoComplete(int index) {
        if (isValidIndex(index)) {
            todos.get(index).markComplete();
        }
    }

    public void markTodoIncomplete(int index) {
        if (isValidIndex(index)) {
            todos.get(index).markIncomplete();
        }
    }

    public void removeTodo(int index) {
        if (isValidIndex(index)) {
            todos.remove(index);
        }
    }

    public void displayTodos() {
        if (todos.isEmpty()) {
            System.out.println("Danh sách của bạn trống.");
            return;
        }
        for (int i = 0; i < todos.size(); i++) {
            System.out.println((i + 1) + ". " + todos.get(i));
        }
    }

    public int getTodoCount() {
        return todos.size();
    }

    public int getCompletedCount() {
        int count = 0;
        for (TodoItem todo : todos) {
            if (todo.isCompleted()) {
                count++;
            }
        }
        return count;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < todos.size();
    }
}

