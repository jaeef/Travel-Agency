import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class InternationalIndonesia extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1, label2, label3, imgLabel;
    private Font f1, f2, f3, f4, f5;
    private ImageIcon logo;
    private JButton btn1, btn2, btn3, nBtn;
    private Cursor cursor;
    private ButtonGroup radioButtonGroup;
    private JRadioButton pack1, pack2, pack3;
    private int selected = 0;

    InternationalIndonesia() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(850,630);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#9f94b5"));

        // Icon
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Segoe UI Black", Font.PLAIN, 30);
        f2 = new Font("Segoe UI Semibold", Font.BOLD, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 25);
        f4 = new Font("Segoe UI", Font.PLAIN, 20);
        f5 = new Font("Segoe UI Black", Font.PLAIN, 25);

        
        // Cursor for JButtons and Radio Buttons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("  Available for Indonesia Tour!");
        label1.setBounds(140, 35, 600, 50);
        label1.setFont(f1);
        c.add(label1);

        label2 = new JLabel();
        label2.setText("Select Your Favourite package");
        label2.setBounds(140, 70, 500, 50);
        label2.setFont(f1);
        c.add(label2);

        // Pack 1 Details
        pack1 = new JRadioButton("Pack 1");
        pack1.setBounds(140, 150, 100, 50);
        pack1.setFont(f3);
        pack1.setBackground(Color.decode("#9f94b5"));
        pack1.setCursor(cursor);
        c.add(pack1);

        label3 = new JLabel();
        label3.setText("* First Class");
        label3.setBounds(140, 180, 520, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* 5 Star Hotel");
        label3.setBounds(140, 210, 520, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* By Airplane");
        label3.setBounds(140, 240, 520, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* 5 Persons");
        label3.setBounds(140, 270, 520, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* 6 Days");
        label3.setBounds(140, 300, 520, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* Cost : $3000");
        label3.setBounds(140, 330, 520, 50);
        label3.setFont(f4);
        c.add(label3);

        // Pack 2 Details
        pack2 = new JRadioButton("Pack 2");
        pack2.setBounds(345, 150, 100, 50);
        pack2.setFont(f3);
        pack2.setBackground(Color.decode("#9f94b5"));
        pack2.setCursor(cursor);
        c.add(pack2);

        label3 = new JLabel();
        label3.setText("* Second Class");
        label3.setBounds(345, 180, 500, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* 3 Star Hotel");
        label3.setBounds(345, 210, 500, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* By Airplane");
        label3.setBounds(345, 240, 500, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* 4 Persons");
        label3.setBounds(345, 270, 500, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* 4 Days");
        label3.setBounds(345, 300, 500, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* Cost : $1500");
        label3.setBounds(345, 330, 500, 50);
        label3.setFont(f4);
        c.add(label3);

        // Pack 3 Details
        pack3 = new JRadioButton("Pack 3");
        pack3.setBounds(570, 150, 500, 50);
        pack3.setFont(f3);
        pack3.setBackground(Color.decode("#9f94b5"));
        pack3.setCursor(cursor);
        c.add(pack3);

        label3 = new JLabel();
        label3.setText("* Third Class");
        label3.setBounds(570, 180, 500, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* 2 Star Hotel");
        label3.setBounds(570, 210, 500, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* By Airplane");
        label3.setBounds(570, 240, 500, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* 4 Persons");
        label3.setBounds(570, 270, 500, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* 3 Days");
        label3.setBounds(570, 300, 500, 50);
        label3.setFont(f4);
        c.add(label3);

        label3 = new JLabel();
        label3.setText("* Cost : $1000");
        label3.setBounds(570, 330, 500, 50);
        label3.setFont(f4);
        c.add(label3);

        // To group the radio buttons.
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(pack1);
        radioButtonGroup.add(pack2);
        radioButtonGroup.add(pack3);

        // JButtons
        btn1 = new JButton("Exit");
        btn1.setBounds(100, 450, 215, 50);
        btn1.setFont(f5);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        c.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(330, 450, 215, 50);
        btn2.setFont(f5);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2e75b6"));
        c.add(btn2);

        btn3 = new JButton("Pay");
        btn3.setBounds(560, 450, 215, 50);
        btn3.setFont(f5);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2e75b6"));
        c.add(btn3);


        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        Handler handler = new Handler();
        pack1.addActionListener(handler);
        pack2.addActionListener(handler);
        pack3.addActionListener(handler);

        // Action Listener for JButtons
        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                intCountries frame = new intCountries();
                frame.setVisible(true);
            }
        });

        // Next Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (selected == 0) {
                    JOptionPane.showMessageDialog(null, "You did not select any packs.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    setVisible(false);
                    Payment frame = new Payment();
                    frame.setVisible(true);
                }
            }
        });
    }

    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == pack1) {
                selected = 1;
            } else if (e.getSource() == pack2) {
                selected = 2;
            } else if (e.getSource() == pack3) {
                selected = 3;
            }
        }
    }

    public static void main(String[] args) {

        InternationalIndonesia frame = new InternationalIndonesia();
        frame.setVisible(true);
    }
}
