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
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Signup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username_signup;
	private JTextField uniid_text;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;


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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1043, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlightText);
		panel.setBounds(0, 0, 1034, 690);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Sign Up");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
		lblNewLabel.setBounds(612, 42, 322, 41);
		panel.add(lblNewLabel);
		
		JLabel signup_username = new JLabel("Username");
		signup_username.setFont(new Font("Times New Roman", Font.BOLD, 16));
		signup_username.setBounds(649, 127, 80, 13);
		panel.add(signup_username);
		
		username_signup = new JTextField();
		username_signup.setBorder(new MatteBorder(0,0,1,1,Color.blue));
		username_signup.setBounds(649, 150, 203, 25);
		panel.add(username_signup);
		username_signup.setColumns(10);
		
		
		
		JLabel uniId = new JLabel("University Id");
		uniId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		uniId.setBounds(649, 202, 122, 13);
		panel.add(uniId);
		
		uniid_text = new JTextField();
		uniid_text.setBorder(new MatteBorder(0,0,1,1,Color.blue));
		uniid_text.setBounds(649, 231, 203, 25);
		panel.add(uniid_text);
		uniid_text.setColumns(10);
		
		JLabel pass = new JLabel("Password");
		pass.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pass.setBounds(649, 278, 203, 13);
		
		panel.add(pass);
		
		JLabel pass2 = new JLabel("Confirm Password");
		pass2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pass2.setBounds(649, 355, 137, 13);
		panel.add(pass2);
		
		JLabel lblNewLabel_5 = new JLabel("Course");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(649, 419, 122, 13);
		panel.add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(0, 0, 255), 1, true));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select the course","BCS", "BIBM"}));
		comboBox.setBounds(649, 442, 203, 25);
		panel.add(comboBox);
		
		JComboBox mode = new JComboBox();
		mode.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		mode.setModel(new DefaultComboBoxModel(new String[] {"Select the mode","Admin", "Teacher", "Student"}));
		mode.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		mode.setBackground(SystemColor.text);
		mode.setBounds(649, 511, 203, 25);
		panel.add(mode);
		
		JLabel lblNewLabel_7 = new JLabel("Already have an account?");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_7.setBounds(628, 602, 152, 18);
		panel.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Sign Up");
		JComboBox<String> comboSelectMode = mode;
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					String username = username_signup.getText().trim();
					String univ=uniid_text.getText().trim();
					String password = passwordField.getText().trim();
					String password1=passwordField_1.getText().trim();
					String value = (String) comboBox.getSelectedItem();
					String value1 = (String) comboSelectMode.getSelectedItem();
			
					
//					System.out.println(username);
//					System.out.println(univ);
//					System.out.println(password);
//					System.out.println(password1);
					
					if(!username.equals("")&&(!univ.equals(""))&&(!password.equals(""))&&(!password1.equals(""))&&(!value.equals(""))&&(!value1.equals(""))) {
						
					if(password.equals(password1)) {
						JOptionPane.showMessageDialog(null, "Successfully created the account!!!");
//						System.out.println(value);
						Connection con;
						String url="jdbc:mysql://localhost:3306/cms";
						String username1 = "root";
						String passwords="";
						
						try {
							con=DriverManager.getConnection(url,username1,password1);
							Statement st = con.createStatement();
							String insertQuery = "INSERT INTO course (Username,uniId,Password,Course,mode) VALUES ('"+username+"', '"+univ+"', '"+password+"', '"+value+"', '"+value1+"')";
							st.execute(insertQuery);
							con.close();
							System.out.println("Connect");
							
						
							con.close();
						}catch(Exception ee) {
							System.out.println(ee);;
						}
					}
						else {
							JOptionPane.showMessageDialog(null, "Password does not match!!");
						}
					
					}
			
					else {
						JOptionPane.showMessageDialog(null, "Login denied!");
					}
					
					
					
					
				
			}
		});
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(628, 557, 267, 35);
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
				
					new Login().setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(767, 601, 85, 21);
		panel.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(0,0,1,1,Color.blue));
		passwordField.setBounds(649, 301, 203, 25);
		panel.add(passwordField);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Signup.class.getResource("/CMS/image/signup (1).jpg")));
		lblNewLabel_6.setBounds(10, 60, 558, 519);
		panel.add(lblNewLabel_6);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(new MatteBorder(0,0,1,1,Color.blue));
		passwordField_1.setBounds(649, 378, 203, 25);
		panel.add(passwordField_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Signup.class.getResource("/CMS/icon/account.png")));
		lblNewLabel_8.setBounds(615, 134, 45, 41);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(Signup.class.getResource("/CMS/icon/mail.png")));
		lblNewLabel_9.setBounds(615, 232, 45, 13);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(Signup.class.getResource("/CMS/icon/key12.png")));
		lblNewLabel_10.setBounds(602, 301, 45, 42);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(Signup.class.getResource("/CMS/icon/key12.png")));
		lblNewLabel_11.setBounds(602, 365, 45, 48);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(Signup.class.getResource("/CMS/icon/course.png")));
		lblNewLabel_12.setBounds(615, 443, 45, 13);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Signup.class.getResource("/CMS/icon/account.png")));
		lblNewLabel_2.setBounds(615, 510, 45, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Signup.class.getResource("/CMS/icon/account.png")));
		lblNewLabel_1.setBounds(590, 487, 45, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("User Type");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(649, 487, 203, 13);
		panel.add(lblNewLabel_3);
		
		
		
		
	}
}
