import java.util.Objects;

public class Student extends Person {
    private int academicPerformance;
    private int scholarship;

    public Student(int age, String name, String surname, String gender, int academicPerformance, int scholarship) {
        super(age, name, surname, gender);
        this.academicPerformance = academicPerformance;
        this.scholarship = scholarship;
    }

    public Student() {

    }

    public int getAcademicPerformance() {
        return academicPerformance;
    }

    public void setAcademicPerformance(int academicPerformance) {
        this.academicPerformance = academicPerformance;
    }

    public int getScholarship() {
        return scholarship;
    }

    public void setScholarship(int scholarship) {
        this.scholarship = scholarship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return academicPerformance == student.academicPerformance &&
                scholarship == student.scholarship;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), academicPerformance, scholarship);
    }

    @Override
    public String toString() {
        return super.toString() + " academicPerformance-" + academicPerformance + ";" + " scholarship-" + scholarship;
    }
}

