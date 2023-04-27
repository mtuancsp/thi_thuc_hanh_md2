package view;

import controller.StudentManager;
import get_input.Input;
import read_write.StudentCSV;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    // main menu
    public static void mainMenu(StudentManager studentManager) throws IOException {
        do {
            displayMainMenu();
            Scanner sc = new Scanner(System.in);
            int choice = Input.getValidIntChoice(1, 8);
            switch (choice) {
                case 1 -> studentManager.displayStudents();
                case 2 -> studentManager.addStudent();
                case 3 -> studentManager.updateStudent();
                case 4 -> studentManager.deleteStudent();
                case 5 -> studentManager.sortStudent();
                case 6 -> studentManager.readFile();
                case 7 -> studentManager.writeFile();
                case 8 -> System.out.println("Thoát");
                default -> {
                }
            }
        } while (true);
    }

    public static void displayMainMenu() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách sinh viên");
        System.out.println("2. Thêm sinh viên");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public static void returnOrExit() {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Nhập '0' để quay lại hoặc 'Exit' để thoát hoàn toàn chương trình: ");
            input = scanner.nextLine();

            switch (input) {
                case "0" -> {
                    return;
                }
                case "Exit" -> System.exit(0);
                default -> System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
            }
        } while (true);
    }

}
