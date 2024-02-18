import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {

    private static Scanner sc = new Scanner(System.in);
    private static List<Student> studentList = new ArrayList<Student>();

    public static void main(String[] args) {

        boolean stop = false;

        // Collect the required details from the user
        do {
            menu();

            int input = intValidation(sc, "Enter function number");

            switch (input) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    if (!studentList.isEmpty()) {
                        average();
                    } else {
                        System.out.println("There are no students in the list\n");
                    }
                    break;

                case 3:
                    if (!studentList.isEmpty()) {
                        below30();
                    } else {
                        System.out.println("There are no students in the list\n");
                    }
                    break;

                case 4:
                    if (!studentList.isEmpty()) {
                        belowClassAverage();
                    } else {
                        System.out.println("There are no students in the list\n");
                    }
                    break;

                case 5:
                    if (!studentList.isEmpty()) {
                        aboveClassAverage();
                    } else {
                        System.out.println("There are no students in the list\n");
                    }
                    break;

                case 6:
                    if (!studentList.isEmpty()) {
                        highestScorer();
                    } else {
                        System.out.println("There are no students in the list\n");
                    }
                    break;

                case 7:
                    if (!studentList.isEmpty()) {
                        lowestScorer();
                    } else {
                        System.out.println("There are no students in the list\n");
                    }
                    break;

                case 8:
                    if (!studentList.isEmpty()) {
                        retakeList();
                    } else {
                        System.out.println("There are no students in the list\n");
                    }
                    break;

                case 9:
                    if (!studentList.isEmpty()) {
                        resitList();
                    } else {
                        System.out.println("There are no students in the list\n");
                    }
                    break;

                case 10:
                    if (!studentList.isEmpty()) {
                        allDetails();
                    } else {
                        System.out.println("There are no students in the list\n");
                    }
                    break;

                case 11:
                    Histogram.display(studentList);
                    break;

                case 0:
                    stop = true;
                    break;

                default:
                    System.err.println("That is not an option");
            }

        } while (stop != true);
    }

    // Menu Displayed
    private static void menu() {

        System.out.println("(1) Add Student");
        System.out.println("(2) Display class average for each component");
        System.out.println("(3) Display number of students below 30 for each component");
        System.out.println("(4) Display students with module mark below class average");
        System.out.println("(5) Display students with module mark above class average - descending order of mark");
        System.out.println("(6) Display highest scorer for each component");
        System.out.println("(7) Display lowest scorer of overall module");
        System.out.println("(8) Display the list of re-take students");
        System.out.println("(9) Display the list of re-sit students for each component - ascending order of last name");
        System.out.println("(10) Display overall marks of all students");
        System.out.println("(11) Display overall marks in a histogram");
        System.out.println("(0) Quit\n");

    }

    // Adding students to the array list by validating the mark inputs
    private static void addStudent() {

        System.out.println("Enter the registration number");
        String regNo = sc.next();
        System.out.println("Enter the first name");
        String fName = sc.next();
        System.out.println("Enter the last name");
        String lName = sc.next();

        int ict01Marks = validateMarks(sc, "Enter ICT 01 Marks");
        int ict02Marks = validateMarks(sc, "Enter ICT 02 Marks");
        int groupCWK01Marks = validateMarks(sc, "Enter Group CWK 01 Marks");
        int groupCWK02Marks = validateMarks(sc, "Enter Group CWK 02 Marks");

        studentList.add(new Student(regNo, fName, lName, ict01Marks, ict02Marks, groupCWK01Marks, groupCWK02Marks));

    }

    // Calculating the average of components
    private static void average() {
        double ict01Average;
        double ict02Average;
        double cwk01Average;
        double cwk02Average;

        int total = 0;
        System.out.println("**********Averages of Components**********");
        for (Student obj : studentList) {
            total += obj.getIct01Marks();
        }
        ict01Average = total / studentList.size();
        System.out.println("Class average of ict 01: " + ict01Average);

        total = 0;
        for (Student obj : studentList) {
            total += obj.getIct02Marks();
        }
        ict02Average = total / studentList.size();
        System.out.println("Class average of ict 02: " + ict02Average);

        total = 0;
        for (Student obj : studentList) {
            total += obj.getGroupCWK01Marks();
        }
        cwk01Average = total / studentList.size();
        System.out.println("Class average of Group CWK 01: " + cwk01Average);

        total = 0;
        for (Student obj : studentList) {
            total += obj.getGroupCWK02Marks();
        }
        cwk02Average = total / studentList.size();
        System.out.println("Class average of Group CWK 02: " + cwk02Average);
        System.out.println();
    }

    // Students who got below 30 for each component
    private static void below30() {

        int numICT01 = 0;
        int numICT02 = 0;
        int numCWK01 = 0;
        int numCWK02 = 0;

        for (Student obj : studentList) {

            if (obj.getIct01Marks() < 30)
                numICT01++;

            if (obj.getIct02Marks() < 30)
                numICT02++;

            if (obj.getGroupCWK01Marks() < 30)
                numCWK01++;

            if (obj.getGroupCWK02Marks() < 30)
                numCWK02++;

        }
        System.out.println("**********Number of Students below 30 for components**********\n");
        System.out.println("Number of student below 30 for ICT 01 : " + numICT01);
        System.out.println("Number of student below 30 for ICT 02 : " + numICT02);
        System.out.println("Number of student below 30 for Group CWK 01 : " + numCWK01);
        System.out.println("Number of student below 30 for Group CWK 02 : " + numCWK02 + "\n");
    }

    // Calculate the module mark average of class
    private static int classAverage() {

        int classAverage;
        int total = 0;

        for (Student obj : studentList) {
            total += obj.getOverallMarks();
        }
        classAverage = (int) Math.round(total / studentList.size());

        return classAverage;
    }

    // Students who have scored below class average
    private static void belowClassAverage() {
        System.out.println("**********Students below Class Average**********\n");

        int classAverage = classAverage();
        System.out.println("Class Average: " + classAverage);

        for (Student obj : studentList) {
            if (obj.getOverallMarks() < classAverage) {
                System.out.println(obj);
            }
        }
        System.out.println();
    }

    // Students who have scored above class average in descending order of marks
    private static void aboveClassAverage() {
        System.out.println("**********Students above Class Average**********\n");

        int classAverage = classAverage();
        System.out.println("Class Average: " + classAverage);

        List<Student> tempList = new ArrayList<Student>();

        for (Student obj : studentList) {
            if (obj.getOverallMarks() >= classAverage) {
                tempList.add(obj);
            }
        }

        Collections.sort(tempList, new AboveAvgComparator());
        for (Student o : tempList) {
            System.out.println(o);
        }
    }

    // Finding the highest scorer of all components and overall mark
    private static void highestScorer() {
        System.out.println("**********Highest Scorers**********\n");
        int max = 0;
        Student obj = null;

        for (Student o : studentList) {
            if (o.getIct01Marks() >= max) {
                max = o.getIct01Marks();
                obj = o;
            }
        }
        System.out.println("Highest scorer for ICT 01");
        System.out.println(obj + "\n");

        max = 0;
        for (Student o : studentList) {
            if (o.getIct02Marks() >= max) {
                max = o.getIct02Marks();
                obj = o;
            }
        }
        System.out.println("Highest scorer for ICT 02");
        System.out.println(obj + "\n");

        max = 0;
        for (Student o : studentList) {
            if (o.getGroupCWK01Marks() >= max) {
                max = o.getGroupCWK01Marks();
                obj = o;
            }
        }
        System.out.println("Highest scorer for Group CWK 01");
        System.out.println(obj + "\n");

        max = 0;
        for (Student o : studentList) {
            if (o.getGroupCWK02Marks() >= max) {
                max = o.getGroupCWK02Marks();
                obj = o;
            }
        }
        System.out.println("Highest scorer for Group CWK 02");
        System.out.println(obj + "\n");

        max = 0;
        for (Student o : studentList) {
            if (o.getOverallMarks() >= max) {
                max = o.getOverallMarks();
                obj = o;
            }
        }
        System.out.println("Highest scorer for the overall module");
        System.out.println(obj + "\n");
    }

    // finding the Lowest scorer in overall mark
    private static void lowestScorer() {
        System.out.println("**********Lowest Scorer (Overall Marks)**********\n");
        int min = 100;
        Student obj = null;

        for (Student o : studentList) {
            if (o.getOverallMarks() <= min) {
                obj = o;
            }
        }

        System.out.println(obj);
    }

    // Students who have to retake
    private static void retakeList() {
        System.out.println("**********Retake Students**********\n");

        for (Student obj : studentList) {
            if (obj.getGrade() == Grade.RETAKE) {
                System.out.println(obj);
            }
        }
        System.out.println();
    }

    // Students who have to resit in the ascending order of their last name
    private static void resitList() {
        System.out.println("**********Resit Students**********\n");
        List<Student> tempList = new ArrayList<Student>();

        for (Student obj : studentList) {
            if (obj.getGrade() == Grade.RESIT) {
                tempList.add(obj);
            }
        }
        Collections.sort(tempList);

        for (Student obj : tempList) {
            System.out.println(obj);
        }

        System.out.println();
    }

    // Printing all details
    private static void allDetails() {
        System.out.println("**********All Details**********\n");

        for (Student obj : studentList) {
            System.out.println(obj);
        }
    }

    // validating whether the user has input an integer
    private static int intValidation(Scanner sc, String label) {
        int marks;

        System.out.println(label);
        while (!sc.hasNextInt()) {
            System.err.println("Invalid Input type!");
            sc.next();
        }
        marks = sc.nextInt();

        return marks;
    }

    // validate a correct input of marks
    private static int validateMarks(Scanner sc, String label) {
        int marks;
        do {
            System.out.println(label);
            while (!sc.hasNextInt()) {
                System.err.println("Invalid Input.! Please enter a mark integer from 0 to 100");
                sc.next();
            }
            marks = sc.nextInt();
            if (!(marks >= 0 && marks <= 100)) {
                System.err.println("Invalid marks.! Input marks within the range of 0 to 100");
            }
        } while (!(marks >= 0 && marks <= 100));

        return marks;
    }
}
