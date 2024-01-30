package CMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class AdminDelTe extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    String Username = "root";
    String Passwords = "";
    String url = "jdbc:mysql://localhost:3306/cms";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminDelTe frame = new AdminDelTe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminDelTe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 548, 297);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 535, 263);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Teacher ID:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setBounds(82, 122, 150, 18);
        panel.add(lblNewLabel);

        JButton btnNewButton = new JButton("Remove");
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(100, 149, 237)));
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteTeacher();
            }
        });
        btnNewButton.setBounds(82, 187, 96, 32);
        panel.add(btnNewButton);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(new Color(255, 255, 255));
        btnCancel.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(100, 149, 237)));
        btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminTe().setVisible(true);
            }
        });
        btnCancel.setBounds(230, 187, 96, 32);
        panel.add(btnCancel);

        textField = new JTextField();
        textField.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(100, 149, 237)));
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textField.setBounds(230, 123, 139, 19);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Remove Teachers");
        lblNewLabel_1.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(100, 149, 237)));
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lblNewLabel_1.setBounds(192, 27, 199, 32);
        panel.add(lblNewLabel_1);
        
        JButton btnNewButton_1 = new JButton("Back");
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(100, 149, 237)));
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new AdminTe().setVisible(true);
        		
        	}
        });
        btnNewButton_1.setBounds(384, 187, 96, 32);
        panel.add(btnNewButton_1);
    }

    private void deleteTeacher() {
        try (Connection con = DriverManager.getConnection(url, Username, Passwords)) {
            String deleteQuery = "DELETE FROM addeacher WHERE `ID`=?";

            try (PreparedStatement pst = con.prepareStatement(deleteQuery)) {
                pst.setString(1, textField.getText());

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Teacher removed successfully!");
                    dispose();  // Close the delete frame
                    new AdminTe().setVisible(true);  // Refresh the teacher management frame
                } else {
                    System.out.println("Failed to remove teacher. Teacher not found.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
