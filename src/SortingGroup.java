import java.util.Comparator;

public class SortingGroup {
    public static Group sortSurname(Group groupForSort) {
        Comparator<Student> comparato = new StudentSurnameComparator();
        groupForSort.getGroup().sort(comparato);
        return groupForSort;
    }

    public static Group sortName(Group groupForSort) {
        Comparator<Student> comparato = new StudentNameComparator();
        groupForSort.getGroup().sort(comparato);
        return groupForSort;
    }

    public static Group sortAge(Group groupForSort) {
        Comparator<Student> comparator = new StudentAgeComparator();
        groupForSort.getGroup().sort(comparator);
        return groupForSort;
    }

    public static Group sortAcademicPerformance(Group groupForSort) {
        Comparator<Student> comparator = new StudentAcademicPerformanceComperator();
        groupForSort.getGroup().sort(comparator);
        return groupForSort;
    }

    public static Group sortScholarship(Group groupForSort) {
        Comparator<Student> comparator = new StudentAcademicPerformanceComperator();
        groupForSort.getGroup().sort(comparator);
        return groupForSort;
    }
}