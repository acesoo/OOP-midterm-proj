package studentReport;

public class Parent {
    private String type;
    private String name;

    public Parent(String type, String name) {
        if (type.equals("F")) this.type = "Father's name";
        else if (type.equals("M")) this.type = "Mother's name";
        else this.type = "Guardian's name";
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return type + " is " + name;
    }
}
