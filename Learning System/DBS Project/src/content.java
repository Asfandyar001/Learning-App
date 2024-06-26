import javax.swing.*;
import java.awt.*;

public class content {
    private static int q_Id=1;

    public content(int s_Id,int l_id,String heading, String con ,int cr, int cg, int cb) {
        
        JFrame frame = new JFrame();
        frame.setSize(1080, 720); // set frame size
        frame.setTitle("Learning App"); // set frame title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cross close
        frame.setResizable(false); // disable frame resizing
        frame.setUndecorated(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Calculate the center point
        int centerX = (screenSize.width - frame.getWidth()) / 2;
        int centerY = (screenSize.height - frame.getHeight()) / 2;
        // Set the frame's location
        frame.setLocation(centerX, centerY);

        // top bar
        JLabel top = new JLabel();
        top.setText("<html><div style='text-align: center; padding-left: 350px;'><h1 style='font-size:35px; color:black;'>" + heading);
        top.setBounds(-2, 0, 1080, 100);
        top.setBackground(new Color(cr,cg,cb));
        top.setOpaque(true);
        top.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        //Quiz Button
        
        JButton Quiz = new JButton();
        Quiz.setText("<html><span style='font-size:20px;'>Take Quiz</span></html>");
        Quiz.setBounds(868,570,180,60);
        Quiz.setBackground(new Color(cr,cg,cb));
        Quiz.setBorderPainted(false);
        Quiz.setFocusable(false);
        Quiz.addActionListener(e->{
            frame.dispose();
            
            new MCQQuiz(s_Id,q_Id++,l_id,cr,cg,cb);
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
        panel.add(Quiz, JLayeredPane.DEFAULT_LAYER);
        panel.add(top, JLayeredPane.DEFAULT_LAYER);
        panel.add(scrollPane, JLayeredPane.DEFAULT_LAYER);

        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
