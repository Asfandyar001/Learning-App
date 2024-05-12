import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.*;

public class MCQQuiz extends JFrame {

    private JLabel questionLabel;
    private JRadioButton option1Button, option2Button, option3Button, option4Button;
    private ButtonGroup buttonGroup;
    private JButton nextButton;

    

    ArrayList<String> questions;
    ArrayList<String> opt_1;
    ArrayList<String> opt_2;
    ArrayList<String> opt_3;
    ArrayList<String> opt_4;

    ArrayList<String> answers;
    ArrayList<String> selectedAnswers;

    private int currentQuestionIndex = 0;

    public MCQQuiz(int s_Id,int q_Id,int l_id,int cr, int cg, int cb) {
        questions = new ArrayList<>();
        opt_1 = new ArrayList<>();
        opt_2 = new ArrayList<>();
        opt_3 = new ArrayList<>();
        opt_4 = new ArrayList<>();
        answers = new ArrayList<>();
        selectedAnswers = new ArrayList<>();

        DB c = new DB();
        String url = c.geturl();
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Quiz where [Lesson ID] = " + l_id);

            int i = 1;
            while (rs.next()) {
                questions.add("Q" + i + ": " + rs.getString(3));
                opt_1.add(rs.getString(4));
                opt_2.add(rs.getString(5));
                opt_3.add(rs.getString(6));
                opt_4.add(rs.getString(7));
                answers.add(rs.getString(8));
                i++;
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException f) {
            f.printStackTrace();
        }

        setTitle("Learning System Quiz");
        setSize(600, 400); // Set frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(0,0,0)); // Set background color

        
        Color labelColor = new Color(255, 255, 255);
        questionLabel = new JLabel("<html><div style='text-align: left; margin-left: 10px; margin-top: 10px; margin-bottom: 10px; color: rgb(" + labelColor.getRed() + "," + labelColor.getGreen() + "," + labelColor.getBlue() + ")'>" + questions.get(currentQuestionIndex) + "</div></html>");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        add(questionLabel, BorderLayout.NORTH);


        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        // Inside the constructor
        option1Button = new JRadioButton("<html><div style='text-align: left; margin-left: 10px;'>" + opt_1.get(currentQuestionIndex) + "</div></html>");
        option2Button = new JRadioButton("<html><div style='text-align: left; margin-left: 10px;'>" + opt_2.get(currentQuestionIndex) + "</div></html>");
        option3Button = new JRadioButton("<html><div style='text-align: left; margin-left: 10px;'>" + opt_3.get(currentQuestionIndex) + "</div></html>");
        option4Button = new JRadioButton("<html><div style='text-align: left; margin-left: 10px;'>" + opt_4.get(currentQuestionIndex) + "</div></html>");
        
        // Set font and size for radio buttons
        Font radioButtonFont = new Font("Arial", Font.BOLD, 20);
        option1Button.setFont(radioButtonFont);
        option2Button.setFont(radioButtonFont);
        option3Button.setFont(radioButtonFont);
        option4Button.setFont(radioButtonFont);

        // Set foreground color for radio buttons (text color)
        Color radioButtonColor = new Color(0, 0, 0);
        option1Button.setForeground(radioButtonColor);
        option2Button.setForeground(radioButtonColor);
        option3Button.setForeground(radioButtonColor);
        option4Button.setForeground(radioButtonColor);
        
        // (Whole Background Color)
        Color radioButtonBackgroundColor = new Color(cr, cg, cb);
        option1Button.setBackground(radioButtonBackgroundColor);
        option2Button.setBackground(radioButtonBackgroundColor);
        option3Button.setBackground(radioButtonBackgroundColor);
        option4Button.setBackground(radioButtonBackgroundColor);
        
        // Customize radio button appearance
        option1Button.setFocusPainted(false); // Remove focus border
        option2Button.setFocusPainted(false);
        option3Button.setFocusPainted(false);
        option4Button.setFocusPainted(false);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(option1Button);
        buttonGroup.add(option2Button);
        buttonGroup.add(option3Button);
        buttonGroup.add(option4Button);

        optionsPanel.add(option1Button);
        optionsPanel.add(option2Button);
        optionsPanel.add(option3Button);
        optionsPanel.add(option4Button);

        add(optionsPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        nextButton.setBackground(new Color(50, 150, 250)); // Set button background color
        nextButton.setForeground(Color.WHITE); // Set button text color
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.size()) {
                    updateQuestion();
                } else {
                    showResult(s_Id,q_Id);
                }
            }
        });

        add(nextButton, BorderLayout.SOUTH);
        setUndecorated(true);
        setVisible(true);
    }

    private void checkAnswer() {
        String selectedOption = "";
        if (option1Button.isSelected()) {
            selectedOption = opt_1.get(currentQuestionIndex);
        } else if (option2Button.isSelected()) {
            selectedOption = opt_2.get(currentQuestionIndex);
        } else if (option3Button.isSelected()) {
            selectedOption = opt_3.get(currentQuestionIndex);
        } else if (option4Button.isSelected()) {
            selectedOption = opt_4.get(currentQuestionIndex);
        }
        selectedAnswers.add(selectedOption);

        if (selectedOption.equals(answers.get(currentQuestionIndex))) {
            JOptionPane.showMessageDialog(this, "Correct!", "Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect!", "Result", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateQuestion() {
        Color labelColor = new Color(255, 255, 255);
        questionLabel.setText("<html><div style='text-align: left; margin-left: 10px; margin-top: 10px; margin-bottom: 10px; color: rgb(" + labelColor.getRed() + "," + labelColor.getGreen() + "," + labelColor.getBlue() + ")'>" + questions.get(currentQuestionIndex) + "</div></html>");
        option1Button.setText(opt_1.get(currentQuestionIndex));
        option2Button.setText(opt_2.get(currentQuestionIndex));
        option3Button.setText(opt_3.get(currentQuestionIndex));
        option4Button.setText(opt_4.get(currentQuestionIndex));
        buttonGroup.clearSelection();
    }

    PreparedStatement pstmt=null;
    DB c = new DB();
     String url = c.geturl();
    

    private void showResult(int s_Id,int q_Id) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (selectedAnswers.get(i).equals(answers.get(i))) {
                score++;
            }
        }

        JOptionPane.showMessageDialog(this, "Quiz Completed!\nYour Score: " + score + "/" + questions.size(),
                "Result", JOptionPane.INFORMATION_MESSAGE);

        this.dispose();

        Main.Congrats(s_Id);


        
        try(Connection conn = DriverManager.getConnection(url);) {
            
        
        String sql="Insert into QuizResult(StudentId,QuizId,StudentMarks,TotalMarks) values(?,?,?,?) ";

        pstmt=conn.prepareStatement(sql);
        //q_Id ++;
         pstmt.setInt(1,s_Id);
         pstmt.setInt(2, q_Id);
         pstmt.setInt(3, score);
         pstmt.setInt(4,questions.size());
         

         int rowsAffected = pstmt.executeUpdate();
            
            // Check if data was inserted successfully
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }
        }catch (SQLException e) {
            e.printStackTrace();
    //     }finally {
    //         // Close resources
    //         try {
    //             if (pstmt != null) pstmt.close();
    //             if (conn != null) conn.close();
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    // }

    

}
    }
}

