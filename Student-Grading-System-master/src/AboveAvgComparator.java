
import java.util.Comparator;

public class AboveAvgComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getOverallMarks() - o1.getOverallMarks();
    }

}
