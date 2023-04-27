package read_write;

import model.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentCSV {
    private static final String CSV_FILE = "src/data/students.csv";

    public static void main(String[] args) throws IOException {
        //test
        List<Student> listStudents = new ArrayList<>();
        listStudents.add(new Student("001", "a", 20, "Nam", "ac", 3.5));
        listStudents.add(new Student("002", "b", 21, "Nữ", "67", 4.0));
        listStudents.add(new Student("003", "c", 19, "Nam", "bn", 5.0));
        listStudents.add(new Student("004", "d", 20, "Nam", "ac", 5.5));
        listStudents.add(new Student("005", "e", 21, "Nữ", "67", 6.0));
        listStudents.add(new Student("006", "f", 19, "Nam", "bn", 3.0));
        listStudents.add(new Student("007", "g", 20, "Nam", "ac", 6.5));
        listStudents.add(new Student("008", "h", 21, "Nữ", "67", 4.0));
        listStudents.add(new Student("009", "i", 20, "Nam", "ac", 7.5));
        listStudents.add(new Student("010", "j", 21, "Nữ", "67", 8.0));
        listStudents.add(new Student("011", "k", 20, "Nam", "ac", 9.5));
        listStudents.add(new Student("012", "l", 21, "Nữ", "67", 8.0));
        listStudents.add(new Student("013", "m", 20, "Nam", "ac", 3.5));
        listStudents.add(new Student("014", "n", 21, "Nữ", "67", 5.0));
        listStudents.add(new Student("015", "o", 20, "Nam", "ac", 8.5));
        listStudents.add(new Student("016", "p", 21, "Nữ", "67", 10.0));

        writeCSV(listStudents);

        List<Student> studentsFromCSV = readCSV();
        System.out.println(studentsFromCSV);
    }

    public static void writeCSV(List<Student> listStudents) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE));

        // viết dòng tiêu đề
        writer.write("Code,Name,Age,Gender,Address,AvgMark");
        writer.newLine();

        for (Student student : listStudents) {
            writer.write(student.getCode() + "," + student.getName() + "," + student.getAge() + ","
                    + student.getGender() + "," + student.getAddress() + "," + student.getAvgMark());
            writer.newLine();
        }

        writer.close();
    }

    public static List<Student> readCSV() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE));

        List<Student> listStudents = new ArrayList<>();

        // bỏ qua dòng tiêu đề
        reader.readLine();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            String code = fields[0];
            String name = fields[1];
            int age = Integer.parseInt(fields[2]);
            String gender = fields[3];
            String address = fields[4];
            double avgMark = Double.parseDouble(fields[5]);

            listStudents.add(new Student(code, name, age, gender, address, avgMark));
        }

        reader.close();
        return listStudents;
    }
}
