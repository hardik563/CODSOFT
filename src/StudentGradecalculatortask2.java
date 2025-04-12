import java.util.Scanner;

public class StudentGradecalculatortask2 {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects= ");
        int totalsubjects= sc.nextInt();
        int totalmarksobtained = 0;
        for (int i = 1; i <= totalsubjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            int marks = sc.nextInt();
            totalmarksobtained = totalmarksobtained + marks;
        }

        float average = (float) totalmarksobtained / totalsubjects;

        String gradeobtained;

        if (average >= 90) {

            gradeobtained = "A";

        } else if (average >= 80 ) {

            gradeobtained = "B";

        } else if (average >= 70 ) {

            gradeobtained = "C";

        } else if (average >= 60 ) {

            gradeobtained = "D";

        } else {

            gradeobtained = "F";

        }
        System.out.println(" Total Marks = " + totalmarksobtained);
        System.out.println(" Percentage = " + average);
        System.out.println(" Grade Obtained = " + gradeobtained);
        System.out.print("\n");
        System.out.println("CONGRATULATION FOR YOUR RESULT ");
    }
}
