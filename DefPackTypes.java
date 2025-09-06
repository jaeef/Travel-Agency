import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DefPackTypes extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1, imgLabel;
    private Font f1, f2, f3;
    private ImageIcon logo;
    private JButton btn1, btn2, btn3, nBtn, international, domestic;
    private Cursor cursor;
    private int defPack = 0;

    DefPackTypes() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(650, 550);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#9f94b5"));

        // Icon
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Segoe UI Black", Font.PLAIN, 40);
        f2 = new Font("Segoe UI Semibold", Font.PLAIN, 30);
        f3 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("Choose Tour Type");
        label1.setBounds(150, 70, 500, 50);
        label1.setFont(f1);
        c.add(label1);

        // International Button
        international = new JButton("International");
        international.setBounds(190, 170, 300, 50);
        international.setFont(f2);
        international.setCursor(cursor);
        international.setBackground(Color.decode("#2E75B6"));
        international.setForeground(Color.WHITE);
        c.add(international);

        // Domestic Button
        domestic = new JButton("Domestic");
        domestic.setBounds(190, 265, 300, 50);
        domestic.setFont(f2);
        domestic.setCursor(cursor);
        domestic.setBackground(Color.decode("#2E75B6"));
        domestic.setForeground(Color.WHITE);
        c.add(domestic);

        // JButtons for other actions
        btn1 = new JButton("Exit");
        btn1.setBounds(45, 370, 170, 50);
        btn1.setFont(f3);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        c.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(230, 370, 170, 50);
        btn2.setFont(f3);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        c.add(btn2);

        btn3 = new JButton("Next");
        btn3.setBounds(420, 370, 170, 50);
        btn3.setFont(f3);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        c.add(btn3);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // ActionListeners for the new buttons
        international.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                defPack = 1;
            }
        });

        domestic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                defPack = 2;
            }
        });

        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
                Login frame = new Login();
                frame.setVisible(true);
                setVisible(false);
            }
        });

        // Next Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (defPack == 1) {
                    intCountries frame = new intCountries();
                    frame.setVisible(true);
                    setVisible(false);
                    dispose();
                } else if (defPack == 2) {
                    DomPlaces frame = new DomPlaces();
                    frame.setVisible(true);
                    setVisible(false);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select tour type.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        DefPackTypes frame = new DefPackTypes();
        frame.setVisible(true);
    }
}
