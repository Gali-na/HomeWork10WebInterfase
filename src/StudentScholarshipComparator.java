import java.util.Comparator;

public class StudentScholarshipComparator implements Comparator<Student> {
    @Override
    public int compare(Student studenOne, Student studenTwo) {
        if (studenOne == null || studenTwo == null) {
            return -1;
        }
        if (studenOne.getScholarship() < studenTwo.getScholarship()) {
            return 1;
        }
        if (studenOne.getScholarship() > studenTwo.getScholarship()) {
            return -1;
        }
        return 0;
    }
}
