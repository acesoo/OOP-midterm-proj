package studentReport;

import java.io.*;
import java.util.*;

public class StudentReport {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        try {
            // Process Student Info
            Scanner studFile = new Scanner(new File("D:\\bralp\\Documents\\StudInfo.csv"));
            while (studFile.hasNextLine()) {
                String line = studFile.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length < 4) continue;

                Student student = new Student(data[0].trim(), data[1].trim(), data[2].trim(), new Degree(data[3].trim()));
                students.add(student);
            }
            studFile.close();

            // Process Addresses
            processAddress(students);

            // Process Parents
            processParent(students);

            // Print Report
            for (Student s : students) {
                s.printReport();
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        }
    }

    public static void processAddress(List<Student> students) {
        try {
            Scanner addressFile = new Scanner(new File("D:\\bralp\\Documents\\AddressInfo.csv"));
            while (addressFile.hasNextLine()) {
                String line = addressFile.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length < 3) continue;

                for (Student s : students) {
                    if (s.getId().equals(data[0].trim())) {
                        s.addAddress(new Address(data[1].trim(), data[2].trim()));
                    }
                }
            }
            addressFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: AddressInfo.csv not found!");
        }
    }

    public static void processParent(List<Student> students) {
        try {
            Scanner parentFile = new Scanner(new File("D:\\bralp\\Documents\\ParentInfo.csv"));
            while (parentFile.hasNextLine()) {
                String line = parentFile.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length < 3) continue;

                for (Student s : students) {
                    if (s.getId().equals(data[0].trim())) {
                        s.addParent(new Parent(data[1].trim(), data[2].trim()));
                    }
                }
            }
            parentFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: ParentInfo.csv not found!");
        }
    }
}
