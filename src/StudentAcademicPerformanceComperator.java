import java.util.Comparator;

public class StudentAcademicPerformanceComperator implements Comparator<Student> {
    @Override
    public int compare(Student studenOne, Student studenTwo) {
        if (studenOne == null || studenTwo == null) {
            return -1;
        }
        if (studenOne.getAcademicPerformance() < studenTwo.getAcademicPerformance()) {
            return 1;
        }
        if (studenOne.getAcademicPerformance() > studenTwo.getAcademicPerformance()) {
            return -1;
        }
        return 0;
    }
}