import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Welcome extends JFrame {

    private Container c;
    private ImageIcon icon, logo;
    private JLabel imgLabel, welcomeLabel;
    private Font f1, f2;
    private JButton btn1, btn3;
    private Cursor cursor;

    Welcome() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(800, 550);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#9f94b5"));

        // Load icon image
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());

        logo = new ImageIcon(getClass().getResource("iconbig.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(240, 5, 350, 300);
        c.add(imgLabel);

        // Welcome Text
        f2 = new Font("Calibri", Font.BOLD, 40);
        welcomeLabel = new JLabel("Welcome To Travel Agency");
        welcomeLabel.setFont(f2);
        welcomeLabel.setBounds(180, 310, 450, 50);
        c.add(welcomeLabel);

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 25);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Exit");
        btn1.setBounds(175, 400, 200, 50);
        btn1.setFont(f1);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        c.add(btn1);

        btn3 = new JButton("Next");
        btn3.setBounds(450, 400, 200, 50);
        btn3.setFont(f1);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        c.add(btn3);

        // Action Listener for JButtons
        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Next Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Home frame = new Home();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Welcome frame = new Welcome();
        frame.setVisible(true);
    }
}
