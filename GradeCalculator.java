import java.util.Scanner;

public class GradeCalculator {
    private String name;
    private int numSubjects;
    private int totalMarks;

    // Constructor 
    public GradeCalculator(String name, int numSubjects) {
        this.name = name;
        this.numSubjects = numSubjects;
        this.totalMarks = 0;
    }

    // take input marks for each subject
    public void getMarks(Scanner scanner) {
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }
    }

    // calculate the average percentage and grade
    public void calculateAndDisplayGrade() {
        double avgPercentage = (double) totalMarks / numSubjects;
        char grade;

        if (avgPercentage >= 90) {
            grade = 'A';
        } else if (avgPercentage >= 80) {
            grade = 'B';
        } else if (avgPercentage >= 70) {
            grade = 'C';
        } else if (avgPercentage >= 60) {
            grade = 'D';
        } else if (avgPercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // Displaying Results
        System.out.println("------------------------------------------------------------");
        System.out.println("Student name: " + name);
        System.out.println("Total Marks: " + totalMarks+"/"+ numSubjects*100);
        System.out.println("Average Percentage: " + avgPercentage + "%");
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         System.out.print("Enter name of Student : ");
            String name = scanner.nextLine();
            System.out.print("Enter the number of subjects for " + name + ": ");
            int numSubjects = scanner.nextInt();

            GradeCalculator user = new GradeCalculator(name, numSubjects);
            user.getMarks(scanner);
            user.calculateAndDisplayGrade();
    }}