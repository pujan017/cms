package CMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class Teacher extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String username;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher frame = new Teacher(username);
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
	public Teacher(String username) {

		 this.username = username;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 289, 664);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setIcon(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TeacherDa().setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBounds(70, 82, 178, 41);
		btnNewButton.setBorderPainted(false); 
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setFocusPainted(false); 
		btnNewButton.setOpaque(false);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Assignement");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TeacherAs().setVisible(true);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_2.setBounds(63, 165, 205, 33);
		btnNewButton_2.setBorderPainted(false); 
		btnNewButton_2.setContentAreaFilled(false); 
		btnNewButton_2.setFocusPainted(false); 
		btnNewButton_2.setOpaque(false);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Marking");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TeacherMa().setVisible(true);
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_3.setBounds(70, 237, 163, 33);
		btnNewButton_3.setBorderPainted(false); 
		btnNewButton_3.setContentAreaFilled(false); 
		btnNewButton_3.setFocusPainted(false); 
		btnNewButton_3.setOpaque(false);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_4) {
					int a=JOptionPane.showConfirmDialog(contentPane,"Are you sure?");
				    if(a==JOptionPane.YES_OPTION) {
				    	dispose();
				    	Login obj=new Login();
				    	obj.setVisible(true);
				    }
				
				}
			}
		});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton_4.setBounds(47, 573, 205, 33);
		btnNewButton_4.setBorderPainted(false); 
		btnNewButton_4.setContentAreaFilled(false); 
		btnNewButton_4.setFocusPainted(false); 
		btnNewButton_4.setOpaque(false);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Teacher.class.getResource("/CMS/icon/dashboard (1).png")));
		lblNewLabel_7.setBounds(31, 82, 52, 41);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Teacher.class.getResource("/CMS/icon/assignment (1).png")));
		lblNewLabel_8.setBounds(38, 153, 45, 46);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(Teacher.class.getResource("/CMS/icon/report (1).png")));
		lblNewLabel_9.setBounds(38, 222, 51, 48);
		panel.add(lblNewLabel_9);
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(287, 0, 733, 112);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblWelcomeBijayKumar = new JLabel("Welcome, Teacher");
		lblWelcomeBijayKumar.setBounds(45, 39, 344, 42);
		panel_1.add(lblWelcomeBijayKumar);
		lblWelcomeBijayKumar.setFont(new Font("Times New Roman", Font.BOLD, 35));
		
		JLabel lblNewLabel_1 = new JLabel("Your Details:");
		lblNewLabel_1.setBounds(333, 148, 200, 30);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new MatteBorder(1, 1, 5, 5, (Color) new Color(100, 149, 237)));
		panel_2.setBounds(333, 215, 614, 305);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(75, 76, 73, 25);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(75, 125, 203, 25);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Your Module");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(75, 177, 155, 25);
		panel_2.add(lblNewLabel_3);
//		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4.setBounds(158, 76, 203, 25);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_5.setBounds(255, 125, 203, 25);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_6.setBounds(231, 177, 125, 25);
		panel_2.add(lblNewLabel_6);
 
		// Remove these lines in the displayInformation method:
		// lblNewLabel_4 = new JLabel("");
		// lblNewLabel_5 = new JLabel("");
		// lblNewLabel_6 = new JLabel("");

		// Remove these lines as well, as they're already initialized in the constructor:
		// panel_2.add(lblNewLabel_4);
		// panel_2.add(lblNewLabel_5);
		// panel_2.add(lblNewLabel_6);

		try {
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "");

		    String query = "SELECT Username, phone_number, Course FROM signup WHERE Username = ?";

		    PreparedStatement preparedStatement = connection.prepareStatement(query);
		    preparedStatement.setString(1, this.username);

		    ResultSet resultSet = preparedStatement.executeQuery();

		    if (resultSet.next()) {
		        String name = resultSet.getString("Username");
		        String phoneNumber = resultSet.getString("phone_number");
		        String module = resultSet.getString("Course");

		        // Use 'this' to refer to instance variables
		        lblNewLabel_4.setText(name);
		        lblNewLabel_5.setText(phoneNumber);
		        lblNewLabel_6.setText(module);

		        // Debug print statements
		        System.out.println("Name: " + name);
		        System.out.println("Phone Number: " + phoneNumber);
		        System.out.println("Module: " + module);

		        // Update the GUI
		        panel_2.revalidate();
		        panel_2.repaint();
		    } else {
		        System.out.println("No data found for the specified username");
		    }

		    resultSet.close();
		    preparedStatement.close();
		    connection.close();

		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}}
