package CMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.regex.Pattern;

public class Signup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username_signup;
	private JTextField uniid_text;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setTitle("Signup Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1043, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlightText);
		panel.setBounds(-15, -37, 1044, 690);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
		lblNewLabel.setBounds(612, 42, 322, 41);
		panel.add(lblNewLabel);
		
		JLabel signup_username = new JLabel("Username");
		signup_username.setFont(new Font("Times New Roman", Font.BOLD, 16));
		signup_username.setBounds(656, 211, 80, 13);
		panel.add(signup_username);
		
		username_signup = new JTextField();
		username_signup.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		username_signup.setBorder(new MatteBorder(0,0,1,1,Color.blue));
		username_signup.setBounds(649, 234, 203, 25);
		panel.add(username_signup);
		username_signup.setColumns(10);
		
		
		
		JLabel uniId = new JLabel("Email");
		uniId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		uniId.setBounds(656, 269, 122, 13);
		panel.add(uniId);
		
		uniid_text = new JTextField();
		uniid_text.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		uniid_text.setBorder(new MatteBorder(0,0,1,1,Color.blue));
		uniid_text.setBounds(649, 292, 203, 25);
		panel.add(uniid_text);
		uniid_text.setColumns(10);
		
		JLabel pass = new JLabel("Password");
		pass.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pass.setBounds(656, 385, 203, 13);
		
		panel.add(pass);
		
		JLabel pass2 = new JLabel("Confirm Password");
		pass2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pass2.setBounds(656, 443, 137, 13);
		panel.add(pass2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(0, 0, 255), 1, true));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select the course","BCS", "BIBM"}));
		comboBox.setBounds(649, 554, 203, 25);
		panel.add(comboBox);
		
		JComboBox<String> mode = new JComboBox();
		mode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedUserType = (String) mode.getSelectedItem();
		        if ("Student".equals(selectedUserType) || "Teacher".equals(selectedUserType)) {
		            textField.setVisible(true);
		            comboBox.setVisible(true);
		        } else {
		            textField.setVisible(false);
		            textField.setText(""); // Clear the text field for admins
		            comboBox.setVisible(false);
		            comboBox.setSelectedItem("Select the course"); // Clear the selection for admins
		        }
				    }
				});
			
		mode.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mode.setModel(new DefaultComboBoxModel(new String[] {"Select the mode","Admin", "Teacher", "Student"}));
		mode.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		mode.setBackground(SystemColor.text);
		mode.setBounds(649, 157, 203, 25);
		panel.add(mode);
		
		JLabel lblNewLabel_7 = new JLabel("Already have an account?");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_7.setBounds(628, 646, 152, 18);
		panel.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = username_signup.getText().trim();
		        String univ = uniid_text.getText().trim();
		        String password = passwordField.getText().trim();
		        String password1 = passwordField_1.getText().trim();
		        String value = (String) comboBox.getSelectedItem();
		        String value1 = (String) mode.getSelectedItem();
		        String phone = textField.getText().trim();

		        if (!username.equals("") && !univ.equals("") && !password.equals("") && !password1.equals("") && !value.equals("") && !value1.equals("")) {
		            if (password.equals(password1)) {
		                Connection con;
		                String url = "jdbc:mysql://localhost:3306/cms";
		                String username1 = "root";
		                String passwords = "";

		                try {
		                    con = DriverManager.getConnection(url, username1, passwords);
		                    String insertQuery;

		                    if ("Student".equals(value1) || "Teacher".equals(value1)) {
		                        // User is a teacher or student, include phone_number column
		                        insertQuery = "INSERT INTO signup (Username, email, Password, Course, mode, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
		                    } else {
		                        // User is an admin, don't include phone_number and course columns
		                        insertQuery = "INSERT INTO signup (Username, email, Password, mode) VALUES (?, ?, ?, ?)";
		                    }

		                    try (PreparedStatement pst = con.prepareStatement(insertQuery)) {
		                        // Set parameters based on user type
		                        int parameterIndex = 1;
		                        pst.setString(parameterIndex++, username);
		                        pst.setString(parameterIndex++, univ);
		                        pst.setString(parameterIndex++, password);
		                        if ("Admin".equals(value1)) {
		                            // User is an admin, don't include phone_number and course columns
		                            pst.setString(parameterIndex++, value1);
		                        } else {
		                            // User is a teacher or student, include phone_number and course columns
		                            pst.setString(parameterIndex++, value); // Use value for Course for student/teacher
		                            pst.setString(parameterIndex++, value1);
		                            pst.setString(parameterIndex++, phone);
		                        }
		                        pst.executeUpdate();
		                    }

		                    con.close();
		                    JOptionPane.showMessageDialog(null, "Successfully created the account!!!");

		                    // Add code to navigate to the login screen or perform other actions after successful sign-up
		                    dispose(); // Close the current frame
		                    new Login().setVisible(true);

		                } catch (Exception ee) {
		                    ee.printStackTrace();
		                    JOptionPane.showMessageDialog(null, "Error during sign-up. Please try again.");
		                }
		            } else {
		                JOptionPane.showMessageDialog(null, "Password does not match!!");
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Please fill in all the required fields.");
		        }
			}
		});
		JComboBox<String> comboSelectMode = mode;
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					
					
					
				
			}
		});
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(628, 601, 267, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(30, 144, 255));
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton_1.setBorderPainted(false); 
        btnNewButton_1.setContentAreaFilled(false); 
        btnNewButton_1.setFocusPainted(false); 
        btnNewButton_1.setOpaque(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    dispose();
					new Login().setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(767, 643, 85, 21);
		panel.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passwordField.setBorder(new MatteBorder(0,0,1,1,Color.blue));
		passwordField.setBounds(649, 408, 203, 25);
		panel.add(passwordField);
		
		
		passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                validatePassword(passwordField.getPassword());
            }
        });
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Signup.class.getResource("/CMS/image/signup (1).jpg")));
		lblNewLabel_6.setBounds(34, 101, 558, 519);
		panel.add(lblNewLabel_6);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passwordField_1.setBorder(new MatteBorder(0,0,1,1,Color.blue));
		passwordField_1.setBounds(649, 466, 203, 25);
		panel.add(passwordField_1);
		passwordField_1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                validatePassword(passwordField.getPassword());
            }
        });
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Signup.class.getResource("/CMS/icon/account.png")));
		lblNewLabel_8.setBounds(612, 218, 58, 41);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(Signup.class.getResource("/CMS/icon/mail.png")));
		lblNewLabel_9.setBounds(612, 292, 45, 25);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(Signup.class.getResource("/CMS/icon/key12.png")));
		lblNewLabel_10.setBounds(602, 403, 45, 42);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(Signup.class.getResource("/CMS/icon/key12.png")));
		lblNewLabel_11.setBounds(602, 455, 45, 48);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Signup.class.getResource("/CMS/icon/account.png")));
		lblNewLabel_1.setBounds(612, 148, 45, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("User Type");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(656, 134, 203, 13);
		panel.add(lblNewLabel_3);
		 
		 JCheckBox checkBox2 = new JCheckBox("Show");
		 checkBox2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		 checkBox2.setBorderPainted(false); 
		 checkBox2.setContentAreaFilled(false); 
		 checkBox2.setFocusPainted(false); 
		 checkBox2.setOpaque(false);
		 checkBox2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		 if (checkBox2.isSelected()) {
		 			passwordField.setEchoChar((char) 0);
		             passwordField_1.setEchoChar((char) 0); // Show the password
		         } else {
		        	 passwordField.setEchoChar('*');
		             passwordField_1.setEchoChar('*'); // Hide the password
		         }
		         // Only validate the password if it's not visible
		         if (!checkBox2.isSelected()) {
		             validatePassword(passwordField_1.getPassword());
		         }
		 		
		 	}
		 });
		 checkBox2.setBounds(799, 497, 110, 30);
		 panel.add(checkBox2);
		 
		 JLabel lblNewLabel_2 = new JLabel("Phone Number");
		 lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 lblNewLabel_2.setBounds(656, 327, 110, 13);
		 panel.add(lblNewLabel_2);
		 
		 textField = new JTextField();
		 textField.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(100, 149, 237)));
		 textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 textField.setBounds(649, 350, 203, 25);
		 panel.add(textField);
		 textField.setColumns(10);
		 
		 JLabel lblNewLabel_4 = new JLabel("New label");
		 lblNewLabel_4.setIcon(new ImageIcon(Signup.class.getResource("/CMS/icon/phone-book (1).png")));
		 lblNewLabel_4.setBounds(602, 343, 45, 41);
		 panel.add(lblNewLabel_4);
		
		
	}
	private void validatePassword(char[] cs) {
	    String passwordPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%]).{8,}$";

	    if (!Pattern.matches(passwordPattern, new String(cs))) {
	        // Show a pop-up error for incorrect password format
	        JOptionPane.showMessageDialog(contentPane, "Please enter a password in the required format", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
}
