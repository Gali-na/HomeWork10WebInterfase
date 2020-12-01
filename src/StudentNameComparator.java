import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student studenOne, Student studenTwo) {
        if (studenOne == null || studenTwo == null) {
            return -1;
        }
        return studenOne.getName().compareTo(studenTwo.getName());
    }
}
