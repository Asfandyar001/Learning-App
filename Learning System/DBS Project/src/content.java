import javax.swing.*;
import java.awt.*;

public class content {
    public content(int l_id,String heading, String con ,int cr, int cg, int cb) {
        JFrame frame = new JFrame();
        frame.setSize(1080, 720); // set frame size
        frame.setTitle("Learning App"); // set frame title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cross close
        frame.setResizable(false); // disable frame resizing
        frame.setLocationRelativeTo(null); // center the frame

        // top bar
        JLabel top = new JLabel();
        top.setText("<html><div style='text-align: center; padding-left: 350px;'><h1 style='font-size:35px; color:black;'>" + heading);
        top.setBounds(-2, 0, 1080, 100);
        top.setBackground(new Color(cr,cg,cb));
        top.setOpaque(true);
        top.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        // Back Button
        JButton back = new JButton();
        ImageIcon backimg = new ImageIcon("DBS Project\\Images\\Back.png");
        back.setIcon(backimg);
        int backWidth = 60; // Example width
        int adminHeight = 60; // Example height
        ImageIcon scaledexit = new ImageIcon(backimg.getImage().getScaledInstance(backWidth, adminHeight, java.awt.Image.SCALE_SMOOTH));
        back.setIcon(scaledexit);
        back.setBounds(10, 20, backWidth, adminHeight);
        back.setBorderPainted(false);
        back.setBackground(new Color(13,31,51));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.addActionListener(e->{
            frame.dispose();
            Main.Lesson();
        });

        // Audio Button
        JButton audio = new JButton();
        ImageIcon audioimg = new ImageIcon("DBS Project\\Images\\Audio_Icon.png");
        audio.setIcon(audioimg);
        int audioWidth = 60; // Example width
        int audioHeight = 60; // Example height
        ImageIcon scaledaudio = new ImageIcon(audioimg.getImage().getScaledInstance(audioWidth, audioHeight, java.awt.Image.SCALE_SMOOTH));
        audio.setIcon(scaledaudio);
        audio.setBounds(970, 20, audioWidth, audioHeight);
        audio.setBorderPainted(false);
        audio.setBackground(new Color(13,31,51));
        audio.setBorder(BorderFactory.createEmptyBorder());
        audio.setOpaque(false);
        audio.setContentAreaFilled(false);

        //Quiz Button
        JButton Quiz = new JButton();
        Quiz.setText("<html><span style='font-size:20px;'>Take Quiz</span></html>");
        Quiz.setBounds(868,570,180,60);
        Quiz.setBackground(new Color(cr,cg,cb));
        Quiz.setBorderPainted(false);
        Quiz.setFocusable(false);
        Quiz.addActionListener(e->{
            frame.dispose();
            new MCQQuiz(l_id,cr,cg,cb);
        });

        // Content Area with Scroll Pane
        JTextArea contentArea = new JTextArea();
        contentArea.setEditable(false); // Set text area to read-only
        contentArea.setText(con); // Add your text here
        contentArea.setLineWrap(true); // Wrap words
        contentArea.setWrapStyleWord(true); // Wrap at word boundaries
        contentArea.setBackground(new Color(240,240,240)); // Set background color to white

        JScrollPane scrollPane = new JScrollPane(contentArea);
        scrollPane.setBorder(null); // Remove border
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(50, 100, 800, 583);

        // Layered Pane
        JLayeredPane panel = new JLayeredPane();
        panel.setBackground(Color.WHITE); // Set background color to white
        panel.setBounds(0, 0, 1080, 720);
        panel.add(audio, JLayeredPane.DEFAULT_LAYER);
        panel.add(back, JLayeredPane.DEFAULT_LAYER);
        panel.add(Quiz, JLayeredPane.DEFAULT_LAYER);
        panel.add(top, JLayeredPane.DEFAULT_LAYER);
        panel.add(scrollPane, JLayeredPane.DEFAULT_LAYER);

        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
