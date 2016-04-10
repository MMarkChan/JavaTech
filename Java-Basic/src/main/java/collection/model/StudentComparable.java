package collection.model;

public class StudentComparable implements Comparable<StudentComparable>{
    private int studentID;
    private String firstName;
    private String lastName;
    public StudentComparable(int id, String fname, String lname) {
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
        if ((o != null) && (o instanceof StudentComparable)) {
            StudentComparable target = (StudentComparable)o;
            isEqual = (target.getStudentID() == this.getStudentID());
        }
        return isEqual;
    }


    public StudentComparable() {
        super();
    }

    @Override
    public int compareTo(StudentComparable o) {
        int relativeValue = lastName.compareTo(o.getLastName());
        if (relativeValue == 0) {
            relativeValue = firstName.compareTo(o.getFirstName());
        }
        return relativeValue;
    }
}