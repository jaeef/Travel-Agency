import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Login extends JFrame {

    private Container c;
    private ImageIcon icon, logo;
    private JLabel label1, imgLabel;
    private Font f1, f2, f4, f5;
    private JTextField tf1;
    private JButton btn1, btn2, btn3;
    private Cursor cursor;

    Login() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("User login");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#9f94b5"));

        // Load icon image
        
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        

        
        logo = new ImageIcon(getClass().getResource("account.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(110, 50, 250, 250);
        c.add(imgLabel);

        f1 = new Font("Calibri", Font.BOLD, 50);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f4 = new Font("Segoe UI", Font.PLAIN, 30);
        f5 = new Font("Segoe UI", Font.PLAIN, 22);

        label1 = new JLabel();
        label1.setText("User Login");
        label1.setBounds(480, 50, 500, 90);
        label1.setFont(f1);
        c.add(label1);

        label1 = new JLabel();
        label1.setText("User Name");
        label1.setBounds(430, 145, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(600, 155, 200, 35);
        tf1.setFont(f5);
        c.add(tf1);

        label1 = new JLabel();
        label1.setText("Password");
        label1.setBounds(430, 205, 500, 50);
        label1.setFont(f4);
        c.add(label1);

        JPasswordField tf2 = new JPasswordField();
        tf2.setBounds(600, 215, 200, 35);
        tf2.setFont(f2);
        tf2.setEchoChar('*');
        c.add(tf2);

        btn1 = new JButton("Exit");
        btn1.setBounds(90, 325, 215, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.RED);
        c.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(340, 325, 215, 50);
        btn2.setFont(f2);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2e75b6"));
        c.add(btn2);

        btn3 = new JButton("Login");
        btn3.setBounds(590, 325, 215, 50);
        btn3.setFont(f2);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#57b847"));
        c.add(btn3);

        //exit button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        //Back Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Home frame = new Home();
                frame.setVisible(true);
            }
        });

        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String userName = tf1.getText().toLowerCase();
                String password = new String(tf2.getPassword());

                if (userName.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    try (BufferedReader reader = new BufferedReader(new FileReader("./Data/user_data.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.contains("User Name : " + userName)) {
                                String nextLine = reader.readLine();
                                if (nextLine != null && nextLine.contains("Password : " + password)) {
                                    JOptionPane.showMessageDialog(null, "Login Successful.", "Travel Agency!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    setVisible(false);
                                    
                                    DefPackTypes  frame =new DefPackTypes() ;
                                    frame.setVisible(true);
                                    return;
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error reading user data file.", "Error!",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        Login frame = new Login();
        frame.setVisible(true);
    }
}
