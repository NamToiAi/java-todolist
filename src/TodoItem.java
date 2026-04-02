public class TodoItem {
    private String description;
    private boolean completed;

    public TodoItem(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markComplete() {
        this.completed = true;
    }

    public void markIncomplete() {
        this.completed = false;
    }

    @Override
    public String toString() {
        String status = completed ? "✓" : "○";
        return status + " " + description;
    }
}

