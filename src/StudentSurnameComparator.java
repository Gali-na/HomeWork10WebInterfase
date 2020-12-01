import java.util.Comparator;

public class StudentSurnameComparator implements Comparator<Student> {
    @Override
    public int compare(Student studenOne, Student studenTwo) {
        if (studenOne == null || studenTwo == null) {
            return -1;
        }
        return studenOne.getSurname().compareTo(studenTwo.getSurname());
    }
}