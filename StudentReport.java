package studentReport;

import java.io.*;
import java.util.*;

class Address {
    String type;
    String location;

    public Address(String type, String location) {
        this.type = type.equals("C") ? "City address" : "Provincial address";
        this.location = location;
    }

    @Override
    public String toString() {
        return type + " is " + location;
    }
}

class Parent {
    String type;
    String name;

    public Parent(String type, String name) {
        if (type.equals("F")) this.type = "Father's name";
        else if (type.equals("M")) this.type = "Mother's name";
        else this.type = "Guardian's name";
        this.name = name;
    }

    @Override
    public String toString() {
        return type + " is " + name;
    }
}

class Degree {
    String code, name;

    public Degree(String code) {
        this.code = code;
        switch (code) {
            case "BSCS":
                this.name = "BS Computer Science";
                break;
            case "BSIE":
                this.name = "BS Industrial Engineering";
                break;
            case "BSECE":
                this.name = "BS Electronics Engineering";
                break;
            default:
                this.name = "Unknown Degree";
        }
    }
}

class Student {
    String id, lastName, firstName;
    Degree degree;
    List<Address> addresses;
    List<Parent> parents;

    public Student(String id, String lastName, String firstName, Degree degree) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.degree = degree;
        this.addresses = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public void addParent(Parent parent) {
        parents.add(parent);
    }

    public void printReport() {
        System.out.println("Student id is " + id);
        System.out.println("Student name is " + lastName.toUpperCase() + ", " + firstName);
        System.out.println("Studying " + degree.name);
        
        for (Address addr : addresses) {
            System.out.println(addr);
        }
        for (Parent par : parents) {
            System.out.println(par);
        }
        System.out.println();
    }
}

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
                    if (s.id.equals(data[0].trim())) {
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
                    if (s.id.equals(data[0].trim())) {
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

