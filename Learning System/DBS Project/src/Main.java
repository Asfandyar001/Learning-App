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
       ReportGenerator rg=new ReportGenerator();
       rg.generateQuizReportForStudent(1);
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

    public static void Report()
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

        JLayeredPane Panel_report = new JLayeredPane();
        Panel_report.setBounds(0, 0, 1080, 720);

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
                Report();
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
        String rewards_text = "3 / "+ count;
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
        ImageIcon AdminLog = new ImageIcon("Learning System\\DBS Project\\Images\\Admin_Enter.png");
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

         // add Button
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

        JLayeredPane Panel_option = new JLayeredPane();
        Panel_option.setBounds(0, 0, 1080, 720);

        Panel_option.add(addButton);
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

        // addStudent Button
        JButton add_Parent_Button = new JButton();
        add_Parent_Button.setBounds(810,645,125,45);
        add_Parent_Button.setFocusable(false);
        add_Parent_Button.setOpaque(false);
        add_Parent_Button.setContentAreaFilled(false);
        add_Parent_Button.setBorderPainted(false);

        add_Parent_Button.addActionListener(e->{

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
        Panel_addUser.add(back);
        Panel_addUser.add(label1);

        addUser.add(Panel_addUser);
        addUser.setLayout(null);
        addUser.setVisible(true);
    }
}

class ButtonClickListener implements ActionListener {
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
