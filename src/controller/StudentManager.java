package controller;

import get_input.Input;
import model.Student;
import read_write.StudentCSV;
import view.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static get_input.Input.getValidIntChoice;
import static view.Menu.mainMenu;
import static view.Menu.returnOrExit;

public class StudentManager {
    private List<Student> listStudents = new ArrayList<>();

    private Input input = new Input();

    public StudentManager() {
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }

    //display all students
    public void displayStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("Danh sách sinh viên");
        int index = 0;
        while (index < listStudents.size()) {
            for (int i = index; i < Math.min(index + 5, listStudents.size()); i++) {
                System.out.println(listStudents.get(i));
            }
            index += 5;
            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Nhập 'next' để tiếp tục hiển thị danh sách sinh viên\n'q' để thoát\n'add' để thêm mới");
            String input = scanner.nextLine();
            if (input.equals("next")) {
                continue;
            }
            if (input.equals("q")) {
                return;
            }
            if (input.equals("add")) {
                addStudent();
            }
        }
    }


    //add a new student
    public void addStudent() {
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("Thêm sinh viên");

        String code = input.getValidCode(listStudents);
        String name = input.getValidFullName();
        int age = input.getValidAge();
        String gender = input.getValidGender();
        String address = input.getValidAddress();
        double avgMark = input.getValidAvgMark();


        Student student = new Student(code, name, age, gender, address, avgMark);
        listStudents.add(student);
    }

    //update a student
    public void updateStudent() {
        do {
            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Cập nhật sinh viên");

            Scanner scanner = new Scanner(System.in);

            String code = getExistCode();

            String name = input.getValidFullName();
            int age = input.getValidAge();
            String gender = input.getValidGender();
            String address = input.getValidAddress();
            double avgMark = input.getValidAvgMark();

            for (Student Student : listStudents) {
                if (Student.getCode().equals(code)) {
                    Student.setName(name);
                    Student.setAge(age);
                    Student.setGender(gender);
                    Student.setAddress(address);
                    Student.setAvgMark(avgMark);
                    break;
                }
            }

            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Cập nhật sinh viên thành công");
            System.out.println("Bạn có muốn tiếp tục không: YES/NO");
            String input = scanner.nextLine();
            if (input.equals("YES")) {
                continue;
            }
            if (input.equals("NO")) {
                break;
            }
        } while (true);

        Menu.returnOrExit();
    }

    public String getExistCode(){
        do {
            System.out.println("Nhập mã sinh viên");
            Scanner scanner = new Scanner(System.in);
            String code = scanner.nextLine();
            for (Student Student : listStudents) {
                if (Student.getCode().equals(code)) {
                    return code;
                }
            }
            System.out.println("Mã sinh viên không tồn tại vui lòng kiểm tra lại");
        } while (true);

    }

    //delete a student
    public void deleteStudent() throws IOException {
        do {
            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Xóa sinh viên");

            Scanner scanner = new Scanner(System.in);
            String code = getExistCode();

            for (Student Student : listStudents) {
                if (Student.getCode().equals(code)) {
                    System.out.println("Bạn chắc chắn muốn xóa sinh viên này? Nhập 'Y' để xóa hoặc nhập bất kì để quay lại menu");

                    String input = scanner.nextLine();
                    if (input.equals("Y")) {
                        listStudents.remove(Student);

                    }
                    else mainMenu(this);
                }
            }
            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Xóa sinh viên thành công");
            System.out.println("Bạn có muốn tiếp tục không: YES/NO");
            String input = scanner.nextLine();
            if (input.equals("YES")) {
                continue;
            }
            if (input.equals("NO")) {
                break;
            }
        } while (true);

        Menu.returnOrExit();
    }

    public void sortStudent() {
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("---- Sắp xếp sinh viên theo điểm trung bình ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Sắp xếp điểm trung bình tăng dần");
        System.out.println("2. Sắp xếp điểm trung bình giảm dần");
        System.out.println("3. Thoát");
        System.out.print("Chọn chức năng: ");

        int choice = getValidIntChoice(1,3);
        switch (choice) {
            case 1:
                sortByAscending();
                break;
            case 2:
                sortByAvgMarkDecrease();
                break;
            case 3:
                break;
        }
    }

    private void sortByAscending() {
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("Sắp xếp sinh viên theo điểm trung bình tăng dần");
        listStudents.sort(Comparator.comparing(Student::getAvgMark));
        listStudents.forEach(System.out::println);
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        returnOrExit();
    }

    private void sortByAvgMarkDecrease() {
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("Sắp xếp sinh viên theo điểm trung bình giảm dần".toUpperCase());
        listStudents.sort(Comparator.comparing(Student::getAvgMark).reversed());
        listStudents.forEach(System.out::println);
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        returnOrExit();
    }

    public void readFile() throws IOException {
        listStudents = StudentCSV.readCSV();
        displayStudents();
    }

    public void writeFile() throws IOException {
        System.out.println("Bạn có chắc chắn muốn lưu vào file không YES/NO");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("YES")) {
            StudentCSV.writeCSV(listStudents);
        }
    }
}
