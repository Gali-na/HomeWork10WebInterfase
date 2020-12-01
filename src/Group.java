import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Group implements MilitaryСommissar {
    private List<Student> group;

    public Group(ArrayList<Student> group) {
        this.group = group;
    }

    public Group() {
        this.group = new ArrayList<>();
    }

    public List<Student> getGroup() {
        return group;
    }

    public void setGroup(ArrayList<Student> group) {
        this.group = group;
    }

    public void addStudent(Student student) throws MyException {
        if (this.group.size() == 10) {
            throw new MyException("Exceeded the maximum number of students");
        }
        this.group.add(student);
    }

    public void removeStudent(Student student) {
        for (int i = 0; i < this.group.size(); i++) {
            if (this.group.get(i).getAcademicPerformance() == (student.getAcademicPerformance())
                    && this.group.get(i).getAge() == student.getAge()
                    && this.group.get(i).getName().equalsIgnoreCase(student.getName())
                    && this.group.get(i).getSurname().equalsIgnoreCase(student.getSurname())
                    && this.group.get(i).getScholarship() == student.getScholarship()) {
                this.group.remove(i);
                return;
            }
        }
    }

    public ArrayList<Student> searchStudent(String surname) {
        ArrayList<Student> students = new ArrayList<>();
        Student[] foundStudent = new Student[1];
        for (int i = 0; i < this.group.size(); i++) {
            if (this.group.get(i) != null) {
                if (this.group.get(i).getSurname().equalsIgnoreCase(surname)) {
                    students.add(this.group.get(i));

                }
            }
        }
        return students;
    }

    @Override
    public String toString() {
        Comparator<Student> comparato = new StudentSurnameComparator().thenComparing(new StudentNameComparator());
        this.group.sort(comparato);
        String rezult = "";

        for (int i = 0; i < this.group.size(); i++) {

            if (this.group.get(i) == null) {
                continue;
            } else {
                rezult = rezult + this.group.get(i).toString() + "\n";
            }
        }
        return rezult;
    }

    @Override
    public ArrayList<Student> potentialSoldiers() {
        ArrayList<Student> studentsForArmy = new ArrayList<>();

        for (int i = 0; i < this.group.size(); i++) {

            if (this.group.get(i) == null) {
                continue;
            }
            if (this.group.get(i).getAge() > 18 && this.group.get(i).getGender().equals("man")) {
                studentsForArmy.add(this.group.get(i));
            }
        }
        return studentsForArmy;
    }
}
