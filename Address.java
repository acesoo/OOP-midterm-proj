package studentReport;

public class Address {
    private String type;
    private String location;

    public Address(String type, String location) {
        this.type = type.equals("C") ? "City address" : "Provincial address";
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return type + " is " + location;
    }
}
