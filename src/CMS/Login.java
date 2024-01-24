package CMS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextArea user_text;
	private JPanel panel;
	private JPanel cardPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 703);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(SystemColor.textHighlightText);
		panel.setBounds(0, 0, 1034, 690);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel login = new JLabel("Login");
		login.setBounds(659, 70, 91, 73);
		login.setFont(new Font("Segoe UI", Font.BOLD, 30));
		panel.add(login);
		
		JLabel username = new JLabel("Username");
		username.setBounds(659, 185, 100, 26);
		username.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel.add(username);
		
		user_text = new JTextArea();
		user_text.setBorder(new MatteBorder(0,0,1,1,Color.blue));
		user_text.setBounds(659, 221, 203, 25);
		panel.add(user_text);
		
		
		
		JLabel password = new JLabel("Password");
		password.setBounds(659, 274, 91, 13);
		password.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel.add(password);
		
		JLabel lblNewLabel = new JLabel("User Type");
		lblNewLabel.setBounds(659, 378, 91, 13);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(SystemColor.textHighlight, 1, true));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.setBounds(659, 416, 203, 30);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select the mode","Admin", "Teacher", "Student"}));
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Don't have an account?");
		lblNewLabel_1.setBounds(659, 537, 156, 13);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(0,0,1,1,Color.blue));
		passwordField.setBounds(659, 318, 203, 25);
		panel.add(passwordField);
		
		
		
		JButton button_1 = new JButton("Sign Up");
		
		button_1.setBackground(SystemColor.window);
		button_1.setFont(new Font("Dialog", Font.BOLD, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Signup().setVisible(true);
			}
		});
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setBounds(779, 533, 91, 21);
		button_1.setBorderPainted(false); 
        button_1.setContentAreaFilled(false); 
        button_1.setFocusPainted(false); 
        button_1.setOpaque(false);
		button_1.setActionCommand("Sign Up");
		panel.add(button_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBorder(null);
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/CMS/icon/account.png")));
		lblNewLabel_3.setBounds(614, 197, 65, 61);
		panel.add(lblNewLabel_3);
		
//		JLabel lblNewLabel_5 = new JLabel("");
//		lblNewLabel_5.setIcon(new ImageIcon(Login.class.getResource("/CMS/icon/key.png")));
//		lblNewLabel_5.setBounds(807, 116, 34, 37);
//		panel.add(lblNewLabel_5);
//		
//		JLabel lblNewLabel_6 = new JLabel("");
//		lblNewLabel_6.setIcon(new ImageIcon(Login.class.getResource("/CMS/icon/key.png")));
//		lblNewLabel_6.setBounds(838, 143, 45, 39);
//		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/CMS/icon/key12.png")));
		
		lblNewLabel_4.setBounds(608, 294, 65, 61);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = user_text.getText();
				String password = passwordField.getText();
				String value = comboBox.getSelectedItem().toString();
				
				if(!username.equals("")&&(!password.equals(""))&&(!value.equals(""))) {
					Connection con;
					String url="jdbc:mysql://localhost:3306/cms";
					String username1 = "root";
					String passwords="";
					
						
						try {
							con=DriverManager.getConnection(url,username1,passwords);
							Statement st = con.createStatement();
							
							String selectQuery = "SELECT * FROM course WHERE Username = '"+username+"' AND Password = '"+password+"' AND mode = '"+value+"'";
							
							ResultSet rs = st.executeQuery(selectQuery);
							if(rs.next()) {
								JOptionPane.showMessageDialog(null, "Login Sucessfully!!!");
								
								switch(value) {
								case "Student":
									new Student().setVisible(true);
									break;
								case "Admin":
									new Admin().setVisible(true);
									break;
								case "Teacher":
									new Teacher().setVisible(true);
									break;
								default:
									JOptionPane.showMessageDialog(null, "Unsupported User Mode:"+value);
								
									
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "DataBase value did not matched");
							}
						
							
						}catch(Exception ee) {
							System.out.println(ee);;
						}
					}
						
					
					
			
					else {
						JOptionPane.showMessageDialog(null, "Login denied!");
					}
					
					
			
			}	
				
			
		});
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setForeground(Color.white);
		btnNewButton.setBounds(659, 470, 203, 30);
		panel.add(btnNewButton);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/CMS/image/login1 (1).jpg")));
		lblNewLabel_2.setBounds(10, 10, 901, 707);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Login.class.getResource("/CMS/icon/account.png")));
		lblNewLabel_5.setBounds(614, 401, 45, 28);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Login.class.getResource("/CMS/icon/account.png")));
		lblNewLabel_6.setBounds(634, 401, 45, 43);
		panel.add(lblNewLabel_6);
//		new ImageIcon(Login.class.getResource("/CMS/image/fimage12.png"))

		
	}
}
