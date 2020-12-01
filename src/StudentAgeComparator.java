import java.util.Comparator;

public class StudentAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student studenOne, Student studenTwo) {
        if (studenOne == null || studenTwo == null) {
            return -1;
        }
        if (studenOne.getAge() > studenTwo.getAge()) {
            return 1;
        }
        if (studenOne.getAge() < studenTwo.getAge()) {
            return -1;
        }
        return 0;
    }
}