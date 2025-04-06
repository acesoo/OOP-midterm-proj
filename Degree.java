package studentReport;

public class Degree {
    private String code;
    private String name;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
