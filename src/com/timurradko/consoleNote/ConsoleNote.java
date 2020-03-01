package com.timurradko.consoleNote;

import java.io.*;
import java.util.Scanner;

public class ConsoleNote {
    FileWriter filewriter;

    public ConsoleNote(String s) {
        try {
            this.filewriter = new FileWriter(s, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Create your file (set its name and path):");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        File file = new File(s);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.getMessage();
        }

        if (file.exists()) {
            System.out.println("File exist");
        } else {
            System.out.println("File not found");
        }

        ConsoleNote consoleNote = new ConsoleNote(s);
        System.out.println("Write something in creating file:");
        try {
            consoleNote.filewriter.write(scanner.nextLine());
            consoleNote.filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream reader = new FileInputStream(file);
            System.out.println("You was writing:");
            while (reader.available() > 0) {
                char data = (char) reader.read();
                System.out.print(data);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
