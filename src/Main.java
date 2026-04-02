import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login/Registration
        LoginManager loginManager = new LoginManager(scanner);
        User loggedInUser = loginManager.authenticate();

        System.out.println("\n--- ỨNG DỤNG TO-DO LIST ---");
        TodoManager todoManager = new TodoManager();

        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm công việc");
            System.out.println("3. Đánh dấu công việc hoàn thành");
            System.out.println("4. Bỏ đánh dấu công việc");
            System.out.println("5. Xóa công việc");
            System.out.println("6. Xem thống kê");
            System.out.println("7. Thoát");
            System.out.print("Chọn tùy chọn (1-7): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\n--- DANH SÁCH CỦA BẠN (" + loggedInUser.getUsername() + ") ---");
                    todoManager.displayTodos();
                    break;

                case "2":
                    System.out.print("Nhập công việc mới: ");
                    String newTask = scanner.nextLine();
                    if (!newTask.isEmpty()) {
                        todoManager.addTodo(newTask);
                        System.out.println("✓ Công việc đã được thêm!");
                    } else {
                        System.out.println("✗ Công việc không được để trống!");
                    }
                    break;

                case "3":
                    System.out.println("\n--- DANH SÁCH CỦA BẠN ---");
                    todoManager.displayTodos();
                    System.out.print("Chọn số công việc để đánh dấu hoàn thành: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine()) - 1;
                        todoManager.markTodoComplete(index);
                        System.out.println("✓ Công việc đã được đánh dấu hoàn thành!");
                    } catch (NumberFormatException e) {
                        System.out.println("✗ Vui lòng nhập một số hợp lệ!");
                    }
                    break;

                case "4":
                    System.out.println("\n--- DANH SÁCH CỦA BẠN ---");
                    todoManager.displayTodos();
                    System.out.print("Chọn số công việc để bỏ đánh dấu: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine()) - 1;
                        todoManager.markTodoIncomplete(index);
                        System.out.println("✓ Công việc đã được bỏ đánh dấu!");
                    } catch (NumberFormatException e) {
                        System.out.println("✗ Vui lòng nhập một số hợp lệ!");
                    }
                    break;

                case "5":
                    System.out.println("\n--- DANH SÁCH CỦA BẠN ---");
                    todoManager.displayTodos();
                    System.out.print("Chọn số công việc để xóa: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine()) - 1;
                        todoManager.removeTodo(index);
                        System.out.println("✓ Công việc đã được xóa!");
                    } catch (NumberFormatException e) {
                        System.out.println("✗ Vui lòng nhập một số hợp lệ!");
                    }
                    break;

                case "6":
                    System.out.println("\n--- THỐNG KÊ ---");
                    System.out.println("Tổng công việc: " + todoManager.getTodoCount());
                    System.out.println("Công việc hoàn thành: " + todoManager.getCompletedCount());
                    System.out.println("Công việc chưa hoàn thành: " + (todoManager.getTodoCount() - todoManager.getCompletedCount()));
                    break;

                case "7":
                    running = false;
                    System.out.println("\nCảm ơn " + loggedInUser.getUsername() + " đã sử dụng ứng dụng To-Do List!");
                    break;

                default:
                    System.out.println("✗ Tùy chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}