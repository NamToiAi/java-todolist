import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> todoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- ỨNG DỤNG TO-DO LIST ---");

        while (true) {
            System.out.print("Nhập công việc mới (gõ 'q' để thoát): ");
            String task = scanner.nextLine();

            if (task.equalsIgnoreCase("q")) {
                break;
            }
            todoList.add(task);
        }

        System.out.println("\n--- DANH SÁCH CỦA BẠN ---");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ". " + todoList.get(i));
        }
    }
}