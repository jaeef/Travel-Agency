import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.nio.file.*;

public class UserData extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1;
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton btn1, btn2, btn3, btn4, btn5, nBtn;
    private Cursor cursor;

    private String[] column = { "User Name", "Password", "Email", "Security Question", "Answer", "Date and Time" };
    private String[] rows = new String[6]; // Adjusted to match column count

    UserData() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#9f94b5"));

        // Icon
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());

        // Fonts
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel("User Data");
        label1.setBounds(300, 10, 400, 80);
        label1.setFont(f1);
        c.add(label1);

        // JButtons
        btn1 = new JButton("Refresh");
        btn1.setBounds(550, 490, 180, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2E75B6"));
        c.add(btn1);

        btn2 = new JButton("Delete");
        btn2.setBounds(200, 490, 150, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#C00000"));
        c.add(btn2);

        btn3 = new JButton("Add");
        btn3.setBounds(750, 490, 100, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        c.add(btn3);

        btn4 = new JButton("Exit");
        btn4.setBounds(50, 490, 100, 50);
        btn4.setFont(f2);
        btn4.setCursor(cursor);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#C00000"));
        c.add(btn4);

        btn5 = new JButton("Back");
        btn5.setBounds(370, 490, 170, 50);
        btn5.setFont(f2);
        btn5.setCursor(cursor);
        btn5.setForeground(Color.WHITE);
        btn5.setBackground(Color.decode("#2E75B6"));
        c.add(btn5);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);
        table.setModel(model);
        table.setFont(f3);
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(220);

        scroll = new JScrollPane(table);
        scroll.setBounds(50, 90, this.getWidth() - 60, this.getHeight() - 210);
        scroll.setBackground(Color.WHITE);
        c.add(scroll);

        String file = ".\\Data\\user_data.txt";
        String temp = ".\\Data\\temp.txt";

        // To input data in the table
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("User")) {
                    rows[0] = line.substring(12); // User Name
                    rows[1] = reader.readLine().substring(11); // Password
                    rows[2] = reader.readLine().substring(8); // Email
                    rows[3] = reader.readLine().substring(20); // Security Question
                    rows[4] = reader.readLine().substring(9); // Answer
                    rows[5] = reader.readLine().substring(14); // Date and Time
                    model.addRow(rows);
                }
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Refresh Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                UserData frame = new UserData();
                frame.setVisible(true);
            }
        });

        // Delete Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (table.getSelectionModel().isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!", JOptionPane.WARNING_MESSAGE);
                } else {
                    String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
                    File oldFile = new File(file);
                    File newFile = new File(temp);

                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
                        String line;
                        boolean delete = false;

                        while ((line = reader.readLine()) != null) {
                            if (line.startsWith("User") && line.substring(12).equals(removeUser)) {
                                delete = true;
                                // Skip the next 5 lines
                                reader.readLine(); // Skip Password
                                reader.readLine(); // Skip Email
                                reader.readLine(); // Skip Security Question
                                reader.readLine(); // Skip Answer
                                reader.readLine(); // Skip Date and Time
                            } else {
                                if (delete) {
                                    delete = false;
                                    continue;
                                }
                                writer.write(line + System.lineSeparator());
                            }
                        }
                        reader.close();
                        writer.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    oldFile.delete();
                    newFile.renameTo(new File(file));

                    model.removeRow(table.getSelectedRow());
                }
            }
        });

        // Add Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminAdd frame = new AdminAdd();
                frame.setVisible(true);
            }
        });

        // Exit Button
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Admin frame = new Admin();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        UserData frame = new UserData();
        frame.setVisible(true);
    }
}
