import java.util.Scanner;

public class LoginManager {
    private UserManager userManager;
    private Scanner scanner;
    private User currentUser;

    public LoginManager(Scanner scanner) {
        this.userManager = new UserManager();
        this.scanner = scanner;
        this.currentUser = null;
    }

    public User authenticate() {
        while (currentUser == null) {
            System.out.println("\n--- HỆ THỐNG ĐĂNG NHẬP ---");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.print("Chọn tùy chọn (1 hoặc 2): ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                currentUser = performLogin();
            } else if (choice.equals("2")) {
                performRegistration();
            } else {
                System.out.println("Tùy chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
        return currentUser;
    }

    private User performLogin() {
        System.out.print("Tên đăng nhập: ");
        String username = scanner.nextLine();
        System.out.print("Mật khẩu: ");
        String password = scanner.nextLine();

        User user = userManager.login(username, password);
        if (user != null) {
            System.out.println("Đăng nhập thành công! Chào mừng, " + username + "!");
            return user;
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không chính xác. Vui lòng thử lại.");
            return null;
        }
    }

    private void performRegistration() {
        System.out.print("Tên đăng nhập mới: ");
        String username = scanner.nextLine();

        if (userManager.userExists(username)) {
            System.out.println("Tên đăng nhập này đã tồn tại. Vui lòng chọn tên khác.");
            return;
        }

        System.out.print("Mật khẩu: ");
        String password = scanner.nextLine();
        System.out.print("Xác nhận mật khẩu: ");
        String confirmPassword = scanner.nextLine();

        if (!password.equals(confirmPassword)) {
            System.out.println("Mật khẩu không trùng khớp. Vui lòng thử lại.");
            return;
        }

        if (userManager.register(username, password)) {
            System.out.println("Đăng ký thành công! Bây giờ bạn có thể đăng nhập.");
        } else {
            System.out.println("Đăng ký thất bại. Vui lòng thử lại.");
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }
}

