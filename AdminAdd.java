import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class AdminAdd extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1;
    private Font f1, f2, f3, f4, f5, f6;
    private JTextField tf1, tf2, tf4;
    private JComboBox<String> securityQsn; // Parameterized type
    private JButton btn1, btn2, nBtn;
    private JPasswordField tf3;
    private Cursor cursor;

    public AdminAdd() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(550, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#9f94b5"));

        // Icon
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Times New Roman", Font.BOLD, 35);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI Semibold", Font.PLAIN, 35);
        f4 = new Font("Segoe UI", Font.PLAIN, 25);
        f5 = new Font("Segoe UI", Font.PLAIN, 19);
        f6 = new Font("Segoe UI", Font.PLAIN, 25);

        // Title
        label1 = new JLabel("Enter Information");
        label1.setBounds(130, 25, 500, 50);
        label1.setFont(f1);
        c.add(label1);

        // User Name
        JLabel label2 = new JLabel("User Name");
        label2.setBounds(45, 75, 500, 50);
        label2.setFont(f4);
        c.add(label2);

        tf1 = new JTextField();
        tf1.setBounds(185, 85, 290, 30);
        tf1.setFont(f5);
        c.add(tf1);

        // Email
        JLabel label3 = new JLabel("Email");
        label3.setBounds(45, 110, 500, 50);
        label3.setFont(f4);
        c.add(label3);

        tf2 = new JTextField();
        tf2.setBounds(185, 120, 290, 30);
        tf2.setFont(f5);
        c.add(tf2);

        // Password
        JLabel label4 = new JLabel("Password");
        label4.setBounds(45, 145, 500, 50);
        label4.setFont(f4);
        c.add(label4);

        tf3 = new JPasswordField();
        tf3.setBounds(185, 155, 290, 30);
        tf3.setFont(f2);
        tf3.setEchoChar('*');
        c.add(tf3);

        // Question
        JLabel label5 = new JLabel("Question");
        label5.setBounds(45, 180, 500, 50);
        label5.setFont(f4);
        c.add(label5);

        String[] secQsn = { "Choose a Security Question...", "Your Cgpa?", "Your favorite song?",
                "Favourite coding language?", "Any hobby?" };
        securityQsn = new JComboBox<>(secQsn); // Use parameterized type
        securityQsn.setBounds(185, 190, 290, 30);
        securityQsn.setSelectedIndex(0);
        securityQsn.setFont(f5);
        securityQsn.setBackground(Color.white);
        c.add(securityQsn);

        // Answer
        JLabel label6 = new JLabel("Answer");
        label6.setBounds(45, 215, 500, 50);
        label6.setFont(f4);
        c.add(label6);

        tf4 = new JTextField();
        tf4.setBounds(185, 225, 290, 30);
        tf4.setFont(f5);
        c.add(tf4);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Back");
        btn1.setBounds(65, 310, 183, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.BLACK);
        btn1.setBackground(Color.decode("#2E75B6"));
        c.add(btn1);

        btn2 = new JButton("Add");
        btn2.setBounds(270, 310, 183, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        c.add(btn2);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // Back Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                UserData frame = new UserData();
                frame.setVisible(true);
                // Uncomment above lines and ensure UserData class is defined
            }
        });

        // Register Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String textField1 = tf1.getText().toLowerCase(); // User Name
                String textField2 = tf2.getText(); // Email
                String textField3 = new String(tf3.getPassword()); // Password
                String textField4 = tf4.getText(); // Security Question Answer
                String secQsn = String.valueOf(securityQsn.getSelectedItem()); // Security Question

                if (textField1.isEmpty() || textField2.isEmpty() || textField3.isEmpty() || textField4.isEmpty()
                        || ((securityQsn.getSelectedIndex()) == 0)) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        File file = new File("./Data/user_data.txt");
                        if (!file.exists()) {
                            file.getParentFile().mkdirs(); // Create directories if they do not exist
                            file.createNewFile();
                        }
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        LocalDateTime myDateObj = LocalDateTime.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

                        String timeAndDate = myDateObj.format(myFormatObj);

                        pw.println("             ## Added by Admin ##");
                        pw.println("User Name : " + textField1);
                        pw.println("Password : " + textField3);
                        pw.println("Email : " + textField2);
                        pw.println("Security Question : " + secQsn);
                        pw.println("Answer : " + textField4);
                        pw.println("Time & Date : " + timeAndDate);
                        pw.println("===============================================");
                        pw.close();

                    } catch (Exception ex) {
                        System.out.print(ex);
                    }

                    JOptionPane.showMessageDialog(null, "User has been added.", "User Added",
                            JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    AdminAdd frame = new AdminAdd();
                    frame.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AdminAdd frame = new AdminAdd();
                frame.setVisible(true);
            }
        });
    }
}
