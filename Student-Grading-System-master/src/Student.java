
public class Student implements Comparable<Student> {

    // Declaring the variables
    private String regNo;
    private String frName;
    private String lsName;
    private int Test1Marks;
    private int Test2Marks;
    private int GroupCWK01Marks;
    private int GroupCWK02Marks;

    private int qSetMarks;
    private int overallMarks;
    private Grade grade;

    public Student(String regNo, String firstName, String lastName, int ict01Marks, int ict02Marks, int groupCWK01Marks,
                   int groupCWK02Marks) {


        this.regNo = regNo;
        this.frName = firstName;
        this.lsName = lastName;
        this.Test1Marks = validateMarks(ict01Marks);
        this.Test2Marks = validateMarks(ict02Marks);
        this.GroupCWK01Marks = validateMarks(groupCWK01Marks);
        this.GroupCWK02Marks = validateMarks(groupCWK02Marks);
        calculateQSet();
        calculateOverall();
        calculateGrade();
    }

    public String getRegNo() {
        return regNo;
    }

    public String getfName() {
        return frName;
    }

    public String getlName() {
        return lsName;
    }

    public int getIct01Marks() {
        return Test1Marks;
    }

    public int getIct02Marks() {
        return Test2Marks;
    }

    public int getGroupCWK01Marks() {
        return GroupCWK01Marks;
    }

    public int getGroupCWK02Marks() {
        return GroupCWK02Marks;
    }

    public int getQSetMarks() {
        return qSetMarks;
    }

    public int getOverallMarks() {
        return overallMarks;
    }

    private void calculateQSet() {
        qSetMarks = Math.round((Test1Marks + Test2Marks) / 2);
    }

    private void calculateOverall() {
        overallMarks = (int) Math
                .round(Test1Marks * .2 + Test2Marks * .2 + GroupCWK01Marks * .3 + GroupCWK02Marks * 0.3);
    }

    private int validateMarks(int marks) {
        if (!(marks >= 0 && marks <= 100)) {
            throw new IllegalArgumentException("Marks are to be more than or equals 0 and less than or equal to 100");
        }
        return marks;
    }

    private void calculateGrade() {

        if (this.overallMarks >= 40 && this.qSetMarks >= 30 && this.GroupCWK01Marks >= 30
                && this.GroupCWK02Marks >= 30) {

            if (this.overallMarks >= 70) {
                this.grade = Grade.FIRST_CLASS;
            } else if (this.overallMarks >= 60) {
                this.grade = Grade.SECOND_UPPER_CLASS;
            } else if (this.overallMarks >= 50) {
                this.grade = Grade.SECOND_LOWER_CLASS;
            } else if (this.overallMarks >= 40) {
                this.grade = Grade.GENERAL_PASS;
            } else {
                this.grade = Grade.FAIL;
            }
        } else if (this.overallMarks >= 30) {
            this.grade = Grade.RESIT;
        } else {
            this.grade = Grade.RETAKE;
        }
    }

    public Grade getGrade() {
        return this.grade;
    }

    @Override
    public String toString() {
        return "[FirstName= " + frName + ", LastName= " + lsName + ", RegistrationNo= " + regNo + ", overallMarks= "
                + overallMarks + ", ICT01Marks= " + Test1Marks + ", ICT02Marks= " + Test2Marks + ", GroupCWK01Marks= "
                + GroupCWK01Marks + ", GroupCWK02Marks= " + GroupCWK02Marks + ", grade= " + grade + "]";
    }

    // sorting the Student list in the order of ascending of last name
    @Override
    public int compareTo(Student o) {
        return this.getlName().compareTo(o.getlName());
    }
}
