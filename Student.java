package studentReport;

import java.util.*;

public class Student {
    private String id;
    private String lastName;
    private String firstName;
    private Degree degree;
    private List<Address> addresses;
    private List<Parent> parents;

    public Student(String id, String lastName, String firstName, Degree degree) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.degree = degree;
        this.addresses = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
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
        System.out.println("Studying " + degree.getName());
        
        for (Address addr : addresses) {
            System.out.println(addr);
        }
        for (Parent par : parents) {
            System.out.println(par);
        }
        System.out.println();
    }
}
