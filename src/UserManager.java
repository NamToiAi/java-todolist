import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> users;

    public UserManager() {
        users = new HashMap<>();
        // Initialize with a default user
        users.put("demo", new User("demo", "123456"));
    }

    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        if (username.isEmpty() || password.isEmpty()) {
            return false; // Empty credentials
        }
        users.put(username, new User(username, password));
        return true;
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.verifyPassword(password)) {
            return user;
        }
        return null; // Login failed
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }
}

