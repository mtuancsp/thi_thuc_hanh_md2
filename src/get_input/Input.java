package get_input;

import model.Student;

import java.util.List;
import java.util.Scanner;

public class Input {
    //check exist code
    public boolean checkExistCode(String code, List<Student> listStudents) {
        for (Student student : listStudents) {
            if (student.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    //getExistCode


    public String getValidFullName() {
        Scanner scanner = new Scanner(System.in);
        String fullName;
        do {
            System.out.print("Nhập họ và tên: ");
            fullName = scanner.nextLine();
            if (!fullName.matches("^[\\p{L}\\s]+(?:\\s[\\p{L}\\s]+)+$")) {
                System.err.println("Tên không hợp lệ. Vui lòng kiểm tra lại.");
                continue;
            }
            return fullName;

        } while (true);
    }

    //getValidAge
    public int getValidAge() {
        Scanner scanner = new Scanner(System.in);
        int age;
        boolean isValidAge = false;
        do {
            System.out.print("Nhập tuổi: ");
            age = scanner.nextInt();
            if (age <= 0 || age > 100) {
                System.err.println("Tuổi không hợp lệ. Vui lòng kiểm tra lại.");
            } else {
                isValidAge = true;
            }
        } while (!isValidAge);
        return age;
    }


    public String getValidGender() {
        Scanner scanner = new Scanner(System.in);
        String gender;
        do {
            System.out.print("Nhập giới tính (Nam/Nữ/Khác): ");
            gender = scanner.nextLine();
            if (!gender.equalsIgnoreCase("Nam") && !gender.equalsIgnoreCase("Nữ") && !gender.equalsIgnoreCase("Khác")) {
                System.err.println("Giới tính không hợp lệ. Vui lòng kiểm tra lại.");
                continue;
            }
            return gender;
        } while (true);
    }


    public String getValidAddress() {
        Scanner scanner = new Scanner(System.in);
        String address;
        System.out.print("Nhập địa chỉ: ");
        address = scanner.nextLine();
        return address;
    }

    public double getValidAvgMark() {
        Scanner scanner = new Scanner(System.in);
        double avgMark;
        do {
            System.out.print("Nhập điểm trung bình: ");
            avgMark = scanner.nextDouble();
            if (avgMark < 0 || avgMark > 10) {
                System.err.println("Điểm trung bình không hợp lệ. Vui lòng kiểm tra lại.");
                continue;
            }
            return avgMark;
        } while (true);
    }


    public String getExistCode() {
        Scanner scanner = new Scanner(System.in);
        String code;
        do {
            System.out.println("Nhập mã sinh viên: ");
            code = scanner.nextLine();
            if (checkExistCode(code, null)) {
                System.out.println("Mã sinh viên đã tồn tại. Vui lòng nhập lại.");
            } else {
                break;
            }
        } while (true);
        return code;
    }
    public String getValidCode(List<Student> listStudents) {
        Scanner scanner = new Scanner(System.in);
        String code;
        do {
            System.out.println("Nhập mã sinh viên: ");
            code = scanner.nextLine();
            if (checkExistCode(code, listStudents)) {
                System.out.println("Mã sinh viên đã tồn tại. Vui lòng nhập lại.");
            } else {
                break;
            }
        } while (true);
        return code;
    }

    public static int getValidIntChoice(int minChoice, int maxChoice) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.printf("Nhập lựa chọn từ %d đến %d: ", minChoice, maxChoice);

            if (!scanner.hasNextInt()) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            if (choice < minChoice || choice > maxChoice) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại");
                continue;
            }

            break;
        } while (true);
        scanner.nextLine();

        return choice;
    }
}
