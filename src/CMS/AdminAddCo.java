package CMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class AdminAddCo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
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
					AdminAddCo frame = new AdminAddCo();
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
	public AdminAddCo() {
		table = new JTable();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 535, 447);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(105, 109, 81, 18);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(105, 161, 81, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Module Leader:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(105, 212, 130, 18);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(100, 149, 237)));
		textField.setBounds(245, 109, 139, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_1.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(100, 149, 237)));
		textField_1.setBounds(245, 161, 139, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_2.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(100, 149, 237)));
		textField_2.setBounds(245, 212, 139, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(100, 149, 237)));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminCo().setVisible(true);
			}
		});
		btnNewButton.setBounds(48, 375, 96, 32);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("New Course");
		lblNewLabel_3.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(100, 149, 237)));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(194, 31, 190, 32);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBorder(new MatteBorder(1, 1, 3, 3, (Color) new Color(100, 149, 237)));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		// Assuming this is inside your ActionListener for the "Add" button
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Validate input fields
		        if (validateInput()) {
		            try (Connection con = DriverManager.getConnection(url, Username, Passwords);
		                 Statement st = con.createStatement()) {

		                String insertQuery = "INSERT INTO addcourse (`ID`, `Name`, `Module Leader`, `Course`) VALUES (?, ?, ?, ?)";

		                try (PreparedStatement pst = con.prepareStatement(insertQuery)) {
		                    pst.setString(1, textField.getText());
		                    pst.setString(2, textField_1.getText());
		                    pst.setString(3, textField_2.getText());
		                    pst.setString(4, textField_3.getText());

		                    int rowsAffected = pst.executeUpdate();

		                    if (rowsAffected > 0) {
		                        // If the insertion was successful
		                        JOptionPane.showMessageDialog(null, "Course added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

		                        dispose();  // Close the current frame
		                        new AdminCo().setVisible(true);
		                    } else {
		                        JOptionPane.showMessageDialog(null, "Failed to add course.", "Error", JOptionPane.ERROR_MESSAGE);
		                    }
		                }

		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});
		

		btnNewButton_1.setBounds(376, 375, 96, 32);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Course:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setBounds(105, 263, 81, 18);
		panel.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_3.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(100, 149, 237)));
		textField_3.setBounds(245, 263, 139, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
	}
	private boolean validateInput() {
	    if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty() || textField_3.getText().isEmpty()) {
	        // Display an error message for empty fields
	        JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }

	    // You can add additional validation checks as needed

	    return true;
	}

}
