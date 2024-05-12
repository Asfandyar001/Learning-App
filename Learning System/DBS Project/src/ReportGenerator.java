import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReportGenerator {
    public static void generateQuizReportForStudent(int studentId) {
        // Establish connection to the database
        DB c = new DB();
        String url = c.geturl();
        try (Connection conn = DriverManager.getConnection(url)) {
            
            String query= "Select QuizId, StudentMarks, TotalMarks from QuizResult where StudentId = "+ studentId;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Print quiz report header
            System.out.println("Quiz Report for Student ID: " + studentId);
            System.out.println("---------------------------------------------");

            // Iterate over the quiz results
            while (rs.next()) {
                int quizId = rs.getInt("QuizId");
                int TotalQuestions = rs.getInt("TotalMarks");
                int studentAnswer = rs.getInt("StudentMarks");

                
                // Print quiz details
                System.out.println("Quiz ID: " + quizId);
                System.out.println("Total Questions: " + TotalQuestions);
                System.out.println("Student Marks: " + studentAnswer);
                System.out.println("Result: " + studentAnswer + "/" + TotalQuestions);
                System.out.println("---------------------------------------------");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
