package collection.model;

public class StudentWithoutHashcode {
    private int studentID;
    private String firstName;
    private String lastName;
    public StudentWithoutHashcode(int id, String fname, String lname) {
        studentID = id;
        firstName = fname;
        lastName = lname;

    }
    public int getStudentID() {
        return studentID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public boolean equals(Object o) {
        boolean isEqual = false;
        if ((o != null) && (o instanceof StudentWithoutHashcode)) {
            StudentWithoutHashcode target = (StudentWithoutHashcode)o;
            isEqual = (target.getStudentID() == this.getStudentID());
        }
        return isEqual;
    }
}