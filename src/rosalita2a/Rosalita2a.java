package rosalita2a;

import java.util.Scanner;

public class Rosalita2a {
    private config conf = new config();

    public void addEnrollment() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();
        
        System.out.print("Enter Course ID: ");
        int courseId = sc.nextInt();
        
        System.out.print("Enter Enrollment Date (YYYY-MM-DD): ");
        String enrollmentDate = sc.next(); 

        System.out.print("Enter Status: ");
        String status = sc.next();

        System.out.print("Enter Semester: ");
        String semester = sc.next();

        String sql = "INSERT INTO Enrollment (student_id, course_id, enrollment_date, status, semester) VALUES (?, ?, ?, ?, ?)";
        
        conf.addRecord(sql, studentId, courseId, enrollmentDate, status, semester);
    }

    public void viewEnrollments() {
        String enrollmentsQuery = "SELECT * FROM Enrollment";
        String[] enrollmentHeaders = {"Enrollment ID", "Student ID", "Course ID", "Enrollment Date", "Status", "Semester"};
        String[] enrollmentColumns = {"enrollment_id", "student_id", "course_id", "enrollment_date", "status", "semester"};

        conf.viewRecords(enrollmentsQuery, enrollmentHeaders, enrollmentColumns);
    }

    public void updateEnrollment() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Enrollment ID to update: ");
        int enrollmentId = sc.nextInt();

        System.out.print("Enter new Course ID: ");
        int courseId = sc.nextInt();
        
        System.out.print("Enter new Enrollment Date (YYYY-MM-DD): ");
        String enrollmentDate = sc.next(); 

        System.out.print("Enter new Status: ");
        String status = sc.next();

        System.out.print("Enter new Semester: ");
        String semester = sc.next();

        String sql = "UPDATE Enrollment SET course_id = ?, enrollment_date = ?, status = ?, semester = ? WHERE enrollment_id = ?";
        
        conf.updateRecord(sql, courseId, enrollmentDate, status, semester, enrollmentId);
    }

    public void deleteEnrollment() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Enrollment ID to delete: ");
        int enrollmentId = sc.nextInt();

        String sql = "DELETE FROM Enrollment WHERE enrollment_id = ?";
        conf.deleteRecord(sql, enrollmentId);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rosalita2a enrollmentManager = new Rosalita2a();

        while (true) {
            System.out.println("Enrollment Management System");
            System.out.println("1. Add Enrollment");
            System.out.println("2. View Enrollments");
            System.out.println("3. Update Enrollment");
            System.out.println("4. Delete Enrollment");
            System.out.println("5. Exit");
            System.out.print("Select Choice: ");   
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    enrollmentManager.addEnrollment();
                    break;
                case 2:
                    enrollmentManager.viewEnrollments();
                    break;
                case 3:
                    enrollmentManager.updateEnrollment();
                    break;
                case 4:
                    enrollmentManager.deleteEnrollment();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
