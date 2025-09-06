import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PaySuccess extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1, imgLabel;
    private Font f1, f2;
    private ImageIcon logo;
    private JButton btn1, nBtn;
    private Cursor cursor;

    PaySuccess() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sucessfull Payment");
        this.setSize(650, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#9f94b5"));

        // Icon
        
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());

        // Logo
        
        logo = new ImageIcon(getClass().getResource("card (2).png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(200, 20, 250, 250);
        c.add(imgLabel);

        // Fonts
        f1 = new Font("Segoe UI Black", Font.PLAIN, 35);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Title
        label1 = new JLabel();
        label1.setText("  Payment Confirmed ");
        label1.setBounds(130, 250, 500, 50);
        label1.setFont(f1);
        c.add(label1);

        
        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        btn1 = new JButton("Exit ");
        btn1.setBounds(230, 325, 200, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2E75B6"));
        c.add(btn1);
        
        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] args) {

        PaySuccess frame = new PaySuccess();
        frame.setVisible(true);
    }
}
