import java.util.*;

public class StudentResults {
    static String studentName;
    static String courseName;
    static int courseMarks;
    static String[] student = { "Jack Smith", "Jim Lucas", "Beck Barber",
            "Ann Walker", "Lucy Boxer" };

    static String[] course = { "Maths", "Business", "Java", "Design", "Project" };

    public static void studentMarks() {
        int[][] marks = { { 89, 70, 56, 87, 65 }, { 70, 65, 70, 83, 78 },
                { 60, 90, 63, 56, 79 }, { 74, 78, 45, 73, 85 },
                { 80, 90, 60, 70, 80 } };

        for (int i = 0; i < student.length; i++) {
            studentName = student[i];
            System.out.printf("\t\t" + studentName + "\t");

        }
        System.out.println("");
        /*for (int j = 0; j < course.length; j++) {
            courseName = course[j];
            System.out.println(courseName + "\t");
        }*/
        for (int m = 0; m < marks.length; m++) {
        	 courseName = course[m];
             System.out.print(courseName + "\t\t");
            for (int n = 0; n < marks.length; n++) {
                courseMarks = marks[m][n];
                System.out.print("\t\t" + courseMarks + "\t\t");
            }
            System.out.println("");
        }

    }

    public static void main(String args[]) {
        studentMarks();

    }
}