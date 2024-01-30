package CMS;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class AdminUpStu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    String Username = "root";
    String Passwords = "";
    String url = "jdbc:mysql://localhost:3306/cms";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminUpStu frame = new AdminUpStu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AdminUpStu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 566, 494);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 0, 535, 447);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Name:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_1.setBounds(61, 139, 81, 18);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Email:");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2.setBounds(61, 183, 81, 18);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Phone Number:");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel_3.setBounds(61, 228, 148, 13);
        panel.add(lblNewLabel_3);

        textField_1 = new JTextField();
        textField_1.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(100, 149, 237)));
        textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_1.setBounds(204, 141, 139, 19);
        panel.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(100, 149, 237)));
        textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_2.setBounds(204, 185, 139, 19);
        panel.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(100, 149, 237)));
        textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_3.setBounds(204, 227, 139, 19);
        panel.add(textField_3);
        textField_3.setColumns(10);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(100, 149, 237)));
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminStu().setVisible(true);
            }
        });
        btnNewButton.setBounds(61, 374, 96, 32);
        panel.add(btnNewButton);

        JLabel lblNewLabel_4 = new JLabel("Update Student");
        lblNewLabel_4.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(100, 149, 237)));
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewLabel_4.setBounds(180, 49, 199, 32);
        panel.add(lblNewLabel_4);

        JButton btnNewButton_1 = new JButton("Update");
        btnNewButton_1.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(100, 149, 237)));
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });
        btnNewButton_1.setBounds(365, 374, 96, 32);
        panel.add(btnNewButton_1);

        JLabel lblNewLabel_5 = new JLabel("Course:");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_5.setBounds(61, 276, 81, 18);
        panel.add(lblNewLabel_5);

        textField_4 = new JTextField();
        textField_4.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(100, 149, 237)));
        textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField_4.setBounds(204, 273, 139, 19);
        panel.add(textField_4);
        textField_4.setColumns(10);
    }

    private void updateStudent() {
        try (Connection con = DriverManager.getConnection(url, Username, Passwords)) {
            String updateQuery = "UPDATE addstudent SET `Email`=?, `Phone Number`=?, `Module Name`=? WHERE `Student Name`=?";

            try (PreparedStatement pst = con.prepareStatement(updateQuery)) {
                pst.setString(1, textField_2.getText());
                pst.setString(2, textField_3.getText());
                pst.setString(3, textField_4.getText());
                pst.setString(4, textField_1.getText());  // Assuming 'Teacher Name' is the primary key

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(contentPane, "Student updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();  // Close the update frame
                    new AdminStu().setVisible(true);  // Refresh the teacher management frame
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Failed to update student.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
