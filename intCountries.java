import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class intCountries extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1;
    private Font f1, f2, f3;
    private JButton btn1, btn2, btn3, nBtn;
    private Cursor cursor;
    private JCheckBox country1, country2, country3, country4, country5;
    private int country = 0;

    public intCountries() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(750, 550);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#9f94b5"));

        // Icon
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Tahoma", Font.BOLD, 35);
        f2 = new Font("Segoe UI Semibold", Font.PLAIN, 20);
        f3 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel("Select Your Destination With Us ");
        label1.setBounds(67, 25, 650, 50);
        label1.setFont(f1);
        c.add(label1);

        // Country JCheckBoxes
        country1 = new JCheckBox("        France");
        country1.setBounds(275, 120, 200, 50);
        country1.setFont(f2);
        country1.setBackground(Color.decode("#2e75b6"));
        country1.setForeground(Color.WHITE);
        country1.setCursor(cursor);
        c.add(country1);

        country2 = new JCheckBox("         Italy");
        country2.setBounds(275, 180, 200, 50);
        country2.setFont(f2);
        country2.setForeground(Color.WHITE);
        country2.setBackground(Color.decode("#2e75b6"));
        country2.setCursor(cursor);
        c.add(country2);

        country3 = new JCheckBox("       Greece");
        country3.setBounds(275, 240, 200, 50);
        country3.setFont(f2);
        country3.setForeground(Color.WHITE);
        country3.setBackground(Color.decode("#2e75b6"));
        country3.setCursor(cursor);
        c.add(country3);

        country4 = new JCheckBox("    South Africa");
        country4.setBounds(275, 300, 200, 50);
        country4.setFont(f2);
        country4.setForeground(Color.WHITE);
        country4.setBackground(Color.decode("#2e75b6"));
        country4.setCursor(cursor);
        c.add(country4);

        country5 = new JCheckBox("      Indonesia");
        country5.setBounds(275, 360, 200, 50);
        country5.setFont(f2);
        country5.setForeground(Color.WHITE);
        country5.setBackground(Color.decode("#2e75b6"));
        country5.setCursor(cursor);
        c.add(country5);

        // Buttons
        btn1 = new JButton("Exit");
        btn1.setBounds(80, 450, 180, 40);
        btn1.setFont(f3);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        c.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(280, 450, 180, 40);
        btn2.setFont(f3);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2e75b6"));
        c.add(btn2);

        btn3 = new JButton("Next");
        btn3.setBounds(476, 450, 180, 40);
        btn3.setFont(f3);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2e75b6"));
        c.add(btn3);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // Event handling
        Handler handler = new Handler();
        country1.addActionListener(handler);
        country2.addActionListener(handler);
        country3.addActionListener(handler);
        country4.addActionListener(handler);
        country5.addActionListener(handler);

        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Uncomment the following section if the relevant classes are defined

        // Back Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                DefPackTypes frame = new DefPackTypes();
                frame.setVisible(true);
                setVisible(false);
            }
        });

        // Next Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (country == 1) {
                    setVisible(false);
                    InternationalFrance frame = new InternationalFrance();
                    frame.setVisible(true);
                } else if (country == 2) {
                    setVisible(false);
                    InternationalItaly frame = new InternationalItaly();
                    frame.setVisible(true);
                } else if (country == 3) {
                    setVisible(false);
                    InternationalGreece frame = new InternationalGreece();
                    frame.setVisible(true);
                } else if (country == 4) {
                    setVisible(false);
                    InternationalSouthAfrica frame = new InternationalSouthAfrica();
                    frame.setVisible(true);
                } else if (country == 5) {
                    setVisible(false);
                    InternationalIndonesia frame = new InternationalIndonesia();
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a country.", "Warning!!!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }

    // Handler class
    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear all selections
            country1.setSelected(false);
            country2.setSelected(false);
            country3.setSelected(false);
            country4.setSelected(false);
            country5.setSelected(false);

            // Select the clicked checkbox
            JCheckBox selectedCheckBox = (JCheckBox) e.getSource();
            selectedCheckBox.setSelected(true);

            // Update the country variable based on the selected checkbox
            if (selectedCheckBox == country1) {
                country = 1;
            } else if (selectedCheckBox == country2) {
                country = 2;
            } else if (selectedCheckBox == country3) {
                country = 3;
            } else if (selectedCheckBox == country4) {
                country = 4;
            } else if (selectedCheckBox == country5) {
                country = 5;
            }
        }
    }

    public static void main(String[] args) {
        intCountries frame = new intCountries();
        frame.setVisible(true);
    }
}

