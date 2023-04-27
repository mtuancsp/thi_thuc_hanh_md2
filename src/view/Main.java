package view;

import controller.StudentManager;

import java.io.IOException;

import static view.Menu.mainMenu;

public class Main {
    public static void main(String[] args) throws IOException {
        StudentManager studentManager = new StudentManager();
        mainMenu(studentManager);
    }
}
