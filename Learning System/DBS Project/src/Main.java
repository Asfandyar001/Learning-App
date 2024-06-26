import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.PrinterMakeAndModel;
import javax.swing.*;
import java.util.ArrayList;
import java.sql.*;

public class Main {
    public static void main(String[] args)
    {
       MainScreen();
    }
    

    public static void MainScreen()
    {
        JFrame welcome_frame = new JFrame();
        welcome_frame.setSize(1080, 720); // set frame size
        welcome_frame.setTitle("Learning App"); // set frame title
        welcome_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cross close
        welcome_frame.setResizable(false); // disable frame resizing

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the center point
        int centerX = (screenSize.width - welcome_frame.getWidth()) / 2;
        int centerY = (screenSize.height - welcome_frame.getHeight()) / 2;
        // Set the frame's location
        welcome_frame.setLocation(centerX, centerY);


        // Welcome Screen Image
        JLabel label1 = new JLabel();
        ImageIcon Welcome = new ImageIcon("Learning System\\DBS Project\\Images\\Welcome Screen.png");
        label1.setIcon(Welcome);
        // Adjust the size of the sun icon based on label size
        int labelWidth = 1080; // Example width
        int labelHeight = 720; // Example height
        ImageIcon scaledWelcome = new ImageIcon(Welcome.getImage().getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH));
        label1.setIcon(scaledWelcome);
        label1.setBounds(0, 0, labelWidth, labelHeight); // Set bounds for label2


        //Student Button
        JButton StudentButton = new JButton();
        StudentButton.setText("<html><span style='font-size:20px;'>Student</span></html>");
        StudentButton.setBounds(300,530,200,60);
        StudentButton.setBackground(new Color(217,217,217));
        StudentButton.setBorderPainted(false);
        StudentButton.setFocusable(false);
        StudentButton.addActionListener(e-> {
            welcome_frame.dispose();
            StudentLogIn();
        });

        //Parent Button
        JButton ParenttButton = new JButton();
        ParenttButton.setText("<html><span style='font-size:20px;'>Parent</span></html>");
        ParenttButton.setBounds(600,530,200,60);
        ParenttButton.setBackground(new Color(217,217,217));
        ParenttButton.setBorderPainted(false);
        ParenttButton.setFocusable(false);
        ParenttButton.addActionListener(e-> {
            welcome_frame.dispose();
            ParentLogIn();
        });

        // Admin Button
        JButton admin = new JButton();
        ImageIcon adminimg = new ImageIcon("Learning System\\DBS Project\\Images\\png-transparent-computer-icons-icon-design-business-administration-admin-icon-hand-monochrome-silhouette-thumbnail-removebg-preview.png");
        admin.setIcon(adminimg);

        // Adjust the size of the sun icon based on label size
        int adminWidth = 75; // Example width
        int adminHeight = 75; // Example height
        ImageIcon scaledexit = new ImageIcon(adminimg.getImage().getScaledInstance(adminWidth, adminHeight, java.awt.Image.SCALE_SMOOTH));
        admin.setIcon(scaledexit);

        admin.setBounds(10, 10, adminWidth, adminHeight);
        admin.setBorderPainted(false);
        admin.setBackground(new Color(13,31,51));
        // Remove border
        admin.setBorderPainted(false);

        // Set transparent background
        admin.setOpaque(false);
        admin.setContentAreaFilled(false);
        admin.setBorder(BorderFactory.createEmptyBorder());

        admin.addActionListener(e-> {
            welcome_frame.dispose();
            AdminLogIn();
        });



        //Text Admin
        JLabel tadmin = new JLabel();
        tadmin.setText("Admin");
        tadmin.setForeground(new Color(0,0,0)); // set font color
        tadmin.setFont(new Font("Inter",Font.BOLD,20)); // set font style
        tadmin.setBounds(15, 50, 300, 100);



        JLayeredPane Panel_welcome = new JLayeredPane();
        Panel_welcome.setBounds(0, 0, 1080, 720);

        Panel_welcome.add(StudentButton);
        Panel_welcome.add(ParenttButton);
        Panel_welcome.add(admin);
        Panel_welcome.add(tadmin);
        Panel_welcome.add(label1);

        welcome_frame.add(Panel_welcome);
        welcome_frame.setLayout(null);
        welcome_frame.setVisible(true);
    }

    public static void StudentLogIn() 
    {
        JFrame student_loin = new JFrame();
        student_loin.setSize(1080, 720); // set frame size
        student_loin.setTitle("Learning App"); // set frame title
        student_loin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cross close
        student_loin.setResizable(false); // disable frame resizing
        student_loin.setUndecorated(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the center point
        int centerX = (screenSize.width - student_loin.getWidth()) / 2;
        int centerY = (screenSize.height - student_loin.getHeight()) / 2;
        // Set the frame's location
        student_loin.setLocation(centerX, centerY);

        // StudentLogIn Image
        JLabel label1 = new JLabel();
        ImageIcon studentLog = new ImageIcon("Learning System\\DBS Project\\Images\\StudentLogIn.png");
        label1.setIcon(studentLog);
        
        int labelWidth = 1080; // Example width
        int labelHeight = 720; // Example height
        ImageIcon scaledstudentLog = new ImageIcon(studentLog.getImage().getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH));
        label1.setIcon(scaledstudentLog);
        label1.setBounds(0, 0, labelWidth, labelHeight); // Set bounds for label1

        //Text Field of SudentId
        JTextField StudentId = new JTextField();
        StudentId.setPreferredSize(new Dimension(175,40));
        StudentId.setFont(new Font("Inter",Font.BOLD,20));
        StudentId.setForeground(new Color(0,0,0));
        StudentId.setBounds(800, 420, 175, 40); // Adjusted position
        StudentId.setBorder(null); // Remove border

        //Text Field of SudentPassword
        JTextField StudentPassword = new JTextField();
        StudentPassword.setPreferredSize(new Dimension(175,40));
        StudentPassword.setFont(new Font("Inter",Font.BOLD,20));
        StudentPassword.setForeground(new Color(0,0,0));
        StudentPassword.setBounds(800, 507, 175, 40); // Adjusted position
        StudentPassword.setBorder(null); // Remove border

        // LogIn Button
        JButton studentButton = new JButton();
        studentButton.setText("<html><span style='font-size:12px; color:#FFFFFF;'>LOGIN</span></html>");
        studentButton.setBounds(753,580,225,30);
        studentButton.setBackground(new Color(255,92,0));
        studentButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        studentButton.setFocusable(false);

        studentButton.addActionListener(e->{

        ArrayList<String> studentids = new ArrayList<>();
        ArrayList<String> studentpass = new ArrayList<>();

        DB c = new DB();
        String url = c.geturl();
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Student");

            while (rs.next()) {
                studentids.add(rs.getString(1));
                studentpass.add(rs.getString(4));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException f) {
            f.printStackTrace();
        }

        boolean isfound = false;
        int i;
        for(i=0; i<studentids.size(); i++)
        {
            if(StudentId.getText().equals(studentids.get(i)))
            {
                isfound = true;
                break;
            }
        }

            if (isfound == true && StudentPassword.getText().equals(studentpass.get(i))) {
                student_loin.dispose();
                Lesson(Integer.parseInt(StudentId.getText()));
            } else {
                // Show error message or handle incorrect login
                JOptionPane.showMessageDialog(student_loin, "Incorrect Student ID or Password");
            }
        });

        // Forget Button
        JButton forgetButton = new JButton();
        forgetButton.setText("<html><span style='font-size:9px; color:#000000;'>Forgot Password</span></html>");
        forgetButton.setBounds(880,620,96,30);
        forgetButton.setOpaque(false);
        forgetButton.setContentAreaFilled(false);
        forgetButton.setBorderPainted(false);
        forgetButton.setFocusable(false);
        forgetButton.addActionListener(e->{
            student_loin.dispose();
            ForgotPassword();
        });

         // Back Button
         JButton back = new JButton();
         ImageIcon backimg = new ImageIcon("Learning System\\DBS Project\\Images\\Back.png");
         back.setIcon(backimg);
 
         // Adjust the size of the back icon based on label size
         int backWidth = 75; // Example width
         int adminHeight = 75; // Example height
         ImageIcon scaledexit = new ImageIcon(backimg.getImage().getScaledInstance(backWidth, adminHeight, java.awt.Image.SCALE_SMOOTH));
         back.setIcon(scaledexit);
 
         back.setBounds(10, 10, backWidth, adminHeight);
         back.setBorderPainted(false);
         back.setBackground(new Color(13,31,51));
         // Remove border
         back.setBorderPainted(false);
 
         // Set transparent background
         back.setOpaque(false);
         back.setContentAreaFilled(false);
         back.setBorder(BorderFactory.createEmptyBorder());
         back.addActionListener(e->{
            student_loin.dispose();
            MainScreen();
        });


        JLayeredPane Panel_student = new JLayeredPane();
        Panel_student.setBounds(0, 0, 1080, 720);

        Panel_student.add(StudentId);
        Panel_student.add(StudentPassword);
        Panel_student.add(studentButton);
        Panel_student.add(forgetButton);
        Panel_student.add(back);
        Panel_student.add(label1);

        student_loin.add(Panel_student);
        student_loin.setLayout(null);
        student_loin.setVisible(true);
    }

    public static void Report(int studentId)
    {
        JFrame report = new JFrame();
        report.setSize(1080, 720); // set frame size
        report.setTitle("Learning App"); // set frame title
        report.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cross close
        report.setResizable(false); // disable frame resizing
        report.setUndecorated(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the center point
        int centerX = (screenSize.width - report.getWidth()) / 2;
        int centerY = (screenSize.height - report.getHeight()) / 2;
        // Set the frame's location
        report.setLocation(centerX, centerY);

        // ParentLogIn Image
        JLabel label1 = new JLabel();
        ImageIcon reportimg = new ImageIcon("Learning System\\DBS Project\\Images\\Report_UI.png");
        label1.setIcon(reportimg);
        
        int labelWidth = 1080; // Example width
        int labelHeight = 720; // Example height
        ImageIcon scaledreport = new ImageIcon(reportimg.getImage().getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH));
        label1.setIcon(scaledreport);
        label1.setBounds(0, 0, labelWidth, labelHeight); // Set bounds for label1

        // Back Button
        JButton back = new JButton();
        ImageIcon backimg = new ImageIcon("Learning System\\DBS Project\\Images\\Back.png");
        back.setIcon(backimg);

        // Adjust the size of the back icon based on label size
        int backWidth = 75; // Example width
        int adminHeight = 75; // Example height
        ImageIcon scaledexit = new ImageIcon(backimg.getImage().getScaledInstance(backWidth, adminHeight, java.awt.Image.SCALE_SMOOTH));
        back.setIcon(scaledexit);
        back.addActionListener(e->{
            report.dispose();
            MainScreen();
        });

        back.setBounds(10, 10, backWidth, adminHeight);
        back.setBorderPainted(false);
        back.setBackground(new Color(13,31,51));
        back.setBorderPainted(false);
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorder(BorderFactory.createEmptyBorder());


        // Fetch and display the quiz report for the given student ID
    JTextArea reportArea = new JTextArea();
    reportArea.setFont(new Font("Arial", Font.PLAIN, 16));
    reportArea.setEditable(false);
    reportArea.setLineWrap(true);
    reportArea.setWrapStyleWord(true);
    reportArea.setBounds(200, 300, 100, 100);
    reportArea.setBackground(Color.pink);

    try {
        DB c = new DB();
        String url = c.geturl();
        Connection conn = DriverManager.getConnection(url);
        String query ="SELECT StudentMarks, TotalMarks FROM QuizResult WHERE StudentID = "+ studentId;
        Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

        // Append quiz report data to the text area
        while (rs.next()) {
            //String quizDate = rs.getString("QuizDate");
            int score = rs.getInt("StudentMarks");
            int total=rs.getInt("TotalMarks");
            reportArea.append("Total Marks " + total + ", Student Marks: " + score + "\n");
        }

        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(report, "Failed to fetch quiz report.", "Error", JOptionPane.ERROR_MESSAGE);
    }


    JScrollPane scrollPane = new JScrollPane(reportArea);
    scrollPane.setBounds(170, 230, 800, 400);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JLayeredPane Panel_report = new JLayeredPane();
        Panel_report.setBounds(0, 0, 1080, 720);
        //Panel_report.add(reportArea);

        Panel_report.add(scrollPane);
        Panel_report.add(back);
        Panel_report.add(label1);

        report.add(Panel_report);
        
        report.setLayout(null);
        report.setVisible(true); 
    }

    public static void ParentLogIn()
    {
        JFrame parent_login = new JFrame();
        parent_login.setSize(1080, 720); // set frame size
        parent_login.setTitle("Learning App"); // set frame title
        parent_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cross close
        parent_login.setResizable(false); // disable frame resizing
        parent_login.setUndecorated(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the center point
        int centerX = (screenSize.width - parent_login.getWidth()) / 2;
        int centerY = (screenSize.height - parent_login.getHeight()) / 2;
        // Set the frame's location
        parent_login.setLocation(centerX, centerY);

        // ParentLogIn Image
        JLabel label1 = new JLabel();
        ImageIcon parentLog = new ImageIcon("Learning System\\DBS Project\\Images\\ParentLogIn.png");
        label1.setIcon(parentLog);
        
        int labelWidth = 1080; // Example width
        int labelHeight = 720; // Example height
        ImageIcon scaledparentLog = new ImageIcon(parentLog.getImage().getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH));
        label1.setIcon(scaledparentLog);
        label1.setBounds(0, 0, labelWidth, labelHeight); // Set bounds for label1

        //Text Field of parentId
        JTextField parentId = new JTextField();
        parentId.setPreferredSize(new Dimension(175,40));
        parentId.setFont(new Font("Inter",Font.BOLD,20));
        parentId.setForeground(new Color(0,0,0));
        parentId.setBounds(800, 383, 175, 30); // Adjusted position
        parentId.setBorder(null); // Remove border

        //Text Field of SudentId
        JTextField StudentId = new JTextField();
        StudentId.setPreferredSize(new Dimension(175,40));
        StudentId.setFont(new Font("Inter",Font.BOLD,20));
        StudentId.setForeground(new Color(0,0,0));
        StudentId.setBounds(800, 445, 175, 30); // Adjusted position
        StudentId.setBorder(null); // Remove border

        //Text Field of parentPassword
        JTextField parentPassword = new JTextField();
        parentPassword.setPreferredSize(new Dimension(175,40));
        parentPassword.setFont(new Font("Inter",Font.BOLD,20));
        parentPassword.setForeground(new Color(0,0,0));
        parentPassword.setBounds(800, 509, 175, 30); // Adjusted position
        parentPassword.setBorder(null); // Remove border
        

        // LogIn Button
        JButton parentButton = new JButton();
        parentButton.setText("<html><span style='font-size:12px; color:#FFFFFF;'>LOGIN</span></html>");
        parentButton.setBounds(753,560,225,30);
        parentButton.setBackground(new Color(254,245,64));
        parentButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        parentButton.setFocusable(false);

        parentButton.addActionListener(e->{

        ArrayList<String> p_ids = new ArrayList<>();
        ArrayList<String> p_pass = new ArrayList<>();
        ArrayList<String> s_ids = new ArrayList<>();
        boolean isfound = false;
        int j;

        DB c = new DB();
        String url = c.geturl();
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Guardian");

            while (rs.next()) {
                p_ids.add(rs.getString(1));
                p_pass.add(rs.getString(3));
            }

            for(int i=0; i<p_ids.size(); i++)
            {
                if(parentId.getText().equals(p_ids.get(i)) && parentPassword.getText().equals(p_pass.get(i)))
                {
                    isfound = true;
                    break;
                }
            }

            if(isfound == true)
            {
                Statement stmt2 = conn.createStatement();
                String query = "Select * from Student where [Guardian ID]=" + parentId.getText();
                ResultSet rs2 = stmt.executeQuery(query);

                while (rs2.next()) {
                    s_ids.add(rs2.getString(1));
                }

                for(j=0; j<s_ids.size();j++)
                {
                    if(StudentId.getText().equals(s_ids.get(j)))
                    {
                        isfound = true;
                        break;
                    }
                    else
                    {
                        isfound = false;
                    }
                }

                rs.close();
                stmt2.close();
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException f) {
            f.printStackTrace();
        }


            if (isfound == true) {
                parent_login.dispose();
                Report(Integer.parseInt(parentId.getText()));
            } else {
                // Show error message or handle incorrect login
                JOptionPane.showMessageDialog(parent_login, "Incorrect Parent ID or Password or Student ID");
            }
        });

        // Forget Button
        JButton forgetButton = new JButton();
        forgetButton.setText("<html><span style='font-size:9px; color:#000000;'>Forgot Password</span></html>");
        forgetButton.setBounds(880,600,96,30);
        forgetButton.setOpaque(false);
        forgetButton.setContentAreaFilled(false);
        forgetButton.setBorderPainted(false);
        forgetButton.setFocusable(false);
        forgetButton.addActionListener(e->{
            parent_login.dispose();
            ForgotPassword();
        });

         // Back Button
         JButton back = new JButton();
         ImageIcon backimg = new ImageIcon("Learning System\\DBS Project\\Images\\Back.png");
         back.setIcon(backimg);
 
         // Adjust the size of the back icon based on label size
         int backWidth = 75; // Example width
         int adminHeight = 75; // Example height
         ImageIcon scaledexit = new ImageIcon(backimg.getImage().getScaledInstance(backWidth, adminHeight, java.awt.Image.SCALE_SMOOTH));
         back.setIcon(scaledexit);
 
         back.setBounds(10, 10, backWidth, adminHeight);
         back.setBorderPainted(false);
         back.setBackground(new Color(13,31,51));
         back.setBorderPainted(false);
         back.setOpaque(false);
         back.setContentAreaFilled(false);
         back.setBorder(BorderFactory.createEmptyBorder());
         back.addActionListener(e->{
            parent_login.dispose();
            MainScreen();
        });


        JLayeredPane Panel_parent = new JLayeredPane();
        Panel_parent.setBounds(0, 0, 1080, 720);

        Panel_parent.add(parentId);
        Panel_parent.add(StudentId);
        Panel_parent.add(parentPassword);
        Panel_parent.add(parentButton);
        Panel_parent.add(forgetButton);
        Panel_parent.add(back);
        Panel_parent.add(label1);

        parent_login.add(Panel_parent);
        parent_login.setLayout(null);
        parent_login.setVisible(true);
    }
    
    

    public static void Lesson(int s_Id)
    {
        JFrame lesson = new JFrame();
        lesson.setSize(1080, 720); // set frame size
        lesson.setTitle("Learning App"); // set frame title
        lesson.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cross close
        lesson.setResizable(false); // disable frame resizing
        lesson.setUndecorated(true);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the center point
        int centerX = (screenSize.width - lesson.getWidth()) / 2;
        int centerY = (screenSize.height - lesson.getHeight()) / 2;
        // Set the frame's location
        lesson.setLocation(centerX, centerY);

        // Leeson Image
        JLabel label1 = new JLabel();
        ImageIcon lessonimg = new ImageIcon("Learning System\\DBS Project\\Images\\Lesson.png");
        label1.setIcon(lessonimg);
        int labelWidth = 1080; // Example width
        int labelHeight = 720; // Example height
        ImageIcon scaledlesson = new ImageIcon(lessonimg.getImage().getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH));
        label1.setIcon(scaledlesson);
        label1.setBounds(0, 0, labelWidth, labelHeight);

        // Exit Button
        JButton exit = new JButton();
        ImageIcon exitimg = new ImageIcon("Learning System\\DBS Project\\Images\\Exit.png");
        exit.setIcon(exitimg);
        int exitWidth = 75; // Example width
        int exitHeight = 75; // Example height
        ImageIcon scaledexit = new ImageIcon(exitimg.getImage().getScaledInstance(exitWidth, exitHeight, java.awt.Image.SCALE_SMOOTH));
        exit.setIcon(scaledexit);
        exit.setBounds(25, 40, exitWidth, exitHeight);
        exit.setBorderPainted(false);
        exit.setBackground(new Color(13,31,51));
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorder(BorderFactory.createEmptyBorder());
        exit.addActionListener(e->{
            lesson.dispose();
            MainScreen();
        });


        //---------------------------------------------------------Scroll Panel Start------------------------------------------------//

        int count = 0;
        ArrayList<Integer> lessonid = new ArrayList<>();
        ArrayList<String> heading = new ArrayList<>();
        ArrayList<String> description = new ArrayList<>();
        ArrayList<Integer> color_r = new ArrayList<>();
        ArrayList<Integer> color_g = new ArrayList<>();
        ArrayList<Integer> color_b = new ArrayList<>();
        ArrayList<String> content = new ArrayList<>();

        DB c = new DB();
        String url = c.geturl();
        try {
            Connection conn = DriverManager.getConnection(url);

            Statement stmt3 = conn.createStatement();
            ResultSet rs3 = stmt3.executeQuery("Select Section from Student where [Student ID]="+s_Id);
            String section = "";
            if (rs3.next()) {
                section = rs3.getString(1);
            }
            rs3.close();
            stmt3.close();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select Count([Lesson ID]) from Lesson WHERE Section = '" + section + "'");

            if (rs.next()) {
                count = rs.getInt(1);
            }

            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT * FROM Lesson WHERE Section = '" + section + "'");

            while (rs2.next()) {
                lessonid.add(rs2.getInt(1));
                heading.add(rs2.getString(2));
                description.add(rs2.getString(3));
                content.add(rs2.getString(4));
                color_r.add(rs2.getInt(5));
                color_g.add(rs2.getInt(6));
                color_b.add(rs2.getInt(7));
            }

            rs2.close();
            rs.close();
            stmt.close();
            stmt2.close();
            conn.close();
        } catch (SQLException f) {
            f.printStackTrace();
        }

        //Text Rewards
        JLabel trewards = new JLabel();
        String rewards_text = "1 / "+ count;
        trewards.setText(rewards_text);
        trewards.setForeground(new Color(0,0,0)); // set font color
        trewards.setFont(new Font("Wendy One",Font.BOLD,40)); // set font style
        trewards.setBounds(910, 155, 300, 100);

        // Create JPanel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null); // Use null layout for precise positioning of buttons
        buttonPanel.setBackground(Color.WHITE);

        // Create an array of buttons
        JButton[] buttons = new JButton[count];

        for(int i = 0; i < count; i++) {
            buttons[i] = new JButton("<html><div style='text-align: left; padding-left: 10px;'><h1 style='font-size:20px; color:white; margin: 0;'>" + heading.get(i) + "</h1><p style='font-size:12px; color:white; margin: 0;'>" + description.get(i) + "</p></div></html>");
            buttons[i].setContentAreaFilled(false); // Set button content area filled to false
            buttons[i].setBorderPainted(false); // Remove button border
            buttons[i].setOpaque(true); // Make button opaque
            buttons[i].setHorizontalAlignment(SwingConstants.LEFT); // Set button text alignment to left
            buttons[i].setVerticalAlignment(SwingConstants.CENTER); // Set button text alignment to Top
            buttons[i].setBackground(new Color(color_r.get(i), color_g.get(i), color_b.get(i)));
            buttons[i].setBounds(0, i * 150, 598, 130); // Set the position and size of the button
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(new ButtonClickListener(s_Id,lessonid.get(i),lesson,heading.get(i),content.get(i),color_r.get(i), color_g.get(i), color_b.get(i))); // Assign different action to each button
            buttonPanel.add(buttons[i]); // Add buttons to the panel
        }

        // Set the preferred size of the button panel
        buttonPanel.setPreferredSize(new Dimension(600, count * 150));

        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setOpaque(true); // Set viewport opaque
        scrollPane.getViewport().setBackground(Color.WHITE); // Set background color of the viewport

        // Set horizontal scroll policy to never and vertical scroll policy to as needed
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add scroll pane to the layered pane
        scrollPane.setBounds(120, 220, 600, 464);

        //---------------------------------------------------------Scroll Panel End------------------------------------------------//

        // Create a layered panel and add components
        JLayeredPane Panel_lesson = new JLayeredPane();
        Panel_lesson.setBounds(0, 0, 1080, 720);
        Panel_lesson.add(exit, JLayeredPane.DEFAULT_LAYER);
        Panel_lesson.add(trewards, JLayeredPane.DEFAULT_LAYER);
        Panel_lesson.add(label1, JLayeredPane.DEFAULT_LAYER);
        Panel_lesson.add(scrollPane, JLayeredPane.PALETTE_LAYER);

        // Add the layered panel to the frame
        lesson.add(Panel_lesson);
        lesson.setLayout(null);
        lesson.setVisible(true);    

        //

        
    }
    
    public static void ForgotPassword()
    {
        JFrame forgotpassword = new JFrame();
        forgotpassword.setSize(1080, 720); // set frame size
        forgotpassword.setTitle("Learning App"); // set frame title
        forgotpassword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cross close
        forgotpassword.setResizable(false); // disable frame resizing
        forgotpassword.setUndecorated(true);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the center point
        int centerX = (screenSize.width - forgotpassword.getWidth()) / 2;
        int centerY = (screenSize.height - forgotpassword.getHeight()) / 2;
        // Set the frame's location
        forgotpassword.setLocation(centerX, centerY);

        // forgotPassword Image
        JLabel label1 = new JLabel();
        ImageIcon forgot = new ImageIcon("Learning System\\DBS Project\\Images\\Forgot Password.png");
        label1.setIcon(forgot);
        
        int labelWidth = 1080; // Example width
        int labelHeight = 720; // Example height
        ImageIcon scaledforgot = new ImageIcon(forgot.getImage().getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH));
        label1.setIcon(scaledforgot);
        label1.setBounds(0, 0, labelWidth, labelHeight); // Set bounds for label1


        // Back Button
        JButton back = new JButton();
        ImageIcon backimg = new ImageIcon("Learning System\\DBS Project\\Images\\Back.png");
        back.setIcon(backimg);

        // Adjust the size of the back icon based on label size
        int backWidth = 75; // Example width
        int adminHeight = 75; // Example height
        ImageIcon scaledexit = new ImageIcon(backimg.getImage().getScaledInstance(backWidth, adminHeight, java.awt.Image.SCALE_SMOOTH));
        back.setIcon(scaledexit);

        back.setBounds(10, 10, backWidth, adminHeight);
        back.setBorderPainted(false);
        back.setBackground(new Color(13,31,51));
        // Remove border
        back.setBorderPainted(false);

        // Set transparent background
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(e->{
            forgotpassword.dispose();
            MainScreen();
        });


        JLayeredPane Panel_forgot = new JLayeredPane();
        Panel_forgot.setBounds(0, 0, 1080, 720);

        Panel_forgot.add(back);
        Panel_forgot.add(label1);

        forgotpassword.add(Panel_forgot);
        forgotpassword.setLayout(null);
        forgotpassword.setVisible(true);
    }

    public static void Congrats(int s_Id)
    {
        JFrame congrats = new JFrame();
        congrats.setSize(1080, 720); // set frame size
        congrats.setTitle("Learning App"); // set frame title
        congrats.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cross close
        congrats.setResizable(false); // disable frame resizing
        congrats.setUndecorated(true);
        congrats.setUndecorated(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the center point
        int centerX = (screenSize.width - congrats.getWidth()) / 2;
        int centerY = (screenSize.height - congrats.getHeight()) / 2;
        // Set the frame's location
        congrats.setLocation(centerX, centerY);

        // ParentLogIn Image
        JLabel label1 = new JLabel();
        ImageIcon congratsimg = new ImageIcon("Learning System\\DBS Project\\Images\\Winning Screen.png");
        label1.setIcon(congratsimg);
        
        int labelWidth = 1080; // Example width
        int labelHeight = 720; // Example height
        ImageIcon scaledcongrats = new ImageIcon(congratsimg.getImage().getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH));
        label1.setIcon(scaledcongrats);
        label1.setBounds(0, 0, labelWidth, labelHeight); // Set bounds for label1

        // back_to_home Button
        JButton back_to_home = new JButton();
        back_to_home.setText("<html><span style='font-size:12px; color:#000000; font-family: Wendy One;'>Go Back To Main Screen</span></html>");
        back_to_home.setBounds(430,540,225,70);
        back_to_home.setBackground(new Color(250,175,0));
        back_to_home.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        back_to_home.setFocusable(false);
        back_to_home.addActionListener(e->{
            congrats.dispose();
            Lesson(s_Id);
        });

        JLayeredPane Panel_congrats = new JLayeredPane();
        Panel_congrats.setBounds(0, 0, 1080, 720);

        Panel_congrats.add(back_to_home);
        Panel_congrats.add(label1);

        congrats.add(Panel_congrats);
        congrats.setLayout(null);
        congrats.setVisible(true); 
    }

    public static void AdminLogIn()
    {
        JFrame admin_loin = new JFrame();
        admin_loin.setSize(1080, 720); // set frame size
        admin_loin.setTitle("Learning App"); // set frame title
        admin_loin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cross close
        admin_loin.setResizable(false); // disable frame resizing
        admin_loin.setUndecorated(true);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the center point
        int centerX = (screenSize.width - admin_loin.getWidth()) / 2;
        int centerY = (screenSize.height - admin_loin.getHeight()) / 2;
        // Set the frame's location
        admin_loin.setLocation(centerX, centerY);

        // AdminLogIn Image
        JLabel label1 = new JLabel();
        ImageIcon AdminLog = new ImageIcon("Learning System\\DBS Project\\Images\\Admin Page.png");
        label1.setIcon(AdminLog);
        // Adjust the size of the sun icon based on label size
        int labelWidth = 1080; // Example width
        int labelHeight = 720; // Example height
        ImageIcon scaledAdminLog = new ImageIcon(AdminLog.getImage().getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH));
        label1.setIcon(scaledAdminLog);
        label1.setBounds(0, 0, labelWidth, labelHeight); // Set bounds for label2



        // Back Button
        JButton back = new JButton();
        ImageIcon backimg = new ImageIcon("Learning System\\DBS Project\\Images\\Back.png");
        back.setIcon(backimg);

        // Adjust the size of the back icon based on label size
        int backWidth = 75; // Example width
        int adminHeight = 75; // Example height
        ImageIcon scaledexit = new ImageIcon(backimg.getImage().getScaledInstance(backWidth, adminHeight, java.awt.Image.SCALE_SMOOTH));
        back.setIcon(scaledexit);

        back.setBounds(10, 10, backWidth, adminHeight);
        back.setBorderPainted(false);
        back.setBackground(new Color(13,31,51));
        // Remove border
        back.setBorderPainted(false);

        // Set transparent background
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(e->{
            admin_loin.dispose();
            MainScreen();
        });


        //Text AdminID
        JLabel tAdminID = new JLabel();
        tAdminID.setText("Admin ID:");
        tAdminID.setForeground(new Color(255,255,255)); // set font color
        tAdminID.setFont(new Font("Inter",Font.BOLD,20)); // set font style
        tAdminID.setBounds(605, 235, 300, 100);

        //Text AdminPassword
        JLabel tAdminPassword = new JLabel();
        tAdminPassword.setText("Password:");
        tAdminPassword.setForeground(new Color(255,255,255)); // set font color
        tAdminPassword.setFont(new Font("Inter",Font.BOLD,20)); // set font style
        tAdminPassword.setBounds(605, 335, 300, 100);

        //Text Field of AdminId
        JTextField AdminId = new JTextField();
        AdminId.setPreferredSize(new Dimension(250,40));
        AdminId.setFont(new Font("Inter",Font.BOLD,20));
        AdminId.setForeground(new Color(255,255,255));
        AdminId.setBackground(new Color(13,31,51));
        AdminId.setBounds(600, 300, 250, 40); // Adjusted position
        AdminId.setBorder(null); // Remove border

        //Text Field of AdminPassword
        JTextField AdminPassword = new JTextField();
        AdminPassword.setPreferredSize(new Dimension(250,40));
        AdminPassword.setFont(new Font("Inter",Font.BOLD,20));
        AdminPassword.setForeground(new Color(255,255,255));
        AdminPassword.setBackground(new Color(13,31,51));
        AdminPassword.setBounds(600, 400, 250, 40); // Adjusted position
        AdminPassword.setBorder(null); // Remove border

        // LogIn Button
        JButton adminButton = new JButton();
        adminButton.setText("<html><span style='font-size:12px; color:#FFFFFF;'>LOGIN</span></html>");
        adminButton.setBounds(680,480,75,30);
        adminButton.setBackground(new Color(0,40,77));
        adminButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        adminButton.setFocusable(false);

        adminButton.addActionListener(e-> {

        ArrayList<String> adminids = new ArrayList<>();
        ArrayList<String> adminpass = new ArrayList<>();

        DB c = new DB();
        String url = c.geturl();
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Admin");

            while (rs.next()) {
                adminids.add(rs.getString(1));
                adminpass.add(rs.getString(2));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException f) {
            f.printStackTrace();
        }

        boolean isfound = false;
        int i;
        for(i=0; i<adminids.size(); i++)
        {
            if(AdminId.getText().equals(adminids.get(i)))
            {
                isfound = true;
                break;
            }
        }

            if (isfound == true && AdminPassword.getText().equals(adminpass.get(i))) 
            {
                admin_loin.dispose();
                option_screen();
            } 
            else
            {
                // Show error message or handle incorrect login
                JOptionPane.showMessageDialog(admin_loin, "Incorrect Admin ID or Password");
            }
        });


        JLayeredPane Panel_admin = new JLayeredPane();
        Panel_admin.setBounds(0, 0, 1080, 720);

        Panel_admin.add(tAdminID);
        Panel_admin.add(tAdminPassword);
        Panel_admin.add(AdminPassword);
        Panel_admin.add(AdminId);
        Panel_admin.add(back);
        Panel_admin.add(adminButton);
        Panel_admin.add(label1);

        admin_loin.add(Panel_admin);
        admin_loin.setLayout(null);
        admin_loin.setVisible(true);
    }


    public static void option_screen()
    {
        JFrame option = new JFrame();
        option.setSize(1080, 720); // set frame size
        option.setTitle("Learning App"); // set frame title
        option.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cross close
        option.setResizable(false); // disable frame resizing
        option.setUndecorated(true);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the center point
        int centerX = (screenSize.width - option.getWidth()) / 2;
        int centerY = (screenSize.height - option.getHeight()) / 2;
        // Set the frame's location
        option.setLocation(centerX, centerY);

        // OptionScreen Image
        JLabel label1 = new JLabel();
        ImageIcon AdminLog = new ImageIcon("Learning System\\DBS Project\\Images\\Admin_Enter3.png");
        label1.setIcon(AdminLog);
        // Adjust the size of the icon based on label size
        int labelWidth = 1080; // Example width
        int labelHeight = 720; // Example height
        ImageIcon scaledAdminLog = new ImageIcon(AdminLog.getImage().getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH));
        label1.setIcon(scaledAdminLog);
        label1.setBounds(0, 0, labelWidth, labelHeight); // Set bounds for label2


        // Back Button
        JButton back = new JButton();
        ImageIcon backimg = new ImageIcon("Learning System\\DBS Project\\Images\\Back.png");
        back.setIcon(backimg);

        // Adjust the size of the back icon based on label size
        int backWidth = 75; // Example width
        int adminHeight = 75; // Example height
        ImageIcon scaledexit = new ImageIcon(backimg.getImage().getScaledInstance(backWidth, adminHeight, java.awt.Image.SCALE_SMOOTH));
        back.setIcon(scaledexit);

        back.setBounds(10, 10, backWidth, adminHeight);
        back.setBorderPainted(false);
        back.setBackground(new Color(13,31,51));
        // Remove border
        back.setBorderPainted(false);

        // Set transparent background
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(e->{
            option.dispose();
            AdminLogIn();
        });

         // addUser Button
        JButton addButton = new JButton();
        addButton.setBounds(101,255,130,50);
        addButton.setFocusable(false);
        addButton.setOpaque(false);
        addButton.setContentAreaFilled(false);
        addButton.setBorderPainted(false);

        addButton.addActionListener(e->{
            option.dispose();
            addUser();
            
        });

        //add Lesson
        JButton addLessonButton = new JButton();
        addLessonButton.setBounds(101,440,130,50);
        addLessonButton.setFocusable(false);
        addLessonButton.setOpaque(false);
        addLessonButton.setContentAreaFilled(false);
        addLessonButton.setBorderPainted(false);

        addLessonButton.addActionListener(e->{
            option.dispose();
            addLesson();
        });

        //add Quiz
        JButton addQuiz = new JButton();
        addQuiz.setBounds(101,625,130,50);
        addQuiz.setFocusable(false);
        addQuiz.setOpaque(false);
        addQuiz.setContentAreaFilled(false);
        addQuiz.setBorderPainted(false);

        addQuiz.addActionListener(e->{
            option.dispose();
            lessonSearchPage();
        });

        JLayeredPane Panel_option = new JLayeredPane();
        Panel_option.setBounds(0, 0, 1080, 720);

        Panel_option.add(addQuiz);
        Panel_option.add(addButton);
        Panel_option.add(addLessonButton);
        Panel_option.add(back);
        Panel_option.add(label1);

        option.add(Panel_option);
        option.setLayout(null);
        option.setVisible(true);
    }

    public static void addUser()
    {
        JFrame addUser = new JFrame();
        addUser.setSize(1080, 720); // set frame size
        addUser.setTitle("Learning App"); // set frame title
        addUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cross close
        addUser.setResizable(false); // disable frame resizing
        addUser.setUndecorated(true);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the center point
        int centerX = (screenSize.width - addUser.getWidth()) / 2;
        int centerY = (screenSize.height - addUser.getHeight()) / 2;
        // Set the frame's location
        addUser.setLocation(centerX, centerY);

        // OptionScreen Image
        JLabel label1 = new JLabel();
        ImageIcon useradd = new ImageIcon("Learning System\\DBS Project\\Images\\Add_User.png");
        label1.setIcon(useradd);
        // Adjust the size of the icon based on label size
        int labelWidth = 1080; // Example width
        int labelHeight = 720; // Example height
        ImageIcon scaledAdminLog = new ImageIcon(useradd.getImage().getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH));
        label1.setIcon(scaledAdminLog);
        label1.setBounds(0, 0, labelWidth, labelHeight); // Set bounds for label2


        // Back Button
        JButton back = new JButton();
        ImageIcon backimg = new ImageIcon("Learning System\\DBS Project\\Images\\Back.png");
        back.setIcon(backimg);

        // Adjust the size of the back icon based on label size
        int backWidth = 75; // Example width
        int adminHeight = 75; // Example height
        ImageIcon scaledexit = new ImageIcon(backimg.getImage().getScaledInstance(backWidth, adminHeight, java.awt.Image.SCALE_SMOOTH));
        back.setIcon(scaledexit);

        back.setBounds(10, 10, backWidth, adminHeight);
        back.setBorderPainted(false);
        back.setBackground(new Color(13,31,51));
        // Remove border
        back.setBorderPainted(false);

        // Set transparent background
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(e->{
            addUser.dispose();
            option_screen();
        });


        //Text Field of SudentId
        JTextField StudentId = new JTextField();
        StudentId.setPreferredSize(new Dimension(175,40));
        StudentId.setFont(new Font("Inter",Font.BOLD,20));
        StudentId.setForeground(new Color(0,0,0));
        StudentId.setBounds(100, 265, 220, 40); // Adjusted position
        StudentId.setBorder(null); // Remove border

        //Text Field of SudentName
        JTextField StudentName = new JTextField();
        StudentName.setPreferredSize(new Dimension(175,40));
        StudentName.setFont(new Font("Inter",Font.BOLD,20));
        StudentName.setForeground(new Color(0,0,0));
        StudentName.setBounds(431, 265, 220, 40); // Adjusted position
        StudentName.setBorder(null); // Remove border

        //Text Field of SudentPassword
        JTextField StudentPass = new JTextField();
        StudentPass.setPreferredSize(new Dimension(175,40));
        StudentPass.setFont(new Font("Inter",Font.BOLD,20));
        StudentPass.setForeground(new Color(0,0,0));
        StudentPass.setBounds(762, 265, 220, 40); // Adjusted position
        StudentPass.setBorder(null); // Remove border

        //Text Field of SudentGuardian
        JTextField StudentGuardian = new JTextField();
        StudentGuardian.setPreferredSize(new Dimension(175,40));
        StudentGuardian.setFont(new Font("Inter",Font.BOLD,20));
        StudentGuardian.setForeground(new Color(0,0,0));
        StudentGuardian.setBounds(431, 377, 220, 40); // Adjusted position
        StudentGuardian.setBorder(null); // Remove border

        //Text Field of SudentSection
        JTextField StudentSection = new JTextField();
        StudentSection.setPreferredSize(new Dimension(175,40));
        StudentSection.setFont(new Font("Inter",Font.BOLD,20));
        StudentSection.setForeground(new Color(0,0,0));
        StudentSection.setBounds(100, 377, 220, 40); // Adjusted position
        StudentSection.setBorder(null); // Remove border

         // addStudent Button
        JButton add_Student_Button = new JButton();
        add_Student_Button.setBounds(810,370,125,45);
        add_Student_Button.setFocusable(false);
        add_Student_Button.setOpaque(false);
        add_Student_Button.setContentAreaFilled(false);
        add_Student_Button.setBorderPainted(false);

        add_Student_Button.addActionListener(e->{
            
            if(StudentId.getText().isEmpty() || StudentName.getText().isEmpty() || StudentPass.getText().isEmpty() || StudentSection.getText().isEmpty() || StudentGuardian.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(addUser,"Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                DB c = new DB();
                String url = c.geturl();
                ArrayList<String> studentids = new ArrayList<>();
                ArrayList<String> guardianids = new ArrayList<>();
                try {
                    Connection conn = DriverManager.getConnection(url);
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("Select * from Student");
        
                    while (rs.next()) {
                        studentids.add(rs.getString(1));
                    }
        
                    rs.close();
                    stmt.close();
    
                    Statement stmt2 = conn.createStatement();
                    ResultSet rs2 = stmt2.executeQuery("Select * from Guardian");
                    while (rs2.next()) {
                        guardianids.add(rs2.getString(1));
                    }
    
                    rs2.close();
                    stmt2.close();
    
                    conn.close();
                } catch (SQLException f) {
                    f.printStackTrace();
                }

                boolean found = false;
                boolean found2 = false;

                for(int i=0; i<studentids.size();i++)
            {
                if(studentids.get(i).equals(StudentId.getText()))
                {
                    found = true;
                    break;
                }
            }
            for(int i=0; i<guardianids.size();i++)
            {
                if(guardianids.get(i).equals(StudentGuardian.getText()))
                {
                    found2 = true;
                    break;
                }
            }
            if(found == true)
            {
                JOptionPane.showMessageDialog(addUser,"Student ID already exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if(found2 == false)
            {
                JOptionPane.showMessageDialog(addUser,"Guardian Does not Exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try {
                    Connection conn2 = DriverManager.getConnection(url);
                    String sql = "insert into Student([Student ID],[Student Name],[Guardian ID],[Student Password],Section) values (?,?,?,?,?)";
                    PreparedStatement preparedStatement = conn2.prepareStatement(sql);
                    preparedStatement.setInt(1, Integer.parseInt(StudentId.getText())); // student_id
                    preparedStatement.setString(2, StudentName.getText()); // student_name
                    preparedStatement.setInt(3, Integer.parseInt(StudentGuardian.getText()));
                    preparedStatement.setString(4, StudentPass.getText());
                    preparedStatement.setString(5, StudentSection.getText());
                    preparedStatement.executeUpdate();

                    preparedStatement.close();
                    conn2.close();

                    JOptionPane.showMessageDialog(addUser,"New Student Added.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException f) {
                    f.printStackTrace();
                }

            }

            }
        });


        //Text Field of GuardianId
        JTextField GuardianId = new JTextField();
        GuardianId.setPreferredSize(new Dimension(175,40));
        GuardianId.setFont(new Font("Inter",Font.BOLD,20));
        GuardianId.setForeground(new Color(0,0,0));
        GuardianId.setBounds(105, 550, 220, 40); // Adjusted position
        GuardianId.setBorder(null); // Remove border

        //Text Field of GuardianName
        JTextField GuardianName = new JTextField();
        GuardianName.setPreferredSize(new Dimension(175,40));
        GuardianName.setFont(new Font("Inter",Font.BOLD,20));
        GuardianName.setForeground(new Color(0,0,0));
        GuardianName.setBounds(437, 550, 220, 40); // Adjusted position
        GuardianName.setBorder(null); // Remove border

        //Text Field of GuardianPassword
        JTextField GuardianPass = new JTextField();
        GuardianPass.setPreferredSize(new Dimension(175,40));
        GuardianPass.setFont(new Font("Inter",Font.BOLD,20));
        GuardianPass.setForeground(new Color(0,0,0));
        GuardianPass.setBounds(104, 655, 220, 40); // Adjusted position
        GuardianPass.setBorder(null); // Remove border
        
        // addParent Button
        JButton add_Parent_Button = new JButton();
        add_Parent_Button.setBounds(810,645,125,45);
        add_Parent_Button.setFocusable(false);
        add_Parent_Button.setOpaque(false);
        add_Parent_Button.setContentAreaFilled(false);
        add_Parent_Button.setBorderPainted(false);

        add_Parent_Button.addActionListener(e->{
            if(GuardianId.getText().isEmpty() || GuardianName.getText().isEmpty() || GuardianPass.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(addUser,"Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                DB c = new DB();
                String url = c.geturl();
                ArrayList<String> guardianids = new ArrayList<>();
                try {
                    Connection conn = DriverManager.getConnection(url);
    
                    Statement stmt2 = conn.createStatement();
                    ResultSet rs2 = stmt2.executeQuery("Select * from Guardian");
                    while (rs2.next()) {
                        guardianids.add(rs2.getString(1));
                    }
    
                    rs2.close();
                    stmt2.close();
    
                    conn.close();
                } catch (SQLException f) {
                    f.printStackTrace();
                }

                boolean found2 = false;

            for(int i=0; i<guardianids.size();i++)
            {
                if(guardianids.get(i).equals(GuardianId.getText()))
                {
                    found2 = true;
                    break;
                }
            }
            
            if(found2 == true)
            {
                JOptionPane.showMessageDialog(addUser,"Guardian ID already Exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try {
                    Connection conn2 = DriverManager.getConnection(url);
                    String sql = "insert into Guardian([Guardian ID],[Guardian Name],[Password]) values (?,?,?)";
                    PreparedStatement preparedStatement = conn2.prepareStatement(sql);
                    preparedStatement.setInt(1, Integer.parseInt(GuardianId.getText()));
                    preparedStatement.setString(2, GuardianName.getText());
                    preparedStatement.setString(3, GuardianPass.getText());
                    preparedStatement.executeUpdate();

                    preparedStatement.close();
                    conn2.close();

                    JOptionPane.showMessageDialog(addUser,"New Guardian Added.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException f) {
                    f.printStackTrace();
                }

            }

            }
        });

        JLayeredPane Panel_addUser = new JLayeredPane();
        Panel_addUser.setBounds(0, 0, 1080, 720);

        Panel_addUser.add(add_Parent_Button);
        Panel_addUser.add(add_Student_Button);
        Panel_addUser.add(StudentId);
        Panel_addUser.add(StudentName);
        Panel_addUser.add(StudentPass);
        Panel_addUser.add(StudentGuardian);
        Panel_addUser.add(StudentSection);
        Panel_addUser.add(GuardianId);
        Panel_addUser.add(GuardianName);
        Panel_addUser.add(GuardianPass);
        Panel_addUser.add(back);
        Panel_addUser.add(label1);

        addUser.add(Panel_addUser);
        addUser.setLayout(null);
        addUser.setVisible(true);
    }

    public static void addLesson()
    {
        JFrame addUser = new JFrame();
        addUser.setSize(1080, 720); // set frame size
        addUser.setTitle("Learning App"); // set frame title
        addUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cross close
        addUser.setResizable(false); // disable frame resizing
        addUser.setUndecorated(true);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the center point
        int centerX = (screenSize.width - addUser.getWidth()) / 2;
        int centerY = (screenSize.height - addUser.getHeight()) / 2;
        // Set the frame's location
        addUser.setLocation(centerX, centerY);

        // OptionScreen Image
        JLabel label1 = new JLabel();
        ImageIcon useradd = new ImageIcon("Learning System\\DBS Project\\Images\\Add Lesson1.png");
        label1.setIcon(useradd);
        // Adjust the size of the icon based on label size
        int labelWidth = 1080; // Example width
        int labelHeight = 720; // Example height
        ImageIcon scaledAdminLog = new ImageIcon(useradd.getImage().getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH));
        label1.setIcon(scaledAdminLog);
        label1.setBounds(0, 0, labelWidth, labelHeight); // Set bounds for label2


        // Back Button
        JButton back = new JButton();
        ImageIcon backimg = new ImageIcon("Learning System\\DBS Project\\Images\\Back.png");
        back.setIcon(backimg);

        // Adjust the size of the back icon based on label size
        int backWidth = 75; // Example width
        int adminHeight = 75; // Example height
        ImageIcon scaledexit = new ImageIcon(backimg.getImage().getScaledInstance(backWidth, adminHeight, java.awt.Image.SCALE_SMOOTH));
        back.setIcon(scaledexit);

        back.setBounds(10, 10, backWidth, adminHeight);
        back.setBorderPainted(false);
        back.setBackground(new Color(13,31,51));
        // Remove border
        back.setBorderPainted(false);

        // Set transparent background
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(e->{
            addUser.dispose();
            option_screen();
        });

        //Text Field of LessonName
        JTextField LessonName = new JTextField();
        LessonName.setPreferredSize(new Dimension(175,40));
        LessonName.setFont(new Font("Inter",Font.BOLD,20));
        LessonName.setForeground(new Color(0,0,0));
        LessonName.setBounds(30, 229, 270, 40); // Adjusted position
        LessonName.setBorder(null); // Remove border

        //Text Field of LessonSection
        JTextField LessonSection = new JTextField();
        LessonSection.setPreferredSize(new Dimension(175,40));
        LessonSection.setFont(new Font("Inter",Font.BOLD,20));
        LessonSection.setForeground(new Color(0,0,0));
        LessonSection.setBounds(490, 227, 270, 40); // Adjusted position
        LessonSection.setBorder(null); // Remove border

        //Text Field of LessonDescription
        JTextField LessonDescription = new JTextField();
        LessonDescription.setPreferredSize(new Dimension(175,40));
        LessonDescription.setFont(new Font("Inter",Font.BOLD,20));
        LessonDescription.setForeground(new Color(0,0,0));
        LessonDescription.setBounds(30, 367, 270, 40); // Adjusted position
        LessonDescription.setBorder(null); // Remove border

        //Text Field of cr
        JTextField cr = new JTextField();
        cr.setPreferredSize(new Dimension(175,40));
        cr.setFont(new Font("Inter",Font.BOLD,20));
        cr.setForeground(new Color(0,0,0));
        cr.setBounds(490, 367, 40, 40); // Adjusted position
        cr.setBorder(null); // Remove border

        //Text Field of cg
        JTextField cg = new JTextField();
        cg.setPreferredSize(new Dimension(175,40));
        cg.setFont(new Font("Inter",Font.BOLD,20));
        cg.setForeground(new Color(0,0,0));
        cg.setBounds(550, 367, 40, 40); // Adjusted position
        cg.setBorder(null); // Remove border

        //Text Field of cb
        JTextField cb = new JTextField();
        cb.setPreferredSize(new Dimension(175,40));
        cb.setFont(new Font("Inter",Font.BOLD,20));
        cb.setForeground(new Color(0,0,0));
        cb.setBounds(606, 367, 40, 40); // Adjusted position
        cb.setBorder(null); // Remove border


        JTextArea content = new JTextArea();
        content.setFont(new Font("Inter", Font.BOLD, 20));
        content.setForeground(new Color(0, 0, 0));
        content.setLineWrap(true); // Enable text wrapping
        content.setWrapStyleWord(true); // Wrap at word boundaries
        JScrollPane scrollPane = new JScrollPane(content); // Add a scroll pane for long content
        scrollPane.setBounds(23, 500, 925, 190); // Adjusted position


         // addQuiz Button
         JButton add_Quiz_Button = new JButton();
         add_Quiz_Button.setBounds(940,225,115,80);
         add_Quiz_Button.setFocusable(false);
        add_Quiz_Button.setOpaque(false);
        add_Quiz_Button.setContentAreaFilled(false);
        add_Quiz_Button.setBorderPainted(false);
 
        DB d = new DB();
            String url = d.geturl();
         add_Quiz_Button.addActionListener(e->{
            if(LessonName.getText().isEmpty() || LessonDescription.getText().isEmpty() || LessonSection.getText().isEmpty() || content.getText().isEmpty() || cr.getText().isEmpty() || cg.getText().isEmpty() || cb.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(addUser,"Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {

                ArrayList<String> lessons = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Lesson");

            if(rs.next())
            {
                lessons.add(rs.getString(2));
            }

            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException f){
            f.printStackTrace();
        }
        boolean istrue = false;

        for(int i=0; i<lessons.size(); i++)
        {
            if(lessons.get(i).equals(LessonName.getText()))
            {
                JOptionPane.showMessageDialog(addUser,"Lessons Already Exist.", "Error", JOptionPane.ERROR_MESSAGE);
                istrue = true;
                break;
            }
        }

        if(istrue == false)
        {
            DB d2 = new DB();
            String url2 = d.geturl();
            int count = 0;
            try
            {Connection conn = DriverManager.getConnection(url2);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select COUNT([Lesson ID]) ID from Lesson");

            if(rs.next())
            {
                count=rs.getInt(1);
            }

            rs.close();
            stmt.close();
            conn.close();
        }
        catch(SQLException f)
        {
            f.printStackTrace();
        }
            try {
                Connection conn2 = DriverManager.getConnection(url);
                String sql = "insert into Lesson([Lesson ID],[Lesson Name],[Lesson Description],[Lesson Content],cr,cg,cb,Section) values (?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = conn2.prepareStatement(sql);
                preparedStatement.setInt(1, count+1);
                preparedStatement.setString(2, LessonName.getText()); // student_name
                preparedStatement.setString(3, LessonDescription.getText());
                preparedStatement.setString(4, content.getText());
                preparedStatement.setInt(5, Integer.parseInt(cr.getText()));
                preparedStatement.setInt(6, Integer.parseInt(cg.getText()));
                preparedStatement.setInt(7, Integer.parseInt(cb.getText()));
                preparedStatement.setString(8, LessonSection.getText());
                preparedStatement.executeUpdate();

                preparedStatement.close();
                conn2.close();

                JOptionPane.showMessageDialog(addUser,"New Lesson Added.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException f) {
                f.printStackTrace();
            }
        }
            }
         });
             

        JLayeredPane Panel_addUser = new JLayeredPane();
        Panel_addUser.setBounds(0, 0, 1080, 720);

        Panel_addUser.add(LessonName);
        Panel_addUser.add(LessonDescription);
        Panel_addUser.add(LessonSection);
        Panel_addUser.add(cr);
        Panel_addUser.add(cg);
        Panel_addUser.add(cb); 
        Panel_addUser.add(add_Quiz_Button); 
        Panel_addUser.add(scrollPane); 
        Panel_addUser.add(back);
        Panel_addUser.add(label1);

        addUser.add(Panel_addUser);
        addUser.setLayout(null);
        addUser.setVisible(true);
    }

    public static void lessonSearchPage()
    {
        JFrame search = new JFrame();
        search.setSize(1080, 720); // set frame size
        search.setTitle("Learning App"); // set frame title
        search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cross close
        search.setResizable(false); // disable frame resizing
        search.setUndecorated(true);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the center point
        int centerX = (screenSize.width - search.getWidth()) / 2;
        int centerY = (screenSize.height - search.getHeight()) / 2;
        // Set the frame's location
        search.setLocation(centerX, centerY);

        // OptionScreen Image
        JLabel label1 = new JLabel();
        ImageIcon useradd = new ImageIcon("Learning System\\DBS Project\\Images\\searchLesson.png");
        label1.setIcon(useradd);
        // Adjust the size of the icon based on label size
        int labelWidth = 1080; // Example width
        int labelHeight = 720; // Example height
        ImageIcon scaledAdminLog = new ImageIcon(useradd.getImage().getScaledInstance(labelWidth, labelHeight, java.awt.Image.SCALE_SMOOTH));
        label1.setIcon(scaledAdminLog);
        label1.setBounds(0, 0, labelWidth, labelHeight); // Set bounds for label2


        // Back Button
        JButton back = new JButton();
        ImageIcon backimg = new ImageIcon("Learning System\\DBS Project\\Images\\Back.png");
        back.setIcon(backimg);

        // Adjust the size of the back icon based on label size
        int backWidth = 75; // Example width
        int adminHeight = 75; // Example height
        ImageIcon scaledexit = new ImageIcon(backimg.getImage().getScaledInstance(backWidth, adminHeight, java.awt.Image.SCALE_SMOOTH));
        back.setIcon(scaledexit);

        back.setBounds(10, 10, backWidth, adminHeight);
        back.setBorderPainted(false);
        back.setBackground(new Color(13,31,51));
        // Remove border
        back.setBorderPainted(false);

        // Set transparent background
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(e->{
            search.dispose();
            option_screen();
        });

        //Text Field of LessonName
        JTextField LessonName = new JTextField();
        LessonName.setPreferredSize(new Dimension(175,40));
        LessonName.setFont(new Font("Inter",Font.BOLD,20));
        LessonName.setForeground(new Color(0,0,0));
        LessonName.setBounds(405, 315, 270, 40); // Adjusted position
        LessonName.setBorder(null); // Remove border

        // Search Button
        JButton hello = new JButton();
        hello.setBounds(480,400,125,45);
        hello.setFocusable(false);
        hello.setOpaque(false);
        hello.setContentAreaFilled(false);
        hello.setBorderPainted(false);

        hello.addActionListener(e->{
            DB c = new DB();
                String url = c.geturl();
                ArrayList<String> lessons = new ArrayList<>();
                try {
                    Connection conn = DriverManager.getConnection(url);
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("Select [Lesson Name] from Lesson");
        
                    while (rs.next()) {
                        lessons.add(rs.getString(1));
                    }
        
                    rs.close();
                    stmt.close();
    
                    conn.close();
                } catch (SQLException f) {
                    f.printStackTrace();
                }

                boolean found = false;
                int i=0;
                for(i=0 ; i<lessons.size();i++)
                {
                    if(lessons.get(i).equals(LessonName.getText()))
                    {
                        found = true;
                        break;
                    }
                }
                
                if(found == false)
                {
                    JOptionPane.showMessageDialog(search,"Could not Find Required Lesson.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    int id = 0;
                try {
                    Connection conn2 = DriverManager.getConnection(url);
                    Statement stmt2 = conn2.createStatement();
                    ResultSet rs2 = stmt2.executeQuery("select [Lesson ID] from Lesson where [Lesson Name] = '" + lessons.get(i) + "'");
        
                    if(rs2.next())
                    {
                        id = rs2.getInt(1);
                    }
        
                    rs2.close();
                    stmt2.close();
    
                    conn2.close();

                    search.dispose();
                    addQuiz(id);
                } catch (SQLException f) {
                    f.printStackTrace();
                }
                }
        });
        
        JLayeredPane Panel_addUser = new JLayeredPane();
        Panel_addUser.setBounds(0, 0, 1080, 720);

        Panel_addUser.add(hello);
        Panel_addUser.add(LessonName);
        Panel_addUser.add(back);
        Panel_addUser.add(label1);

        search.add(Panel_addUser);
        search.setLayout(null);
        search.setVisible(true);
    }
    
public static void addQuiz(int lessonid) {
    JFrame addQuizFrame = new JFrame();
    addQuizFrame.setSize(1080, 720);
    addQuizFrame.setTitle("Learning App");
    addQuizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    addQuizFrame.setResizable(false);
    addQuizFrame.setUndecorated(true);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int centerX = (screenSize.width - addQuizFrame.getWidth()) / 2;
    int centerY = (screenSize.height - addQuizFrame.getHeight()) / 2;
    addQuizFrame.setLocation(centerX, centerY);

    JLabel backgroundLabel = new JLabel();
    ImageIcon backgroundIcon = new ImageIcon("Learning System\\DBS Project\\Images\\Add_Quiz.png");
    int labelWidth = 1080;
    int labelHeight = 720;
    ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH));
    backgroundLabel.setIcon(scaledBackgroundIcon);
    backgroundLabel.setBounds(0, 0, labelWidth, labelHeight);

    JButton backButton = new JButton();
    ImageIcon backIcon = new ImageIcon("Learning System\\DBS Project\\Images\\Back.png");
    int backWidth = 75;
    int backHeight = 75;
    ImageIcon scaledBackIcon = new ImageIcon(backIcon.getImage().getScaledInstance(backWidth, backHeight, Image.SCALE_SMOOTH));
    backButton.setIcon(scaledBackIcon);
    backButton.setBounds(10, 10, backWidth, backHeight);
    backButton.setBorderPainted(false);
    backButton.setBackground(new Color(13, 31, 51));
    backButton.setOpaque(false);
    backButton.setContentAreaFilled(false);
    backButton.setBorder(BorderFactory.createEmptyBorder());
    backButton.addActionListener(e -> {
        addQuizFrame.dispose();
        lessonSearchPage();
    });

    JTextField questionField = new JTextField();
    questionField.setPreferredSize(new Dimension(175, 40));
    questionField.setFont(new Font("Inter", Font.BOLD, 20));
    questionField.setForeground(Color.BLACK);
    questionField.setBounds(30, 245, 1000, 40);
    questionField.setBorder(null);

    JTextField choice1Field = new JTextField();
    choice1Field.setPreferredSize(new Dimension(175, 40));
    choice1Field.setFont(new Font("Inter", Font.BOLD, 20));
    choice1Field.setForeground(Color.BLACK);
    choice1Field.setBounds(30, 360, 270, 40);
    choice1Field.setBorder(null);

    JTextField choice2Field = new JTextField();
    choice2Field.setPreferredSize(new Dimension(175, 40));
    choice2Field.setFont(new Font("Inter", Font.BOLD, 20));
    choice2Field.setForeground(Color.BLACK);
    choice2Field.setBounds(410, 360, 250, 40);
    choice2Field.setBorder(null);

    JTextField choice3Field = new JTextField();
    choice3Field.setPreferredSize(new Dimension(175, 40));
    choice3Field.setFont(new Font("Inter", Font.BOLD, 20));
    choice3Field.setForeground(Color.BLACK);
    choice3Field.setBounds(30, 463, 270, 40);
    choice3Field.setBorder(null);

    JTextField choice4Field = new JTextField();
    choice4Field.setPreferredSize(new Dimension(175, 40));
    choice4Field.setFont(new Font("Inter", Font.BOLD, 20));
    choice4Field.setForeground(Color.BLACK);
    choice4Field.setBounds(410, 463, 250, 40);
    choice4Field.setBorder(null);

    JTextField correctAnswerField = new JTextField();
    correctAnswerField.setPreferredSize(new Dimension(175, 40));
    correctAnswerField.setFont(new Font("Inter", Font.BOLD, 20));
    correctAnswerField.setForeground(Color.BLACK);
    correctAnswerField.setBounds(780, 360, 250, 40);
    correctAnswerField.setBorder(null);

    JButton addQuizButton = new JButton();
    addQuizButton.setBounds(920, 535, 125, 45);
    addQuizButton.setFocusable(false);
    addQuizButton.setOpaque(false);
    addQuizButton.setContentAreaFilled(false);
    addQuizButton.setBorderPainted(false);
    addQuizButton.addActionListener(e -> {
        
        if (questionField.getText().isEmpty() || choice1Field.getText().isEmpty() || choice2Field.getText().isEmpty() || choice3Field.getText().isEmpty() || choice4Field.getText().isEmpty() || correctAnswerField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(addQuizFrame, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                DB c = new DB();
                String url = c.geturl();
                Connection conn = DriverManager.getConnection(url);

                Statement stmtcount = conn.createStatement();
                ResultSet res = stmtcount.executeQuery("select Count(*) from Quiz");

                int count=0;
                if(res.next())
                {
                    count = res.getInt(1);
                }
                // Prepare SQL statement
                String sql = "insert into Quiz([Quiz ID],[Lesson ID],Question,[Choice 1],[Choice 2],[Choice 3],[Choice 4],[Correct Answer]) values (?,?,?,?,?,?,?,?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, count+1);
                statement.setInt(2, lessonid);
                statement.setString(3, questionField.getText());
                statement.setString(4, choice1Field.getText());
                statement.setString(5, choice2Field.getText());
                statement.setString(6, choice3Field.getText());
                statement.setString(7, choice4Field.getText());
                statement.setString(8, correctAnswerField.getText());

                // Execute statement
                statement.executeUpdate();

                // Close connections
                statement.close();
                conn.close();

                JOptionPane.showMessageDialog(addQuizFrame, "Quiz added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(addQuizFrame, "An error occurred while adding the quiz.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

    

    JLayeredPane panelAddQuiz = new JLayeredPane();
    panelAddQuiz.setBounds(0, 0, 1080, 720);
    panelAddQuiz.add(addQuizButton);
    panelAddQuiz.add(correctAnswerField);
    panelAddQuiz.add(choice4Field);
    panelAddQuiz.add(choice3Field);
    panelAddQuiz.add(choice2Field);
    panelAddQuiz.add(choice1Field);
    panelAddQuiz.add(questionField);
    panelAddQuiz.add(backButton);
    panelAddQuiz.add(backgroundLabel);

    addQuizFrame.add(panelAddQuiz);
    addQuizFrame.setLayout(null);
    addQuizFrame.setVisible(true);
}

}
class ButtonClickListener implements ActionListener 
{
    private int lessonid;
    private JFrame frame;
    private String Heading;
    private String content;
    private int cr;
    private int cg;
    private int cb;
    private int studentID;

    public ButtonClickListener(int s_Id,int l_id, JFrame frame, String h,String c ,int r, int g, int b) {
        lessonid = l_id;
        this.frame = frame;
        Heading = h;
        content = c;
        cr = r;
        cg = g;
        cb = b;
        studentID=s_Id;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Action to perform when the button is clicked
        frame.dispose();
        new content(studentID,lessonid,Heading,content,cr,cg,cb);
    }
}




